package com.alan.nio.reactorsample;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
/**
 * 代码来源：https://www.cnblogs.com/crazymakercircle/p/9833847.html#autoid-h2-9-0-5
 * <p>
 * Reactor + Handler 单线程Reactor模型
 * Reactor（单线程） + MthreadHandler （线程池）
 * MultiReactor(单线程 ? 是否有问题，可设计成多线程？) + MthreadHandler(线程池)
 */
class MthreadReactor implements Runnable {
    //subReactors集合, 一个selector代表一个subReactor
    Selector[] selectors = new Selector[2];
    int next = 0;
    final ServerSocketChannel serverSocket;

    MthreadReactor(int port) throws IOException { //Reactor初始化
        selectors[0] = Selector.open();
        selectors[1] = Selector.open();
        serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(port));
        //非阻塞
        serverSocket.configureBlocking(false);


        //分步处理,第一步,接收accept事件
        SelectionKey sk = serverSocket.register(selectors[0], SelectionKey.OP_ACCEPT);
        //attach callback object, Acceptor
        sk.attach(new Acceptor());
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                for (int i = 0; i < 2; i++) {
                    selectors[i].select();
                    Set selected = selectors[i].selectedKeys();
                    Iterator it = selected.iterator();
                    while (it.hasNext()) {
                        //Reactor负责dispatch收到的事件
                        dispatch((SelectionKey) (it.next()));
                    }
                    selected.clear();
                }

            }
        } catch (IOException ex) { /* ... */ }
    }

    void dispatch(SelectionKey k) {
        Runnable r = (Runnable) (k.attachment());
        //调用之前注册的callback对象
        if (r != null) {
            r.run();
        }
    }


    class Acceptor { // ...
        public synchronized void run() throws IOException {
            SocketChannel connection =
                    serverSocket.accept(); //主selector负责accept
            if (connection != null) {
                new Handler(selectors[next], connection); //选个subReactor去负责接收到的connection
            }
            if (++next == selectors.length) next = 0;
        }
    }

}

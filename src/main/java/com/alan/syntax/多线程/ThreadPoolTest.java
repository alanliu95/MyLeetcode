package com.alan.syntax.多线程;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolTest {
    public static void main(String[] args) {
        test2();
        //MatchCounter t= new MatchCounter(new File("E:\\Liusong\\JAVA\\dd"),"hello",null);
        //System.out.println(t.search(new File("E:\\Liusong\\JAVA\\dd\\1.txt"),"hello"));
    }

    public static void test2() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future=executor.submit(()->{ return 1+3;});
        try{
            System.out.println(future.get());
        }catch (Exception e){}
        executor.shutdown();
    }

    public static void test1() {
        try (Scanner in = new Scanner(System.in)) {
//            System.out.println("输入目录：");
//            String directory = in.nextLine();
//            System.out.println("输入关键字：");
//            String key = in.nextLine();
            ExecutorService pool = Executors.newFixedThreadPool(100);
//            MatchCounter counter = new MatchCounter(new File(directory), key, pool);
            MatchCounter counter = new MatchCounter(new File("E:\\Liusong\\eclipse-workspace"), "test", pool);
            Future<Integer> future = pool.submit(counter);
            System.out.println(future.get() + " matching files.");
            pool.shutdown();
            //in.next();
        } catch (Exception e) {

        }
    }
}
class MatchCounter implements Callable<Integer> {
    private File directory;
    private String key;
    private ExecutorService pool;

    public MatchCounter(File directory, String key, ExecutorService pool) {
        this.directory = directory;
        this.key = key;
        this.pool = pool;
    }

    @Override
    public Integer call() throws Exception{
        File[] files=this.directory.listFiles();
        ArrayList<Future<Integer>> futures=new ArrayList<>();
        int count=0;
        for (File f:files) {
            if(f.isDirectory()){
                Future<Integer> future=pool.submit(new MatchCounter(f,key,pool));
                futures.add(future);
            }
            else{
                if(search(f,key))
                    count++;
            }
        }
        for(Future<Integer> future:futures){
            count+=future.get();
        }
        return count;
    }

    public boolean search(File file, String key){
        try(Scanner in=new Scanner(file)) {
            while(in.hasNext()){
                String line =in.nextLine();
                if(line.indexOf(key)>=0) return true;
            }
        }catch (Exception e){

        }
        return false;
    }

}

package com.alan.syntax;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class IntegerProxy {
    public static void main(String[] args){
        Object[] elements=new Object[2];
        elements[0]= Proxy.newProxyInstance(null,Integer.class.getInterfaces(),new IntegerInvoker(1));
        elements[1]= Proxy.newProxyInstance(null,Integer.class.getInterfaces(),new IntegerInvoker(2));
        //System.out.println(elements[0].getClass().getInterfaces()[0]);
//        System.out.println(elements[0].toString());
        Arrays.binarySearch(elements,2);

    }

}

class IntegerInvoker implements InvocationHandler{
    private Object target;

    public IntegerInvoker(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print(target+".");
        System.out.print(method.getName()+" ");
        if(args!=null){
            for(int i=0;i<args.length;i++)
                System.out.print(args[i]);
        }
        System.out.println();
        return method.invoke(target,args);

    }
}

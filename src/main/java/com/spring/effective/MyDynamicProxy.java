package com.spring.effective;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.ByteBuffer;

/**
 * @author chenjunlin  junlin.chen@msn.cn
 * @date 2019-03-26 09:54
 */
public class MyDynamicProxy {
    public static void main(String[] args) {
        HelloImpl hello = new HelloImpl();
        MyInvocationHandler handler = new MyInvocationHandler(hello);
        //
        Hello proxyHello = (Hello) Proxy.newProxyInstance(HelloImpl.class.getClassLoader(),HelloImpl.class.getInterfaces(),handler);
        proxyHello.sayHello();

    }

    interface Hello{
        void sayHello();
    }
    static class HelloImpl implements Hello{

        @Override
        public void sayHello() {
            System.out.println("Hello World!");
        }
    }
    static class MyInvocationHandler implements InvocationHandler {

        private Object target;
        public MyInvocationHandler(Object target){
            this.target = target;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("Invoking syaHello");
            Object result = method.invoke(target,args);
            return result;
        }
    }
}

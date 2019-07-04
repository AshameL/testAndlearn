package shejimoshi.b1Proxy.No2;

import java.lang.reflect.Proxy;

public class MainDemo {
    public static void main(String[] args) {
        // 真实的对象
        Subject realSubject = new RealSubject();

        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(realSubject);
        // 代理对象
        Subject proxySubject = (Subject) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{Subject.class},
                myInvocationHandler);
        proxySubject.sellBook();
        proxySubject.speak();

    }
}

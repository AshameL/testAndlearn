package shejimoshi.b1Proxy.No4手写动代;

import shejimoshi.b1Proxy.No3.Person;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyMeipo implements MyInvocationHandler {

    private Person target;

    // 获取被代理人的资料
    public Object getInstance(Person target)throws Exception{
        this.target= target;
        Class clazz= target.getClass();
        System.out.println("meipo中 被代理的对象是"+clazz);
        return MyProxy.newProxyInstance(new MyClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("你的性别是"+this.target.getSex());
        System.out.println("开始海选");
        this.target.findLove();
        System.out.println("代理完毕，海选结束");
        return null;
    }
}

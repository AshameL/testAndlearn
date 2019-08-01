package shejimoshi.b1Proxy.No4手写动代;

import java.lang.reflect.Method;

public interface MyInvocationHandler {
    public Object invoke(Object proxy, Method method,Object[] args)throws Throwable;
}

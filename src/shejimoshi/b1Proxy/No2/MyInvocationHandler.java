package shejimoshi.b1Proxy.No2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler  implements InvocationHandler {
    private Subject realSubject;

    public MyInvocationHandler(Subject realSubject){
        this.realSubject = realSubject;
    }

    /***
     *
     * @param proxy  代理类
     * @param method    正在调用的方法
     * @param args      方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用代理类");
        if(method.getName().equals("sellBook")){
            int invoke = (int) method.invoke(realSubject,args);
            System.out.println("调用卖书的方法");
            return invoke;
        }else {
            String string = (String) method.invoke(realSubject,args);
            System.out.println("调用说话的方法");
            return string;
        }
    }
}

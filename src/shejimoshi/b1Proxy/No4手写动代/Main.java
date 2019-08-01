package shejimoshi.b1Proxy.No4手写动代;

import shejimoshi.b1Proxy.No3.Meipo;
import shejimoshi.b1Proxy.No3.Person;
import shejimoshi.b1Proxy.No3.XiaoXingXing;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        Person obj = (Person) new MyMeipo().getInstance(new XiaoXingXing());
        System.out.println("main中代理生成的类是:"+obj.getClass());
        obj.findLove();
        /**
         * 原理：
         * 1. 拿到被代理对象的引用，然后获取它的接口
         * 2. jdk代理重新生成一个类，同时实现我们给的代理对象所实现的接口
         * 3. 把被代理对象的引用也拿到了
         * 4. 重新动态生成一个class字节码
         * 5. 然后编译
         */


    }
}

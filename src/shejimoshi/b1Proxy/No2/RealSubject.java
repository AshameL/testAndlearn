package shejimoshi.b1Proxy.No2;

public class RealSubject implements Subject {
    @Override
    public int sellBook() {
        System.out.println("卖书");
        return 1;
    }

    @Override
    public String speak() {
        System.out.println("说话");
        return "张三";
    }
}

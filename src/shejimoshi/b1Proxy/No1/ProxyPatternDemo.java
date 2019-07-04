package shejimoshi.b1Proxy.No1;

public class ProxyPatternDemo {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_10.jpg");

        // 图片加载
        image.display();
        System.out.println("--------");
        // 图片不需要从磁盘加载
        image.display();
    }
}

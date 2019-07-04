package shejimoshi.b1Proxy.No1;

public class ProxyImage  implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display() {
        System.out.println("走了代理----");
        if(realImage == null)
            realImage = new RealImage(fileName);
        realImage.display();
    }
}

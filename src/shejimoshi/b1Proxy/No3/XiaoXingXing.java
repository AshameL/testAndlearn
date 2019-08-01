package shejimoshi.b1Proxy.No3;

public class XiaoXingXing implements Person {
    private String sex = "女";
    private String name = "小星星";

    @Override
    public void findLove() {
        System.out.println("-----find love----");
        System.out.println("我叫" + name + "性别是" + sex);
        System.out.println("我有balabala的择偶标准");
        System.out.println("-----find love----");
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

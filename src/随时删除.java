import java.lang.reflect.Modifier;

public class 随时删除 {
    public static void main(String[] args) throws Exception {
       test();
    }
    private static void test(){
        String abc1 = "百度科技(123)公司1";
        abc1 = abc1.replaceAll("\\\\(","\\(").replaceAll("\\\)","\\)");
        System.out.println(abc1);
    }

}
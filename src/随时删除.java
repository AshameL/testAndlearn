import java.lang.reflect.Modifier;

public class 随时删除 {
    public static void main(String[] args) throws Exception {
       test();
    }
    private static void test(){
        float f= 7f;
        for(int i =0;i<3;i++){
            f *=f;
            System.out.println(f);
        }
    }

}
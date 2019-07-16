import java.lang.reflect.Modifier;

public class 随时删除 {
    public static void main(String[] args) throws Exception {
        Class aClass = Class.forName("公众号.Arrays_asList.T1");
        String className = aClass.getName();
        int modifiers = aClass.getModifiers();
        boolean b = Modifier.isPrivate(modifiers);
        System.out.println(modifiers);
        System.out.println(b);

    }


}
package interview;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 正则 {
    public static void main(String args[]) {
        String str = "【万科城市1之光·东望】万科城市之光·东望单价51585 总价350万起";
        String s = dealProjectNameOfTitle(str);
        System.out.println(s);
    }

    public static String dealProjectNameOfTitle(String newTitle) {
        // 返回的newTitle以形如【..】.... 展示，可以确定【】两个字符是必定存在的。
        // 第一个 】
        int firstIndexRightParenthesis = newTitle.indexOf('】');
        String projectNameInParenthesis = newTitle.substring(1, firstIndexRightParenthesis);
        String otherPart = newTitle.substring(firstIndexRightParenthesis + 1);
        String afterReplace = otherPart.replaceFirst(projectNameInParenthesis, "");
        return "【"+projectNameInParenthesis+"】"+afterReplace;
    }
}

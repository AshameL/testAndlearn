package leetcode.string;

public class No125_验证回文串 {

    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z')
                sb.append(c);
            if (c >= 'A' && c <= 'Z') {
                c = (char) (c - 'A' + 'a');
                sb.append(c);

            }
            if (c >= '0' && c <= '9')
                sb.append(c);

        }
        s = sb.toString();

        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }
        return true;

    }

    public static void main(String[] args) {
        boolean t = isPalindrome("0P");
        System.out.println(t);
    }
    // 拓展：左程云进阶班，数字判断回文
}

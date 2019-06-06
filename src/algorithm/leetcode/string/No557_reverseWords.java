package algorithm.leetcode.string;

public class No557_reverseWords {
    public static  String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (String i : arr) {
            res.append(reverseString(i));
            res.append(" ");

        }
        return res.substring(0, res.length() - 1);
    }



    public static String reverseString(String s) {
        char[] chars = s.toCharArray();
        int half = s.length() / 2;
        for (int i = 0; i < half; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String ss = reverseWords(s);
        System.out.println(ss);
    }
}

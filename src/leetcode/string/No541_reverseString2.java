package leetcode.string;

public class No541_reverseString2 {
    public String reverseStr(String s, int k) {
        if (s.length() <= k)
            return new StringBuilder(s).reverse().toString();
        else if (s.length() <= 2 * k)
            return new StringBuilder(s.substring(0, k)).reverse().toString() + s.substring(k);
        String result = "";
        while (s.length() > 2 * k) {
            result += reverseStr(s.substring(0, 2 * k), k);
            s = s.substring(2 * k);
        }
        result += reverseStr(s, k);
        return result;
    }

    public static void main(String[] args) {

    }
}

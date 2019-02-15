package leetcode.string;

public class No151_reverseWordsInAString {

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        if (s == null || "".equals(s.trim()))
            return "";

        String[] strs = s.trim().split("\\s");
        int len = strs.length - 1;
        for (int i = len; i >= 0; i--) {
            if (i == 0)
                sb.append(strs[i]);
            else
                sb.append(strs[i] + " ");
        }
        return sb.toString();
    }
    //"   a   b "
    //"b   a"
}

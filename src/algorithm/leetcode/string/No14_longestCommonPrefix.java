package algorithm.leetcode.string;

public class No14_longestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        StringBuilder res = new StringBuilder("");
        int flag = 0;
        for (int out = 0; out < strs[0].length(); out++) {

            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() == out || strs[0].charAt(out) != strs[i].charAt(out)) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1)
                break;
            res.append(strs[0].charAt(out));
        }
        return res.toString();
    }

    public static void main(String[] args) {
//        String[] str = {"dog", "racecar", "car"};
        String[] str = {"flower", "flow", "flight"};
        String res = longestCommonPrefix(str);
        System.out.println(res);
    }
}

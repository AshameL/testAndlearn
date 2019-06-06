package algorithm.leetcode.数组.双指针;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class No76_minWindow {
    //S = "ADOBECODEBANC", T = "ABC"
    public static String minWindow_myMethord(String s, String t) {
        if (s.length() < t.length())
            return "";

        Set<Character> set = new HashSet<>();
        for (char c : t.toCharArray()) {
            if (!set.contains(c)) {
                set.add(c);
            }
        }

        Map<Character, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int minStart = 0, minEnd = 0;

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char val = s.charAt(right);

            if (set.contains(val)) {
                if (map.containsKey(val)) {
                    map.put(val, map.get(val) + 1);
                } else {
                    map.put(val, 1);
                }
            }
            if (set.size() == map.keySet().size()) {

                // 左边缩
                while (left <= right && set.size() == map.keySet().size()) {
                    min = Math.min(min, right - left + 1);
                    minStart = left;
                    minEnd = right;
                    char valLeft = s.charAt(left);
                    if (map.containsKey(valLeft)) {
                        if (map.get(valLeft) == 1) {
                            map.remove(valLeft);
                        } else {
                            map.put(valLeft, map.get(valLeft) - 1);
                        }
                    }
                    left++;

                }
            }
        }
        if (min < Integer.MAX_VALUE)
            return s.substring(minStart, minEnd + 1);
        return "";
    }

    public static void main(String[] args) {
        String S = "ADOBECODEBANC";
        String T = "ABC";
//        String S = "a";
//        String T = "a";
        String res = minWindow_myMethord(S, T);
        System.out.println(res);
    }
}

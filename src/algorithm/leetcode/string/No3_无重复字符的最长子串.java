package algorithm.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class No3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2)
            return s.length();
        int n = s.length();// 数组大小
        Set<Character> set = new HashSet<>();
        int max = 0, left = 0, right = 0;
        while (left < n && right < n) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                max = Math.max(max, right - left);
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }
}

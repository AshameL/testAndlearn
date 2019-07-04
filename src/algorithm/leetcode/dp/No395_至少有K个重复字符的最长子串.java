package algorithm.leetcode.dp;

public class No395_至少有K个重复字符的最长子串 {
    public int longestSubstring(String s, int k) {
        if (s.length() < k)
            return 0;
        return longestSubstringSub(s, k, 0, s.length() - 1);

    }

    public int longestSubstringSub(String s, int k, int start, int end) {
        if (start > end)
            return 0;
        int[] count = new int[26];
        for (int i = start; i <= end; i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0 && count[i] < k) {
                int pos = s.indexOf((char) (i + 'a'), start);

                //递归
                return Math.max(longestSubstringSub(s, k, start, pos - 1),
                        longestSubstringSub(s, k, pos + 1, end));


            }
        }
        return end - start + 1;
    }

}
/**
 * 思路是分治法。
 * <a1Factory>
 * 要找s[i,j]的最大子串，先统计频数，
 * 然后遍历一遍频数，
 * 找出第一个频数小于k且大于0的字符，
 * 然后找出这个字符的位置，
 * 接下来的分析很重要，
 * 这个字符一定不能出现在任何的子串中，
 * 因为i,j是整个的子串，在ij里面频数都没有达到k，那么在ij的任何子串中，这个字符也不可能达到频数k。
 * 所以不能有这个字符，
 * 那么就在这个位置做一个分治，返回前半部分和后半部分的最大值。
 **/
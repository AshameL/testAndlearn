package algorithm.leetcode.string;

public class No214_最短回文串 {


    /**
     * 暴力破解法
     *
     * @param s
     * @return
     */
    public String shortestPalindrome(String s) {
        int index = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (isPalindrome(s.substring(0, i + 1))) {
                index = i;
                break;
            }
        }
        String result = reverse(s.substring(index + 1));// 找到s尾部，不是回文串的部分。
        return result + s;
    }


    /**
     * 还有两种方法没看。 递归  kmp
     * https://blog.csdn.net/qq_41231926/article/details/86747126
     */

    /**
     * 递归方法
     */

    public String shortestPalindrome2(String s) {
        int i = 0;
        for (int j = s.length() - 1; j >= 0; j--) {
            if (s.charAt(j) == s.charAt(i)) {
                i++;
            }
        }
        if (i == s.length())
            return s;
        return reverse(s.substring(i)) + shortestPalindrome2(s.substring(0, i)) + s.substring(i);
    }

    /**
     * kmp  思路
     * <p>
     * 状态定义：
     * f(x)----字符串s[0，x]范围内，最长相同前后缀（不是本身）的长度
     * 状态转移：
     * f(0) =0         因为[0,0]范围内的字符串长度为1
     * 对于 i 在 [1,n-1]  (n为字符串长度)
     * 1）令temp记录f(x-1)的值，如果temp大于0且s中temp位置的字符和第i个字符不相同，
     * 那么，重设temp的值为f(temp-1)
     * 2) 如果s中第i个字符与第temp个字符相同，令temp自增1
     * 3） f(i) = temp
     */
    public String shortestPalindrome3(String s) {
        String rev = reverse(s);
        String temp = s + "#" + rev;
        int[] next = computeTemporaryArray(temp.toCharArray());
        return rev.substring(0,rev.length()-next[temp.length()-1])+s;
    }

    private int[] computeTemporaryArray(char[] pattern) {
        int[] lps = new int[pattern.length];
        int index = 0;
        for (int i = 1; i < pattern.length; ) {
            if (pattern[i] == pattern[index]) {
                lps[i] = index + 1;
                index++;
                i++;
            } else {
                if (index != 0) {
                    index = lps[index - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private String reverse(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        return stringBuilder.reverse().toString();
    }
    public static void main(String[] args) {
        No214_最短回文串 cur = new No214_最短回文串();
        String s = "ABABCABAA";
        String res = cur.shortestPalindrome3(s);
        System.out.println(res);
    }
}

package algorithm.leetcode.dp;

/**
 * 0716第一次  这人博客不错：https://blog.csdn.net/qq_41231926/article/details/85335825
 */

public class No132_分割回文串2 {
    /***
     * 状态定义：
     *      judge(i,j)---字符串 s[i,j] 范围内子串是否是回文串
     * 状态转移：
     *      if  s.charAt(i)!= s.charAt(j)  judge(i)(j)=false
     *      if  s.charAt(i)==s.charAt(j)
     *          if  j-i<=1，即[i,j]范围内的字符个数小于等于2个，judge(i)(j) = true
     *          else   judge(i)(j)= judge(i+1)(j-1)
     * 通过上述定义和状态转移，很容易得到n*n的二维矩阵judge。用来判断字符串s中[i,j] 子串是否是回文串。
     *  再定义一个状态【这道题难在两种状态定义】
     *  状态定义
     *          dp(i)  s中i到n-1 个字符，构成子串的最小分割次数。
     *  状态转移
     *          在[i,n-1] 范围内寻找切点j，使得满足s中[i,j]范围子串是一个回文串，在所有切点中寻找总的最少的切分次数。
     *                  即 1+dp[j+1] 的最小值，如果 j+1 越界，那么说明 s中[i,j]范围内子串就是一个回文串。
     *
     *
     * @param s
     * @return
     */
    public static int minCut(String s) {
        int n = s.length();
        boolean[][] judge = new boolean[n][n];
        int[] dp = new int[n];// dp[i]表示s中第i个字符到第（n-1）个字符所构成的子串的最小分割次数
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || judge[i + 1][j - 1])) {
                    judge[i][j] = true;
                    if (j + 1 < n)
                        dp[i] = Math.min(dp[i], 1 + dp[j + 1]);
                    else
                        dp[i] = 0;
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int i =minCut("aab");
        System.out.println(i);
    }
}

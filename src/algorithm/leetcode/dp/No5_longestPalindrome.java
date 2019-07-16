package algorithm.leetcode.dp;
/*

No2 ： 2019年7月11日

LeetCode中与回文串相关的免费的题目共有15道
(5, 9, 125, 131, 132, 214, 234, 336, 409, 479, 516, 564, 647, 680, 730)，在此会整理成一个系列。
 */
public class No5_longestPalindrome {
    //  https://blog.csdn.net/Allenlzcoder/article/details/80532200

    /**
     *
     * @param s
     * @return
     *
     * @decription: 维护一个二维的dp数组。dp[i][j]表示字符串区间[i,j]是否是回文串。
     *          当i=j，                   只有一个字符，肯定是回文串。
     *          当i=j+1                    说明是相邻字符，需要判断s[i]和s[j]
     *          当i，j不相邻（i>=j+2）     除判断s[i]s[j]，还判断dp[i+1][j-1]
     *
     *  递推公式：
     *          dp[i,j]  =      1               if i==j
     *                   =      s[i]==s[j]      if i=j+1
     *                   =      s[i]==s[j] && dp[i+i][j-1]   if i>j+1
     */
    public String longestPalindrome1(String s) {
        if (s.isEmpty())
            return s;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int left = 0;
        int right = 0;
        for (int i = n - 2; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);//小于3是因为aba一定是回文
                if (dp[i][j] && right - left < j - i) {
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right + 1);
    }
    public static  String longestPalindrome(String s){
        if (s.isEmpty())
            return s;
        int n = s.length();
        int resLen = 0;
        boolean[][] dp = new boolean[n][n];
        int left=0,right = 0;
        for(int i = 0;i<n;i++){
            dp[i][i] = true;
            for(int j = 0;j<n;j++){
                dp[j][i] = (s.charAt(i)==s.charAt(j)&&(i-j<2||dp[j+1][i-1]));
                if(dp[j][i]&&resLen<i-j+1){// 把最大回文子串长度保存到reslen中
                    resLen = i-j+1;
                    left = j;
                    right = i;

                }
            }
        }
        System.out.println(left);
        System.out.println(right);
        return s.substring(left,right+1);
    }

    public static void main(String[] args) {
        String s = "abcdbbfcba";
        s = "babad";
        String res = longestPalindrome(s);
        System.out.println(res);
    }
}

package leetcode.dp.背包;


import java.util.Arrays;

/**
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 **/
public class No322_零钱兑换 {
    public static int coinChange(int[] coins, int amount) {
        int m = coins.length + 1;
        int n = amount + 1;
        int[][] dp = new int[m][n];
        int res = -1;
        // 这里是不可能的
        for (int i = 1; i < n; i++) {
            dp[0][i] = amount + 1;
        }
        // 这里是价值为0，
        for (int i = 0; i < m; i++) {
            dp[i][0] = 0;
        }

        //

        //
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        res = dp[m - 1][amount] == (amount + 1) ? -1 : dp[m - 1][amount];
        return res;

    }

    public static void main(String[] args) {
        //[186,419,83,408]
        //6249
        int[] coins = {186, 419, 83, 408};
        int amount = 6249;
        int r = coinChange(coins, amount);
        System.out.println(r);
    }
}

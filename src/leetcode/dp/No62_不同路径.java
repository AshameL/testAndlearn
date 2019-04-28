package leetcode.dp;

public class No62_不同路径 {
    // 1 递归
    public int uniquePaths1(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        return uniquePaths1(m, n - 1) + uniquePaths1(m - 1, n);
    }

    // 2 记忆搜索
    public int uniquePaths2(int m, int n) {
        int[][] ways = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; i < n; j++) {
                if (i == 0 || j == 0)
                    ways[i][j] = 1;
                else
                    ways[i][j] = ways[i - 1][j] + ways[i][j - 1];
            }
        }
        return ways[m - 1][n - 1];
    }

    // 3 空间优化
    public int uniquePath3(int m, int n) {
        int[] ways = new int[n];
        ways[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++)
                ways[j] += ways[j - 1];

        }
        return ways[n - 1];

    }

    // 4 digui
    public int uniquePath(int m, int n) {
        int[][] dp = new int[100][100];
        //用dp[i][j]的值代表从起点开始，能够到达该格子（i,j）的方法数（或者路径数）
        //初始化边界条件，令第一行第一列的值全为1，因为要到达第一行第一列上的任意一个格子
        //的方法只有一种，比如，要到达第一行的的任意格子，只能一直往右走；要到达第一列上的格子只能一直往下走
        for (int i = 0; i <= m - 1; ++i)
            dp[i][0] = 1;
        for (int j = 0; j <= n - 1; ++j)
            dp[0][j] = 1;
        //由于机器人只能 往下或者往右走，所以，状态转移方程如下
        for (int i = 1; i <= m - 1; ++i)
            for (int j = 1; j <= n - 1; ++j)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        return dp[m - 1][n - 1];
        //blog.csdn.net/u014450222/article/details/81265852
    }
}

package leetcode.dp;

/**
 * 示例 1:
 * <p>
 * 输入: nums =
 * [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径为 [1, 2, 6, 9]。
 * <p>
 * 示例 2:
 * 输入: nums =
 * [
 * [3,4,5],
 * [3,2,6],
 * [2,2,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 **/

public class No329_最长递增路径 {
    int[][] state = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        int rlen = matrix.length;
        if (rlen == 0) return 0;
        int clen = matrix[0].length;

        int[][] dp = new int[rlen][clen];
        int max = 0;
        for (int i = 0; i < rlen; i++) {
            for (int j = 0; j < clen; j++)
                max = Math.max(dfs(dp, matrix, i, j), max);
        }

        return max;
    }

    private int dfs(int[][] dp, int[][] matrix, int i, int j) {
        if (dp[i][j] != 0) return dp[i][j];
        dp[i][j] = 1;
        for (int[] s : state) {
            int x = i + s[0];
            int y = j + s[1];
            if (x >= 0 && x < matrix.length &&
                    y >= 0 && y < matrix[0].length &&
                    matrix[i][j] < matrix[x][y])
                dp[i][j] = Math.max(dp[i][j], dfs(dp, matrix, x, y) + 1);
        }
        return dp[i][j];
    }
}

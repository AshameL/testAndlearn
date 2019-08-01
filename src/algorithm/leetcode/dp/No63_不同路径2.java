package algorithm.leetcode.dp;

public class No63_不同路径2 {
    /**
     * 1.状态怎么表示
     * 2. 怎么计算每个状态
     * 3. 初始化怎么写
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        if (m == 0 || n == 0)
            return 0;

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0)
                dp[i][0] = 1;
            else
                break;// 直接跳出
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 0)
                dp[0][i] = 1;
            else
                break;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
        //原文：https://blog.csdn.net/u014472643/article/details/81185246

    }
    public int uniquePathsWithObstacles2(int[][] nums){
        int n = nums.length;
        int m = nums[0].length;
        int[][] f =new  int[n][m];
        f[0][0] = 1;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(nums[i][j]!=0){
                    if(i!=0)
                        f[i][j]+=f[i-1][j];
                    if(j!=0)
                        f[i][j]+=f[i][j-1];
                }
            }
        }
        return f[n-1][m-1];
    }
    ////https://www.bilibili.com/video/av35161871?from=search&seid=11838594166018806597  07：24
}

package algorithm.leetcode.dp;

public class No70_climbStairs {
    // 递归
    public int climbStairs1(int n) {
        if (n <= 2)
            return n;
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    // 动态规划
    public int climbStairs(int n) {
        if (n <= 2)
            return n;
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;


        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

}

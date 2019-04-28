package leetcode.dp;

public class No279_完全平方数 {
    public int numSquares(int n) {
        int[] memo = new int[n + 1];
        for (int i = 0; i <= n; i++)
            memo[i] = -1;
        return numSquares(n, memo);

    }

    public int numSquares(int n, int[] memo) {
        // memo 完全平方的个数。
        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }
        int num = Integer.MAX_VALUE;

        if (memo[n] != -1)
            return memo[n];

        for (int i = 1; i <= n; i++) {
            //  i*i + numSquares(n-i*i)
            if (n < i * i)
                break;
            num = Math.min(num, numSquares(n - i * i, memo) + 1);
            memo[n] = num;
            //System.out.println(num);
        }
        return memo[n];
    }
}

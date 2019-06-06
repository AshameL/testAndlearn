package algorithm.leetcode.dp;

public class No96_searchTree {
    //https://blog.csdn.net/qq_38595487/article/details/79598628
    public int numTrees(int n) {
        if (n <= 1)
            return n;

        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;

        for (int i = 2; i <= n; i++)
            for (int j = 0; j < i; j++) {
                nums[i] = nums[i] + nums[j] * nums[i - 1 - j];
            }

        return nums[n];
    }
}

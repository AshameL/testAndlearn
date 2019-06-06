package algorithm.leetcode.dp;

import java.util.ArrayList;

public class No198_打家劫舍 {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        return digui(nums, 0);
    }

    public int digui(int[] nums, int i) {
        if (i >= nums.length)
            return 0;
        int m1 = nums[i] + digui(nums, i + 2);
        int m2 = digui(nums, i + 1);
        int max = Math.max(m1, m2);
        return max;
    }

    public int rob_dp(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(nums[0]);
        dp.add(Math.max(nums[0], nums[1]));

        for (int i = 2; i < nums.length; i++) {
            dp.add(Math.max(nums[i] + dp.get(i - 2), dp.get(i - 1)));
        }
        return dp.get(dp.size() - 1);
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        int res = new No198_打家劫舍().rob(arr);
        int res1 = new No198_打家劫舍().rob_dp(arr);
        System.out.println(res);
        System.out.println(res1);
    }


}

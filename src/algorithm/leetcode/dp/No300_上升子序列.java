package algorithm.leetcode.dp;

import java.util.Arrays;

public class No300_上升子序列 {

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] d = new int[n];
        int len = 1;
        for (int i = 0; i < n; i++) {
            d[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && (d[j] + 1) >= d[i])
                    d[i] = d[j] + 1;
            }
            if (d[i] > len)
                len = d[i];
        }
        return len;
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] arr1 = {2, 2};
        int r = lenOfLIS2(arr);
        System.out.println(r);
    // 这道题 分治法 是最优解
    }
    /**
     * [10,9,2,5,3,7,101,18]
     * 想求18这个数，位置的最长上升子序列，就是之前子数组[10,9,2,5,3,7,18]的最长上升子序列+18
     *
     *
     *
     * @param nums
     * @return
     */
    public int lenOfLIS(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        int maxLen = 0;
        for(int i = 0;i<n;i++){
            int len = 1;
            for(int j = 0;j<i;j++){
                if(nums[j]<nums[i]){
                    len = Math.max(len,dp[j]+1);
                }
            }
            dp[i] = len;
            if(dp[i]>maxLen)
                maxLen = dp[i];
        }
        return maxLen;
    }

    public static int lenOfLIS2(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];

        int len = 0;
        for(int num:nums){
            int index = Arrays.binarySearch(dp,0,len,num);
            //找不到时，会返回 如果该元素在这个数组中，他的index ，+1，再加负号      -（index+1)
            if(index<0){// index = -1
                index = -(index+1);
            }
            dp[index] = num;
            if(index==len){
                len++;
            }
        }
        return len;
    }
}

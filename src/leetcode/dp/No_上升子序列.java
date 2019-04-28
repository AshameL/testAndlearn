package leetcode.dp;

public class No_上升子序列 {
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
        int r = lengthOfLIS(arr);
        System.out.println(r);
// 这道题 分治法 是最优解
    }
}

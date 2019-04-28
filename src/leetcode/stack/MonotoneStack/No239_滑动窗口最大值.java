package leetcode.stack.MonotoneStack;

import java.util.Arrays;

public class No239_滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] a1 = new int[nums.length - k + 1];
        int[] b1 = new int[k];
        for (int i = 0; i < nums.length - k + 1; i++) {
            System.arraycopy(nums, i, b1, 0, k);
            Arrays.sort(b1);
            a1[i] = b1[k - 1];
        }
        return a1;
    }
}

package leetcode.数组;

public class No88_merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m + n - 1;
        while (m > 0 && n > 0) {
            // 优先级是先比较，再赋值
            nums1[p--] = nums1[m-1] > nums2[n-1] ? nums1[m--]:nums2[n--];
        }
        while (n>0)
            nums1[p--]=nums2[n--];
        ///////???  边界有问题
    }
}

package leetcode.递归;

import java.util.LinkedList;
import java.util.List;

public class No4_两有序数列求中位数 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lengthA = nums1.length;
        int lengthB = nums2.length;
        int len = lengthA + lengthB;

        if (len % 2 == 0) {
            return
                    (findKth(nums1, nums2, 0, 0, len / 2)
                            + findKth(nums1, nums2, 0, 0, len / 2 + 1)
                    ) / 2.0;
        } else {
            return findKth(nums1, nums2, 0, 0, len / 2 + 1);
        }

    }

    public static double findKth(int[] nums1, int[] nums2, int starta, int startb, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        if (starta >= len1) {
            return nums2[startb + k - 1];
        }
        if (startb >= len2)
            return nums1[starta + k - 1];
        // 第 1 个数。下表是0.   递归出口。
        if (k == 1) {
            return Math.min(nums1[starta], nums2[startb]);
        }

        int mid = k / 2 - 1;
        int keyPoint1 = starta + mid >= len1 ? Integer.MAX_VALUE : nums1[starta + mid];
        int keyPoint2 = startb + mid >= len2 ? Integer.MAX_VALUE : nums2[startb + mid];
        //
        if (keyPoint1 > keyPoint2) {
            return findKth(nums1, nums2, starta, startb + k / 2, k - k / 2);
        } else
            return findKth(nums1, nums2, starta + k / 2, startb, k - k / 2);

//https://www.cnblogs.com/lupx/p/lupeixin.html  这个url讲的好
    }

    public static double findKth(int[] nums1, int[] nums2, int k) {
        if (nums1.length > nums2.length)
            return findKth(nums2, nums1, k);
        if (nums1.length == 0)
            return nums2[k - 1];
        if (nums2.length == 0)
            return nums1[k - 1];
        if (k == 1)
            return Math.min(nums1[0], nums2[0]);
        // s tart
        int s = nums1.length;
        int p1 = Math.min(k / 2, s);
        int p2 = k - p1;
        // judge
        if (nums1[p1 - 1] < nums2[p2 - 1]) {
            int[] n1 = new int[nums1.length - p1];
            for (int i = p1, j = 0; i < nums1.length; i++, j++)
                n1[j] = nums1[i];

            int[] n2 = new int[p2];
            for (int i = 0, j = 0; i < p2; i++, j++)
                n2[j] = nums2[i];


            return findKth(n1, n2, k - p1);
        } else {
            int[] n1 = new int[p1];
            for (int i = 0, j = 0; i < nums1.length; i++, j++)
                n1[j] = nums1[i];

            int[] n2 = new int[nums2.length - p2];
            for (int i = p2, j = 0; i < nums2.length; i++, j++)
                n2[j] = nums2[i];


            return findKth(n1, n2, k - p2);
        }


    }
}

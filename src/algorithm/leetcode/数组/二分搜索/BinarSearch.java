package algorithm.leetcode.数组.二分搜索;

// 请看
//package algorithm.dataStruction.BinarySearch
public class BinarSearch {
    //1 .
    public static int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    // 2. 递归的
    public static int binarySearch_Re(int[] nums, int target, int low, int high) {
        if (low > high)
            return -1;
        int mid = (low + high) >> 1;
        if (nums[mid] == target)
            return mid;
        if (nums[mid] < nums[target])
            return binarySearch_Re(nums, target, mid + 1, high);
        else
            return binarySearch_Re(nums, target, low, mid - 1);
    }

    //变体1，查找第一个值等于给定值的元素
    public int bsearch1(int[] a, int value) {
        int n = a.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (high + low) >> 1;
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == 0) || (a[mid - 1] != value))
                    return mid;
                else
                    high = mid - 1;
            }
        }
        return -1;
    } // 变形2，查找最后一个等于给定值的元素

    // 变体3，查找第一个大于给定值的元素
    public int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (a[mid] >= value) {
                if ((mid == 0) || (a[mid - 1] < value))
                    return mid;
                else
                    high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    // 变体4 ，查找最后一个小于给定值的元素

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 3;

        int res = binarySearch(arr, target);
        int res1 = binarySearch_Re(arr, target, 0, arr.length - 1);

        System.out.println(res);
        System.out.println(res1);
    }
}

package algorithm.leetcode.数组.二分搜索;

public class No33_搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    public int search(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) >> 1;
        if (nums[mid] == target)
            return mid;
        if (nums[mid] < nums[high]) { // 右半段有序
            if (nums[mid] < target && target <= nums[high]) { // target落在右半端中，
                return search(nums, mid + 1, high, target);
            } else {
                return search(nums, low, mid - 1, target);
            }
        } else { //右半段是两个有序数组，那么来看左半段
            if (nums[low] <= target && target < nums[mid]) { // target在左半端中，
                return search(nums, low, mid - 1, target);
            } else {
                return search(nums, mid + 1, high, target);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int res = new No33_搜索旋转排序数组().search(nums, target);
        System.out.println(res);
    }

}

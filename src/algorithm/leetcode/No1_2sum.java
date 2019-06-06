package algorithm.leetcode;

import java.util.HashMap;

public class No1_2sum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = 1;
                res[1] = map.get(target - nums[i]);
                return res;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }


    public static int[] twoSum_适合有序的数组(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < target) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] + nums[j] == target) {
                        res[0] = j;
                        res[1] = i;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int[] r = twoSum(arr, 9);
        System.out.println(r[0]);
        System.out.println(r[1]);
    }
}

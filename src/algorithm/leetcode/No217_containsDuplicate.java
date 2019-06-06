package algorithm.leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class No217_containsDuplicate {
    // 暴力解法
    public boolean containsDuplicate1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }
        return numSet.size() != nums.length;
    }

    public boolean containsDuplicate(int[] nums) {
        if (nums.length <= 1)
            return false;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                return true;

        }
        return false;
    }
}

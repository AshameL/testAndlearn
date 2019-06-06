package algorithm.leetcode.LinkList;

public class No136_singleNumber {
    public int singleNumber(int[] nums) {
        // 使用抑或
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}

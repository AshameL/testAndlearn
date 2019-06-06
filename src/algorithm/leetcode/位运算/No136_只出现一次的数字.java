package algorithm.leetcode.位运算;

public class No136_只出现一次的数字 {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i : nums)
            res ^= i;
        return res;
    }

}

package algorithm.leetcode.位运算;

public class No137_只出现一次的数字2 {
    public static int singleNumber(int[] nums) {
        int len = nums.length;
        int[] bits = new int[32];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 32; j++) {
                bits[j] += ((nums[i] >> j) & 1);
            }
        }

        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i] % 3 == 1)
                res += 1 << i;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 2};
        int res = singleNumber(arr);
        System.out.println(res);
    }

    private static void myprint(int[] n) {
        for (int i : n)
            System.out.print(i + " ");
        System.out.println();
    }
}

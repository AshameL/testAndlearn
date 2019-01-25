package leetcode.位运算;

public class No231_powerOf2 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }
}

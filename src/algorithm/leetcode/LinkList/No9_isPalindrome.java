package algorithm.leetcode.LinkList;

public class No9_isPalindrome {
    //你能不将整数转为字符串来解决这个问题吗？
    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int a = 0;
        int b = x;
        while (x > 0) {
            a = a * 10 + x % 10;
            x /= 10;
            System.out.println(a);
        }
        if (a == b)
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(13321));
    }
}

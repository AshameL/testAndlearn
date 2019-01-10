package offerJianZhi;

public class 求1到n的和 {
    /***
     * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     */
    public int Sum_Solution(int n) {
        return f(n);
    }

    private int f(int n) {
        if (n == 0)
            return 0;
        return n + f(n - 1);
    }

    public static void main(String[] args) {

    }
    /***
     * 一个奇怪的写法，没理解
     *  int Sum_Solution(int n) {
     *         int ans = n;
     *         ans && (ans += Sum_Solution(n - 1));
     *         return ans;
     *     }
     */
}

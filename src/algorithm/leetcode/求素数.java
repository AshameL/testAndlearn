package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class 求素数 {

    public static List<Integer> method1(int n) {
        int num = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            // 判断是不是素数
            int j = 2;
            for (; j < i; j++) {
                if (i % j == 0) {

                    break;
                }
            }
            if (j == i) {
                num++;
                res.add(j);
            }
        }
        return res;
    }

    //素数筛法// 埃拉托色尼 素数筛选法{
    public static boolean[] eratos_prime(int n) {
        boolean[] ans = new boolean[(int) n];
        for (int i = 0; i < n; i++) {
            ans[i] = true;
        }
        ans[0] = ans[1] = false;
        for (int i = 2; i <= n; i++) {
            if (ans[i]) { // 若它是素数。去掉他的倍数
                for (int j = 2; i * j < n; j++) {
                    ans[i * j] = false;
                }

            }
        }
        return ans;
    }

}
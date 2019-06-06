package algorithm.offerJianZhi;

import java.util.ArrayList;

public class 字符串的排列 {
    // 原题：答案 https://www.nowcoder.com/questionTerminal/fe6b651b66ae47d7acce78ffdd9a96c7


    // 贝壳面试：ABCD 输出长度为3的字符串，有多少种输出。
    public ArrayList<String> printABCD() {
        char[] abcd = {'a', 'b', 'c', 'd'};
        int[] vis = {0, 0, 0, 0};
        ArrayList<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        dfs(abcd, vis, res, sb);
        return res;
    }

    private void dfs(char[] c, int[] vis, ArrayList<String> res, StringBuilder sb) {
        if (sb.length() == 3) {
            res.add(sb.toString());
            return;
        }

        for (int i = 0; i < c.length; i++) {
            if (vis[i] == 0) {
                sb.append(c[i]);
                vis[i] = 1;
                dfs(c, vis, res, sb);
                vis[i] = 0;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<String> r= new 字符串的排列().printABCD();
        System.out.println(r);
    }

}

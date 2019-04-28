package leetcode.dp;

import java.util.*;

public class No139_wordBreak {
    public boolean wordBreak(String s, List<String> dict) {
        if (dict.contains(s))
            return true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        // 使用set去检查去除重复计算
        // 这是时间复杂度降到O(N^2)的关键
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        while (!queue.isEmpty()) {
            int curIdx = queue.poll();
            for (int i = curIdx + 1; i <= s.length(); i++) {
                if (visited.contains(i))
                    continue;
                if (dict.contains(s.substring(curIdx, i))) {
                    // 如果达到中重点
                    // 注意此时的i是curIdx+1
                    if (i == s.length())
                        return true;
                    queue.offer(i);
                    visited.add(i);
                }
            }
        }
        return false;

    }

    //digui 解法

    public boolean wordBreak_dp(String s, List<String> dict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }

            }
        }
        return dp[s.length() + 1];
    }
}

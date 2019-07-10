package algorithm.leetcode.dp;

import java.util.*;

/**
 * 第一次：
 * 第二次：2019-07-09
 *      自上而下
 *      wordBreak("leetcode") = inDict("leetcode")
 *                          ||wordBreak("l") && inDict("eetcode")
 *                          ||wordBreak("le") && inDict("etcode")
 *                          ||wordBreak("lee") && inDict("tcode")
 *                          ||wordBreak("leet") && inDict("code")
 *                          ||......
 *
 *       自下而上
 *       dp[i]: 0- i-1 有多少个分割，构成s[0,i-1]这样的数组
 *       dp[i] = dp[0] && inDicts(s[0...i-1])
 *              || dp[1]&&inDict(s[i,...i-1])
 *              ...  dp[j]&&inDict(s[j,i-1]) j<=i-1
 *
 *       trick 对比单词大于当前剩余字单词时，直接跳过即可。
 */
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

    //dp 解法
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
        return dp[s.length() ];
    }
}

package algorithm.leetcode.递归;

import java.util.Arrays;
import java.util.List;

public class No139_单词拆分 {
    /*
    * 示例 1：

输入: s = "algorithm.leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "algorithm.leetcode" 可以被拆分成 "leet code"。
示例 2：

输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     注意你可以重复使用字典中的单词。
示例 3：

输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false
    * **/

    // 这个方法需要优化
    private int flag = 0;


    public boolean wordBreak(String s, List<String> wordDict) {

        return dfs(s, wordDict);
    }

    public boolean dfs(String s, List<String> wordDict) {
        System.out.println(s);
        if ("".equals(s)) {
            flag = 1;
            return true;
        }

        for (int i = 1; i <= s.length(); i++) {
            String sCur = s.substring(0, i);
            if (wordDict.contains(sCur)) {
                dfs(s.substring(i), wordDict);
            }
        }
        if (flag == 1)
            return true;
        return false;
    }

    // 网上解答，类似背包问题。
    public boolean wordBreakA(String s, List<String> wordDict) {
        // 可以类比于背包问题
        int n = s.length();
        // memo[i] 表示 s 中以 i - 1 结尾的字符串是否可被 wordDict 拆分
        boolean[] memo = new boolean[n + 1];
        memo[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (memo[j] && wordDict.contains(s.substring(j, i))) {
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[n];
    }


    public static void main(String[] args) {
        String s = "aaaaaaa";
        String[] dict = {"aaaa", "aaa"};
        List<String> wordDict = Arrays.asList(dict);
        boolean b = new No139_单词拆分().wordBreak(s, wordDict);
        System.out.println(b);

    }
}

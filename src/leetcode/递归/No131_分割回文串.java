package leetcode.递归;

import java.util.ArrayList;
import java.util.List;

public class No131_分割回文串 {


    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s.length() == 0)
            return res;
        StringBuilder sb = new StringBuilder(s);
        dfs(s, 0, new ArrayList<>(),res);
        return res;
    }

    public void dfs(String s, int index, List<String> curRes,List<List<String>> res) {
        if (index == s.length()) {
            res.add(0, new ArrayList<>(curRes));
            return;
        }
        //  qian -- hou
        for (int i = 1; i <= s.length(); i++) {
            String sCur = s.substring(0, i);
            System.out.println(sCur);
            if (isPalindrome(sCur)) {
                curRes.add(sCur);
                dfs(s.substring(i), 0, curRes,res);
                curRes.remove(curRes.size() - 1);
            }

        }


    }

    public boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "a";
        List<List<String>> res1 = new No131_分割回文串().partition(s);
        System.out.println(res1);
    }
}

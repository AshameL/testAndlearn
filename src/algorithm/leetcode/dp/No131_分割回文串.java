package algorithm.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 0715 第一次
 */
public class No131_分割回文串 {
    List<List<String>> list = new ArrayList<>();
    String s;
    public List<List<String>> partition(String s){
        //从头到尾，递归+回溯
        this.s = s;
        List<String>ll = new ArrayList<>();
        dfs(ll,0);
        return list;
    }

    public void dfs(List<String> ll ,int index){
        if(index==s.length()){
            list.add(new ArrayList<>( ll ));
            return;
        }
        //i 从index开始 因为单个字符也是回文字符串
        for(int i = index;i<s.length();i++){
            // 如果是回文
            if(isPalindrome(index,i)){
                //把当前回文 s(index,i) 加进去
                ll.add(s.substring(index,i+1));
                dfs(ll,i+1);
                //把加进去的回文子串去除。  跟上面加进去的回文子串是同一个回文子串。
                ll.remove(ll.size()-1);
            }
        }
    }
    public boolean isPalindrome(int start,int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

}

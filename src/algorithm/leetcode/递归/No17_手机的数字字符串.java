package algorithm.leetcode.递归;

// 很多递归问题是树形问题。

import java.util.ArrayList;
import java.util.List;

public class No17_手机的数字字符串 {
    private String[] letterMap = {" ",//0
            "",  //1
            "abc",//2
            "def",//3
            "ghi",//4
            "jkl",//5
            "mno",//6
            "pqrs",//7
            "tuv",//8
            "wxyz"//9

    };
    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return res;
        findCombination(digits, 0, "");

        return res;
    }

    private void findCombination(String digits, int index, String s) {

        System.out.println(index + ":" + s);

        if (index == digits.length()) {
            res.add(s);
            return;
        }

        char c = digits.charAt(index);

        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            System.out.println("digits[" + index + "] = " + c + " , use " + letters.charAt(i));
            findCombination(digits, index + 1, s + letters.charAt(i));
        }


        System.out.println("digits[" + index + "] = " + c + " , complete,return ");

    }

    public static void main(String[] args) {
        System.out.println(new No17_手机的数字字符串().letterCombinations("23"));
    }
}

package leetcode.tree;

import dataStruction.Tree.TreeNode;

import java.util.*;

public class No113_pathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();//List接口变量用的ArrayList类对象实例化
        List<Integer> temp = new ArrayList<Integer>();

        if (root == null) return result;
        DFS(result, temp, root, sum);
        return result;

    }

    private void DFS(List<List<Integer>> result, List<Integer> temp, TreeNode root, int sum) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            temp.add(root.val);
            if (sumOfPath(temp) == sum)
                result.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
            return;
        } else {
            temp.add(root.val);
            DFS(result, temp, root.left, sum);
            DFS(result, temp, root.right, sum);
            temp.remove(temp.size() - 1);
        }
    }

    private int sumOfPath(List<Integer> temp) {
        int sum = 0;
        for (int i = 0; i < temp.size(); i++) {
            sum += temp.get(i);
        }
        return sum;
    }


}

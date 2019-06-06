package algorithm.leetcode.tree;

import algorithm.dataStruction.Tree.TreeNode;

public class No112_pathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null && sum == root.val)
            return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

}

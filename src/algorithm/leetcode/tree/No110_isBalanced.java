package algorithm.leetcode.tree;

import algorithm.util.TreeNode;

public class No110_isBalanced {

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        int cha = Math.abs(left - right);
        if (cha > 1)
            return false;
        if (isBalanced(root.left) && isBalanced(root.right))
            return true;
        return false;
    }

    private int getDepth(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + Math.max(getDepth(node.left), getDepth(node.right));
    }
}

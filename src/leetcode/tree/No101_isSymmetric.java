package leetcode.tree;

import util.TreeNode;

public class No101_isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return judge(root.left, root.right);
    }

    public boolean judge(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left != null && right == null) {
            return false;
        } else if (left == null && right != null) {
            return false;
        } else {
            if (left.val != right.val) {
                return false;
            } else {
                return judge(left.left, right.right) && judge(left.right, right.left);
            }
        }

    }
}

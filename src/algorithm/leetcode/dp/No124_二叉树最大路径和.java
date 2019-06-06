package algorithm.leetcode.dp;

import algorithm.util.TreeNode;

/**
 * 在大于0时
 * 1)root
 * 2)root+左边某条路径
 * 3)root+右边某条路径
 * 4)root+左边某条路径+右边某条路径
 */


public class No124_二叉树最大路径和 {

    private int maxVal = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        maxPath(root);
        return maxVal;
    }


    public int maxPath(TreeNode root) {

        if (root == null)
            return 0;
        int left = maxPath(root.left);
        int right = maxPath(root.right);
        int cur = root.val;

        if (left > 0)
            cur += left;
        if (right > 0)
            cur += right;
        maxVal = Math.max(cur, maxVal);
        // 左右有可能都为负数，所以需要参与比较大小
        int thisMax = Math.max(root.val,
                Math.max(left + root.val,
                        right + root.val));
        return thisMax;

    }
}

package leetcode.tree;

import util.TreeNode;

public class No230_kthSmallest {

    private int index;

    public int kthSmallest(TreeNode root, int k) {
        int res = 0;
        if (root == null)
            return res;

        // 左
        res = kthSmallest(root.left, k);

        if (index == k)
            return res;
        //中
        index++;
        if (index == k)
            return root.val;
        // 右
        return kthSmallest(root.right, k);
    }
}

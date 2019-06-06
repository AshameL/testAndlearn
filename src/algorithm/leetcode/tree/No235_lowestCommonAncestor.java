package algorithm.leetcode.tree;

import algorithm.util.TreeNode;

public class No235_lowestCommonAncestor {
    TreeNode res = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        lca(root, p, q);
        return res;
    }

    public void lca(TreeNode root, TreeNode p, TreeNode q) {
        if ((root.val - p.val) * (root.val - q.val) <= 0) {
            res = root;
        } else if (root.val < p.val && root.val < q.val) {
            lca(root.right, p, q);
        } else {
            lca(root.left, p, q);
        }
    }

    /**
     * 方法1： 递归，查找。（本题采用方法1，时间复杂度o（n））
     * 如果是二叉搜索树，有所有左子树都小于root，所有右子树都大于root
     **/
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // root为空
        if (root == null || p == null || q == null) {
            return null;
        }
        // 如果都小于root，则递归左子树，找到左子树中的p或者q
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor2(root.left, p, q);
        }
        // 如果都大于root，则递归右子树，找到右子树中的p或者q
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor2(root.right, p, q);
        }
        // 否则出现分叉，直接返回root
        return root;
    }
}

package algorithm.leetcode.tree;

import algorithm.util.TreeNode;

public class No114_treeToList二叉树展开为链表 {
    public void flatten(TreeNode root) {
        if(root == null)
            return ;
        toList(root);

    }
    TreeNode toList(TreeNode root){
        if(root==null)return null;
        TreeNode right = toList(root.right);
        root.right = toList(root.left);
        root.left = null;
        TreeNode tmp = root;
        while (tmp.right!=null){
            tmp = tmp.right;
        }
        tmp.right = right;
        return root;
    }
}

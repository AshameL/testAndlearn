package algorithm.leetcode.tree;

import algorithm.util.TreeNode;

/**
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 */
public class No106_中序后序构造二叉树 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return inPostConstruct(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    private TreeNode inPostConstruct(int[] inorder, int leftIn, int rightIn, int[] postorder, int leftPost, int rightPost) {
        if (leftIn > rightIn || leftPost > rightPost)
            return null;
        TreeNode root = new TreeNode((postorder[rightPost]));
        int rootIn = leftIn;
        while (postorder[rightPost] != inorder[rootIn])
            rootIn++;

        int leftLen = rootIn - leftIn;// 左子树的个数
        root.left = inPostConstruct(inorder, leftIn, rootIn - 1, postorder, leftPost, leftPost + leftLen-1);
        root.right = inPostConstruct(inorder, rootIn + 1, rightIn, postorder, leftPost + leftLen, rightPost - 1);
        return root;
    }
}

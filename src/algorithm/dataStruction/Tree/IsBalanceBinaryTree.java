package algorithm.dataStruction.Tree;

/***
 * 判断是不是平衡二叉树
 */

public class IsBalanceBinaryTree {
    public boolean isBalanced_Solution(TreeNode root) {
        if (root == null)
            return true;
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1
                && isBalanced_Solution(root.left)
                && isBalanced_Solution(root.right);
    }

    private int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /*
    这种做法有很明显的问题，在判断上层结点的时候，会多次重复遍历下层结点，增加了不必要的开销。
    如果改为从下往上遍历，如果子树是平衡二叉树，则返回子树的高度；
    如果发现子树不是平衡二叉树，则直接停止遍历，
    这样至多只对每个结点访问一次。
     */
    public boolean isBalanced_Solution_Best(TreeNode root) {
        return getDepth2(root) != -1;
    }

    private int getDepth2(TreeNode root) {
        if (root == null)
            return 0;
        int left = getDepth2(root.left);
        if (left == -1)
            return -1;
        int right = getDepth2(root.right);
        if (right == -1)
            return -1;
        return Math.abs(left - right) > 1 ? -1 : (1 + Math.max(left, right));
    }
}


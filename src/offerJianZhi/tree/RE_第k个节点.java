package offerJianZhi.tree;
import util.TreeNode;
public class RE_第k个节点 {
    int index = 0; //计数器

    TreeNode KthNode(TreeNode root, int k) {
        // 中序遍历第k
        if (root == null) {
            return null;
        }
        TreeNode node = KthNode(root.left, k);
        if (node != null)
            return node;
        index++;
        if (index == k)
            return root;
        node = KthNode(root.right, k);
        if (node != null)
            return node;
        return null;

    }
}

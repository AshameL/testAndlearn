package dataStruction.Tree.NextNode后继节点;

/**
 * 有右子树，右子树最左节点
 * 没有右子树，向上找（找父节点），直到当前节点是父亲节点的左孩子为止！！
 */

public class MainNode {
    Node getNextNode(Node node) {
        if (node == null)
            return null;
        if (node.right == null) {//如果有右子树，则找右子树的最左节点
            node = node.right;
            while (node.left != null)
                node = node.left;
            return node;
        }
        while (node.parent != null) {//没右子树，则找第一个当前节点是父节点左孩子的节点
            if (node.parent.left == node)
                return node.parent;
            node = node.parent;
        }
        return null;
    }
}

package algorithm.leetcode.tree.No116;
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
public class No116_填充右节点 {

    public Node connect(Node root) {
        if(root==null)
            return root;
        Node cur = root;
        while (cur!=null){
            if(cur.left !=null)
                cur.left.next = cur.right;
            if(cur.right!=null && cur.next!=null)
                cur.right.next = cur.next.left;
            cur = cur.next;
        }
        connect(root.left);
        return root;
    }
}

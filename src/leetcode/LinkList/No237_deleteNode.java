package leetcode.LinkList;

public class No237_deleteNode {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
    // 可以在下面补一个删除结点的函数，练习一下；
}

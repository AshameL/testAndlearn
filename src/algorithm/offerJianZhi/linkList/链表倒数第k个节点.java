package algorithm.offerJianZhi.linkList;

import algorithm.util.ListNode;

//建议再练习一边，a1Factory。next和p 的判定条件处理有问题。
public class 链表倒数第k个节点 {
    public static ListNode FindKthToTail(ListNode head, int k) {
        ListNode p = head;
        if (head == null)
            return null;
        int count = 1;
        while (count < k) {
            if (p.next == null)
                return null;
            p = p.next;
            count++;
        }
        ListNode q = head;
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        return q;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        int count = 1;
        while (count < 5) {
            p.next = new ListNode(count + 1);
            p = p.next;
            count++;
        }
        ListNode h = FindKthToTail(head, 1);
        System.out.println(h.val);
    }
}

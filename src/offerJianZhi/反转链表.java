package offerJianZhi;

public class 反转链表 {
    // 非递归
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = head;
        ListNode pre = null;
        ListNode next = null;
        while (p != null) {
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;

        }
        return pre;
    }
    // 递归！
}

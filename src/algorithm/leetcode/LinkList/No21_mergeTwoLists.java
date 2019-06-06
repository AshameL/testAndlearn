package algorithm.leetcode.LinkList;

public class No21_mergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode l = head;
        ListNode p = l1;
        ListNode q = l2;
        while (p != null && q != null) {
            if (p.val < q.val) {
                l.next = p;
                l = l.next;
                p = p.next;
            } else {
                head.next = q;
                l = l.next;
                q = q.next;
            }
        }
        if (p != null)
            l.next = p;
        if (q != null)
            l.next = q;
        return head.next;
    }

    // 递归版本
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode res = new ListNode(0);
        if (l1.val > l2.val) {
            res = l2;
            res.next = mergeTwoLists2(l1, l2.next);

        } else {
            res = l1;
            res.next = mergeTwoLists2(l1.next, l2);
        }
        return res;
    }
}

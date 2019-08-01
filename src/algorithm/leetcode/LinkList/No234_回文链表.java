package algorithm.leetcode.LinkList;

import java.util.Stack;

public class No234_回文链表 {
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        ListNode q = p;
        if(head==null||head.next==null)// 0个1个，都是回文
            return true;
        stack.push(p);
        while (q.next!=null&&q.next.next!=null){
            p = p.next;
            q= q.next.next;
            stack.push(p);

        }
        if(q.next!=null){// 长度是偶数
            p =p.next;
        }
        ListNode cur = p;
        while (cur!=null){
            if(cur.val!=stack.pop().val)
                return false;
            cur = cur.next;
        }
        return true;
    }
}

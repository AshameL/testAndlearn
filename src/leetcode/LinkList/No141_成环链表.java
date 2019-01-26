package leetcode.LinkList;

import java.util.HashSet;
import java.util.Set;

public class No141_成环链表 {
    // 这道题是判断是否有环，不是环是哪个点
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode slow = head;
        ListNode quick = head;
        while(slow.next!=null){
            if(quick.next==null||quick.next.next==null){
                return false;
            }
            if(quick.next.next == slow.next){
                return true;
            }
            slow = slow.next;
            quick = quick.next.next;
        }
        return false;
    }
    // 第二种方法可以用set
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> node = new HashSet<>();
        while(head!=null)
        {
            if(node.contains(head))
                return true;
            else
                node.add(head);
            head = head.next;
        }
        return false;
    }
}

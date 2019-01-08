package offerJianZhi.linkList;

import util.ListNode;

import java.util.ArrayList;

public class 从尾到头打印链表 {
    ArrayList<Integer> res = new ArrayList();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        f(listNode);
        return res;
    }

    private void f(ListNode list) {
        if (list == null)
            return;
        f(list.next);
        res.add(list.val);
    }
}

package algorithm.offerJianZhi.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class 滑动窗口最大值 {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (size == 0)
            return res;
        int begin;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
            begin = i - size + 1;
            if (q.isEmpty())
                q.add(i);
            else if (begin > q.peekFirst())
                q.pollFirst(); // 删除头

            while ((!q.isEmpty()) && num[q.peekFirst()] <= num[i])
                q.pollFirst();
            q.add(i);
            if (begin >= 0)
                res.add(num[q.peekFirst()]);
        }
        return res;
    }
}

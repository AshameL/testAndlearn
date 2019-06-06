package algorithm.offerJianZhi;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class 滑动窗口最大值 {
    public static ArrayList<Integer> maxInWindows1(int[] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (num == null) {
            return ret;
        }
        if (num.length < size || size < 1) {
            return ret;
        }

        //1）前面比k小的，直接移出队列（因为不再可能成为后面滑动窗口的最大值了!）,
        LinkedList<Integer> indexDeque = new LinkedList<>();
        for (int i = 0; i < size - 1; i++) {
            while (!indexDeque.isEmpty() && num[i] > num[indexDeque.getLast()]) {
                indexDeque.removeLast();
            }
            indexDeque.addLast(i);
        }
        // 2）前面比k大的X，比较两者下标，判断X是否已不在窗口之内，不在了，直接移出队列
        for (int i = size - 1; i < num.length; i++) {
            while (!indexDeque.isEmpty() && num[i] > num[indexDeque.getLast()]) {
                indexDeque.removeLast();
            }
            indexDeque.addLast(i);
            if (i - indexDeque.getFirst() + 1 > size) {
                indexDeque.removeFirst();
            }
            ret.add(num[indexDeque.getFirst()]);
        }
        return ret;
    }

    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
            while (!queue.isEmpty() && num[i] > num[queue.getLast()]) {
                queue.removeLast();
            }
            while (!queue.isEmpty() && i - queue.getFirst() + 1 > size) {
                queue.removeFirst();
            }
            queue.addLast(i);
            if(i+1>=size)
                res.add(num[queue.getFirst()]);
            System.out.println(res);

        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 2, 6, 2, 5, 1};
//        ArrayList<Integer> res = maxInWindows1(arr, 3);
        ArrayList<Integer> res1 = maxInWindows(arr, 3);
//        System.out.println(res);
        System.out.println(res1);
    }

}

package algorithm.offerJianZhi;

import java.util.LinkedList;
import java.util.List;

public class 丑数 {
    public int GetUglyNumber_Solution(int index) {
        List<Integer> res = new LinkedList<>();
        res.add(1);
        if (index <= 1)
            return index;
        int t2 = 0;
        int t3 = 0;
        int t5 = 0;

        for (int i = 1; i < index; i++) {
            int n2 = res.get(t2) * 2;
            int n3 = res.get(t3) * 3;
            int n5 = res.get(t5) * 5;
            int min = Math.min(n2, Math.min(n3, n5));
            res.add(min);
            if (min == n2)
                t2++;
            if (min == n3)
                t3++;
            if (min == n5)
                t5++;

        }
        return res.get(index - 1);
    }

    public static void main(String[] args) {
        int res =new  丑数().GetUglyNumber_Solution(7);
        System.out.println(res);
    }
}

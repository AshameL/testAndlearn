package offerJianZhi;

import java.util.ArrayList;

public class 孩子们的游戏 {

    /*
     */
    public static int findLastNumber(int n,int m){

        if (m == 0 || n == 0) {
            return -1;
        }
        ArrayList<Integer> data = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            data.add(i);
        }
        int index = -1;
        while (data.size() > 1) {
//          System.out.println(data);
            index = (index + m) % data.size();
//          System.out.println(data.get(index));
            data.remove(index);
            index--;
        }
        return data.get(0);
    }
}

package offerJianZhi;

import java.util.*;

public class 第一个只出现一次的字符 {
    public int FirstNotRepeatingChar(String str) {
        Map<Character, Integer> map = new LinkedHashMap();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                int time = map.get(str.charAt(i));
                map.put(str.charAt(i), ++time);

            } else {
                map.put(str.charAt(i), 1);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int res = new 第一个只出现一次的字符().FirstNotRepeatingChar("googgle");
        System.out.println(res);
    }

}

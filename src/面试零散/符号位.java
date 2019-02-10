package 面试零散;

//解答：这道题主要是犯了整数符号位的问题了，大家可以了解一下
//
//Integer.MAX_VALUE加上1以后的数值这道陷阱题就解决了。

public class 符号位 {
    public static final int ENDNUMBER = Integer.MAX_VALUE;
    public static final int STARTNUMBER = ENDNUMBER - 2;

    public static void main(String[] args) {
        int count = 0;
        System.out.println(ENDNUMBER);
        System.out.println(STARTNUMBER);
        System.out.println("-----------------");

        for (int i = STARTNUMBER; i <= ENDNUMBER; i++) {
            System.out.println(i);
            count++;
        }
        System.out.println(count);
    }
}

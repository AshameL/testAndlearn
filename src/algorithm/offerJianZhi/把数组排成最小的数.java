package algorithm.offerJianZhi;

public class 把数组排成最小的数 {
    public String PrintMinNumber(int[] numbers) {
        if (numbers.length == 0)
            return "";
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int a = numbers[i];
                int b = numbers[j];
                if (Integer.valueOf(""+a+b) > Integer.valueOf(""+b+a)) {
                    int c = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = c;
                }
            }
        }
        StringBuilder res = new StringBuilder("");
        for (int i = 0; i < numbers.length; i++) {
            res.append(numbers[i]);
        }
        return res.toString();

    }

    public static void main(String[] args) {
        int[ ] arr = {3,32,321};
        String res = new 把数组排成最小的数().PrintMinNumber(arr);
        System.out.println(res);
    }
}

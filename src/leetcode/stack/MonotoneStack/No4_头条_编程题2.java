package leetcode.stack.MonotoneStack;


import java.util.Scanner;
import java.util.Stack;

public class No4_头条_编程题2 {

    public static int findMax(int[] input) {
        int res = 0;
        int len = input.length;
        int[] sum = new int[len + 1];

        // sum
        sum[0] = input[0];
        for (int i = 1; i < len; i++) {
            sum[i] = sum[i - 1] + input[i - 1];
        }
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < input.length; i++) {
            while (!s.isEmpty() && input[i] < input[s.peek()]) {
                int index = s.pop();
                res = Math.max(res, input[index] * (sum[i] - sum[index]));
            }
            s.push(i);
            System.out.println(s);
        }
        return res;
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = scanner.nextInt();
//        }
//        int res = findMax(arr);
//        System.out.println(res);
        int[] arr = {6, 2, 5, 5, 5, 4, 7, 6};
//        int[] arr = {6, 2, 1};
        int res = findMax(arr);
        System.out.println(res);
    }
}

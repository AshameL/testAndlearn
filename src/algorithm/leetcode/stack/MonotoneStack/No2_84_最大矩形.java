package algorithm.leetcode.stack.MonotoneStack;

import java.util.Stack;

public class No2_84_最大矩形 {
//    其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。

    public static int largestRectangleArea(int[] heights) {
        int res = 0;
        int len = heights.length;

        Stack<Integer> s = new Stack<>();


        for (int i = 0; i < len; i++) {

            System.out.print("i=" + i + "   " + heights[i] + "时");
            System.out.println(s);
            while (!s.isEmpty() && heights[i] > heights[s.peek()]) {
                int j = s.pop();
                int k;
                if (s.isEmpty())
                    k = -1;
                else
                    k = s.peek();
                int curArea = (i - k - 1) * heights[j];
                System.out.println(heights[j] + "的 curArea  " + curArea + ":::" + i + " " + k + " " + j);
                res = Math.max(res, curArea);
            }

            s.push(i);
            System.out.print("i=" + i + "   " + heights[i] + "完");
            System.out.println(s);

        }
        while (!s.isEmpty()) {
            System.out.println("s.is not empty");
            int i = s.pop();
            int k = s.isEmpty() ? -1 : s.peek();
            int curArea = (heights.length - k - 1) * heights[i];
            res = Math.max(res, curArea);
        }
        return res;
    }

    public static int myMethod(int[] heights) {
        int max = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!s.isEmpty() && heights[i] > heights[s.peek()]) {
                int index = s.pop();
                if (s.isEmpty())
                    Math.max(max, heights[index] * (i));
                else
                    Math.max(max, heights[index] * (i - s.peek() - 1));

            }
            s.push(i);
        }
        while (!s.isEmpty()) {
            int index = s.pop();
            if (s.isEmpty())
                max = Math.max(max, heights[index] * (heights.length));
            else
                max = Math.max(max, heights[index] * (heights.length - s.peek() - 1));
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3};
        int res = largestRectangleArea(arr);
        System.out.println(res);
        int res2 = myMethod(arr);
        System.out.println(res2);

    }
}

package algorithm.leetcode.stack.MonotoneStack;

import java.util.Stack;

public class No1 {
    public int[] nextExceed(int[] input) {
        int[] res = new int[input.length];
        Stack<Integer> monoStack = new Stack<>();
        for (int i : res)
            i = -1;
        for (int i = 0; i < input.length; i++) {
            while (!monoStack.isEmpty() && input[monoStack.peek()] < input[i]) {
                res[monoStack.peek()] = i - monoStack.peek();
                monoStack.pop();
            }

            monoStack.push(i);
        }
        return res;

    }
}// 相关leetcode 496

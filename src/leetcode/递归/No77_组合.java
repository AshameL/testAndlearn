package leetcode.递归;

import java.util.ArrayList;
import java.util.List;

public class No77_组合 {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();
        if (n < k || n <= 0 || k <= 0) {
            return result;

        }
        combination(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    public void combination(int n, int k, int start, List<Integer> current, List<List<Integer>> res) {
        if (k == current.size()) {
            res.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i <= n; i++) {
            current.add(i);
            combination(n, k, i + 1, current, res);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        No77_组合 test = new No77_组合();
        System.out.println(test.combine(4, 2));
    }
}

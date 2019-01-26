package leetcode.递归;

import java.util.ArrayList;
import java.util.List;

public class No46_全排列 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Boolean> used = new ArrayList<>();
    ;

    // 典型的排列问题
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0)
            return res;
        List<Integer> p = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            used.add(false);
        }
        dfs(nums, 0, p);

        return res;
    }

    // p中保存了一个有index个元素的排列
    // 向这个排列的末尾添加第index+1个元素，获得有index+1元素的排列
    private void dfs(int[] nums, int index, List<Integer> p) {

        if (index == nums.length) {
            res.add(new ArrayList<>(p));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used.get(i)) {
                // 将nums[i] 添加到p中
                p.add(nums[i]);
                used.set(i, true);
                dfs(nums, index + 1, p);
                // 回溯的关键步骤
                used.set(i, false);
                p.remove(p.size() - 1);
            }
        }

        return;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new No46_全排列().permute(nums));
    }
}

package leetcode.递归;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No78_子集 {

    // 位运算，dfs
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        Arrays.sort(nums);

        getSubset(list, tempList, 0, nums);

        return list;
    }

    private static void getSubset(List<List<Integer>> list,
                                  List<Integer> tempList, int startLen, int[] nums) {

        list.add(new ArrayList<>(tempList));

        for (int i = startLen; i < nums.length; i++) {
            tempList.add(nums[i]);
            getSubset(list, tempList, i + 1, nums);

            tempList.remove(tempList.size() - 1);
        }
        //System.out.println(tempList);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3};
        List<List<Integer>> list = subsets(nums);
        int len = list.size();
        for (int i = 0; i < len; i++) {
            System.out.println(list.get(i));
        }
    }
}

package algorithm.offerJianZhi.dp;


public class 连续子数组的最大和 {
    /**
     * F（i）：以array[i]为末尾元素的子数组的和的最大值，子数组的元素的相对位置不变
     * F（i）=max（F（i-1）+array[i] ， array[i]）
     * res：所有子数组的和的最大值
     * res=max（res，F（i））
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        int res = array[0];     //记录当前所有子数组的和的最大值
        int max = array[0];     //包含array[i]的连续数组最大值
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max + array[i], array[i]);
            res = Math.max(max, res);
        }
        return res;
    }
}

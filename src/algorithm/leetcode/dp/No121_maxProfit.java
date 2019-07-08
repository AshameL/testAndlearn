package algorithm.leetcode.dp;

public class No121_maxProfit {
    /*
    来自：b站 花花酱
    前i天，价格最低
    前i天，收益最高


     */
    public int maxProfit(int[] prices) {
        if(prices.length==0)
            return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            // min记录数组中最小值，max
            min = Math.min(min,prices[i]);
            max = Math.max(max,prices[i]-min);
        }
        return max;
    }
    /**
     * 最笨的方法，O^2，遍历。for(int i = 0;i < prices.length;++i)； for(int j = i + 1;j < prices.length;++j)
     *  方法1：
     *      上面
     * 方法二：
     *     可以转化成一个子问题：leetcode 53
     */
}

package algorithm.leetcode.dp;

public class No121_maxProfit {

    public int maxProfit(int[] prices) {
        if(prices.length==0)
            return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min,prices[i]);
            max = Math.max(max,prices[i]-min);
        }
        return max;
    }
}

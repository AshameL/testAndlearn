package algorithm.leetcode.dp;

public class No122_maxProfit {

    public int maxProfit(int[] prices) {

        int buy = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i + 1] > prices[i])
                buy += prices[i + 1] - prices[i];
        }
        return buy;
    }
}

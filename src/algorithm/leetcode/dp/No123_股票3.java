package algorithm.leetcode.dp;

public class No123_股票3 {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<2)
            return 0;
        int ret = 0;

        int cutMax = 0;
        //枚举界限cut [0,cut),[cut,end)
        for(int cut=0;cut<prices.length;cut++){
            int preMin = prices[0];
            int preMax = 0;
            for(int i =1;i<cut;i++){
                preMax = Math.max(preMax,prices[i]-preMin);
                preMin = Math.min(preMin,prices[i]);
            }
            cutMax = preMax;
            // 后一段
            preMin = prices[cut];
            preMax = 0;
            for(int i =cut+1;i<prices.length;i++){
                preMax = Math.max(preMax,prices[i]-preMin);
                preMin = Math.min(preMin,prices[i]);
            }
            cutMax +=preMax;
            // 比较更新
            ret = Math.max(cutMax,ret);
        }
        return ret;
    }
    public int maxProfit2(int[] prices) {
        int b1=Integer.MIN_VALUE,b2=Integer.MIN_VALUE;
        int s1=0,s2=0;

        for(int i=0;i<prices.length;i++){
            b1=Math.max(b1,-prices[i]);
            s1=Math.max(s1,b1+prices[i]);
            b2=Math.max(b2,s1-prices[i]);
            s2=Math.max(s2,b2+prices[i]);
        }
        return s2;
    }
}

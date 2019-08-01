package algorithm.leetcode.dp;

public class No338_比特位计数 {
    /***
     * https://www.bilibili.com/video/av35161871?from=search&seid=11838594166018806597 36:33
     *
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] f = new int[num+1];
        for (int i = 1;i<=num;i++){
            // f[n]=f[n/2]+(1或0)
            // 加0还是加1，取决于n这个数的末尾是0还是1.
            f[i] = f[i>>1]+(i&1);
        }
        return f;
    }
    public int[] countBits2(int num){
        int[] res = new int[num+1];
        for(int i = 1;i<=num;i++){
            res[i] = res[i&(i-1)]+1;
        }
        return res;
    }
}

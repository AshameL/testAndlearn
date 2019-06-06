package algorithm.offerJianZhi;


/*
*

如果有符合条件的数字，则它出现的次数比其他所有数字出现的次数和还要多。
在遍历数组时保存两个值：
    一是数组中一个数字，一是次数。
  遍历下一个数字时，若它与之前保存的数字相同，则次数加1，否则次数减1；
  若次数为0，则保存下一个数字，并将次数置为1。
  遍历结束后，所保存的数字即为所求。然后再判断它是否符合条件即可
* */
public class 数组中出现次数超过一半的数字 {
    public int MoreThanHalfNum_Solution(int[] numbers) {
        if (numbers.length == 0)
            return 0;
        // 遍历每个元素，并记录次数；若与前一个元素相同，则次数加1，否则次数减1
        int res = numbers[0];
        int times = 1;// 次数

        for (int i = 1; i < numbers.length; ++i) {
            if (times == 0) {
                // 更新result的值为当前元素，并置次数为1
                res = numbers[i];
                times = 1;
            } else if (numbers[i] == res) {
                times++;//相同则+1
            } else {
                --times; // 不同则-1；
            }
        }
        // 判断result是否符合条件，即出现次数大于数组长度的一半
        times = 0;
        for (int i = 0; i < numbers.length; ++i) {
            if (numbers[i] == res)
                ++times;
        }
        return (times > numbers.length / 2) ? res : 0;
    }
}

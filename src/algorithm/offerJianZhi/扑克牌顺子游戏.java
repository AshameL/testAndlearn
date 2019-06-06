package algorithm.offerJianZhi;

public class 扑克牌顺子游戏 {


    public boolean isContinuous(int[] numbers) {
        if (numbers.length != 5) return false;
        int min = 14;
        int max = -1;
        int flag = 0;
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];

            if (number < 0 || number > 13) return false;

            if (number == 0) // 癞子
                continue;
            //用bit做标记，节省空间，效率也应该高一些。  用二进制位来判断是否有数字重复、 bitmap 排序
            if (((flag >> number) & 1) == 1)
                return false;
            flag |= (1 << number);
            if (number > max)
                max = number;
            if (number < min)
                min = number;
            if (max - min >= 5)
                return false;
        }
        return true;
    }
    /***
     *
     * 作者：hanking
     * 链接：https://www.nowcoder.com/questionTerminal/762836f4d43d43ca9deb273b3de8e1f4
     * 来源：牛客网
     *
     * 如果说了这么多还没明白什么是Bit-map，那么我们来看一个具体的例子，假设我们要对0-7内的5个元素(4,7,2,5,3)排序（
     * 这里假设这些元素没有重复）。那么我们就可以采用Bit-map的方法来达到排序的目的。
     * 要表示8个数，我们就只需要8个Bit（1Bytes），首先我们开辟1Byte的空间，将这些空间的所有Bit位都置为0
     * 然后遍历这5个元素，首先第一个元素是4，那么就把4对应的位置为1（可以这样操作 p+(i/8)|(0×01<<(i%8))
     * 当然了这里的操作涉及到Big-ending和Little-ending的情况，
     * 这里默认为Big-ending）,因为是从零开始的，所以要把第五位置为1。
     * 然后再处理第二个元素7，将第八位置为1,，接着再处理第三个元素，一直到最后处理完所有的元素，将相应的位置为1。
     * 然后我们现在遍历一遍Bit区域，将该位是一的位的编号输出（2，3，4，5，7），这样就达到了排序的目的。
     * 其实就是把计数排序用的统计数组的每个单位缩小成bit级别的布尔数组
     *
     * */
    /*
     方法1：best。
    必须满足两个条件
1. 除0外没有重复的数
2. max - min < 5





    * 思路2，时间复杂度一般。
    * 1、排序
2、计算所有相邻数字间隔总数
3、计算0的个数
4、如果2、3相等，就是顺子
5、如果出现对子，则不是顺子
    *
    * */
}

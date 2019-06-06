package algorithm.offerJianZhi;

/*
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * */
public class 调整数组顺序使奇数位于偶数前面 {

    public void reOrderArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (isOuShu(array[i])) {  // 是偶数
                for (int j = i + 1; j < array.length; j++) {
                    if (!isOuShu(array[j])) {// 奇数
                        int t = array[j];
                        for (int r = j; r > i; r--) {
                            array[r] = array[r - 1];
                        }
                        array[i] = t;
                        break;
                    }

                }
            }
        }
    }

    private boolean isOuShu(int i) {
        if (i % 2 == 0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        new 调整数组顺序使奇数位于偶数前面().reOrderArray(arr);
        for (int a : arr)
            System.out.println(a);
    }
}

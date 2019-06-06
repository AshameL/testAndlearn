package algorithm.dataStruction;

public class BinarySearch {

    // 1.非递归
    static int binarySerach(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=

        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == key)
                return mid;
            else if (array[mid] < key)
                left = mid + 1;
            else
                right = mid - 1;

        }
        return -1;
    }

    // 2. 递归
    static int binarySearchRe(int[] array, int key, int low, int high) {
        // 求中间元素下表
        int mid = (low + high) / 2;
        //数组内不含指定元素，依据下表规则，推出
        if (low > high)
            return -1;
        //查找到指定元素
        if (key == array[mid])
            return mid;
        //当查找的元素大于中间下标的元素，则改变开始下标的位置
        if (key > array[mid])
            return binarySearchRe(array, key, mid + 1, high);
        //当查找的元素小于中间下标的元素，则改变结束下标的位置
        if (key < array[mid])
            return binarySearchRe(array, key, low, mid - 1);
        return -1;
    }
    // 王争的补充
    //algorithm.leetcode 34 35
}

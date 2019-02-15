package dataStruction.Sort;

public class heapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;

        // 建立大根堆
        for (int i = 0; i < arr.length; i++)
            heapInsert(arr, i);

        int heapSize = arr.length;

        // 重新调整大根堆
        swap(arr, 0, --heapSize); // 堆顶跟最后元素进行交换
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    /**
     * 从index位置向下调整堆
     */

    private static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left]
                    ? left + 1
                    : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index)
                break;
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    /**
     * 从index位置，为arr建堆
     * ***********  (index-1)/2
     */
    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
        }
    }


    private static void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}

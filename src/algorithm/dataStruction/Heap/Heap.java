package algorithm.dataStruction.Heap;

public class Heap {
    private int[] a;// 数组，从下标1开始存储数据
    private int n;//堆可以存储的最大数据个数
    private int count;// 堆中已经存储的个数

    public Heap(int cap) {
        a = new int[cap + 1];
        n = cap;
        count = 0;
    }

    public void insert(int data) {
        if (count > n) return;     // 堆满了
        ++count;
        a[count] = data;
        int i = count;
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            swap(a, i, i / 2);
            i = i / 2;
        }
    }

    public void removeMax() {
        if (count == 0) return;// 堆中没有数据
        a[1] = a[count];
        --count;
        heapify(a, count, 1);
    }

    private static void heapify(int[] a, int n, int i) { // 自上向下堆化
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2])
                maxPos = i * 2;
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1])
                maxPos = i * 2 + 1;
            if (maxPos == i)
                break;
            swap(a, i, maxPos);
            i = maxPos;
        }

    }


    // n表示数据的个数，数据a中 数据从下标1到n
    public static void sort(int[] a, int n) {
        buildHeap(a, n);
        int k = n;
        while (k > 1) {
            swap(a, 1, k);
            --k;
            heapify(a, k, 1);
        }
    }


    private static void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    // 建堆
    private static void buildHeap(int[] a, int n) {
        for (int i = n / 2; i >= i; --i) {
            heapify(a, n, i);
        }
    }


}

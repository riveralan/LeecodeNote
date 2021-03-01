/**
 * 手写一个小根堆
 */
public class MinHeap {
    /**
     * 小根堆初始化
     *
     * @param a
     * @param length
     */
    public void minHeap(int a[], int length) {
        for (int i = length >> 1; i >= 0; i--) {
            adjustMinHeap(a, length, i);
        }
    }

    /**
     * 小根堆调整
     *
     * @param a
     * @param length
     * @param i
     */
    private void adjustMinHeap(int[] a, int length, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int minIndex = i;
        if (left < length && a[left] < a[i]) {
            minIndex = left;
        }
        if (right < length && a[right] < a[minIndex]) {
            minIndex = right;
        }
        if (minIndex != i) {
            swap(a, i, minIndex);
            adjustMinHeap(a, length, minIndex);
        }

    }


    /**
     * 交换 数组值
     *
     * @param a
     * @param i
     * @param j
     */
    private void swap(int[] a, int i, int j) {
        a[i] = a[i] + a[j];
        a[j] = a[i] - a[j];
        a[i] = a[i] - a[j];
    }

}

package binaryHeaps;

/**
 * Created by Payson Wu on 16/03/14.
 */
public class BinaryHeap {
    public int A[];

    /**
     * Constructor
     * @param unSortedNumbers
     */
    public BinaryHeap(int[] unSortedNumbers) {
        A = unSortedNumbers;
    }

    /**
     * heap sort: will first build a heap from the array A
     * swap the first element with the last
     * maxHeapify and shrink the heap by one
     */
    public void heapSort() {
        buildHeapFromUnSortedArray();
        int n = A.length - 1;
        for (int i = n - 1; i >= 0; i--) {
            swap(0, i + 1);
            maxHeapify(i, 0);
        }
    }

    private void buildHeapFromUnSortedArray() {
        int n = A.length;
        //starting from i=n/2 since the leaves satisfy maxheapify
        for (int i = n/2; i >= 0; i--) {
            maxHeapify(n-1, i);
        }
    }

    private void maxHeapify(int size, int i) {
        int left = left(i);
        int right = right(i);
        int largest = i;
        if (left <= size && A[left] > A[largest]) {
            largest = left;
        }
        if (right <= size && A[right] > A[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(largest, i);
            maxHeapify(size, largest);
        }
    }

    private int left(int x) {
        return 2 * x + 1;
    }
    private int parent(int x) {
        return (x - 1)/2;
    }
    private int right(int x) {
        return 2 * x + 2;
    }
    private void swap(int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}

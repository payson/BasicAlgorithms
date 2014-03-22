package sorting;

/**
 * Created by Payson Wu on 16/03/14.
 */
public class QuickSort {

    public void quickSort(int[] A) {
        quickSort(A, 0, A.length - 1);
    }
    public void quickSort(int[] A, int head, int tail) {
        if (head >= tail) {
            return;
        }
        int mid = sort(A, head, tail);
        quickSort(A, head, mid - 1);
        quickSort(A, mid + 1, tail);
    }

    private int sort(int[] A, int head, int tail) {
        int mid = (head + tail) / 2;
        int key = A[mid];
        swap(A, mid, tail);
        int i = head, j = tail;
        while (i < j) {
            if (A[i] <= key) {
                i++;
            } else {
                swap(A, i, --j);
            }
        }
        swap(A, j, tail);
        return j;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
        // swap can be implemented as
        // A[i] = A[i] ^ A[j];
        // A[j] =  A[j] ^ A[i];
        // A[i] = A[i] ^ A[j];
    }
}

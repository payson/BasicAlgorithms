package sorting;

/**
 * Created by Payson Wu on 16/03/14.
 */
public class MergeSort {
    private int[] numbers;
    private int[] helpers;
    public void mergeSort(int[] A) {
        this.numbers = A;
        int length = A.length;
        this.helpers = new int[length];
        mergeSort(0, length - 1);
    }
    
    private void mergeSort(int head, int tail) {
        if (head < tail) {
            int mid = head + (tail - head)/2;
            
            mergeSort(head, mid);
            
            mergeSort(mid + 1, tail);
            
            merge(head, mid, tail);
        }
    }

    private void merge(int head, int mid, int tail) {
        for (int i = head; i <= tail; i++) {
            helpers[i] = numbers[i];
        }
        int i = head;
        int j = mid + 1;
        int k = head;

        while (i <= mid && j <= tail) {
            if (helpers[i] <= helpers[j]) {
                numbers[k] = helpers[i];
                i++;
            } else {
                numbers[k] = helpers[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            numbers[k] = helpers[i];
            k++;
            i++;
        }
    }
}

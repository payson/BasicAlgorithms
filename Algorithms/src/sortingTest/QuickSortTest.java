package sortingTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sorting.QuickSort;

import java.util.Random;

/**
 * Created by Payson Wu on 16/03/14.
 */
public class QuickSortTest {
    private int[] numbers;
    private final static int SIZE = 17;
    private final static int MAX = 20;

    @Before
    public void setUp() throws Exception {
        numbers = new int[SIZE];
        Random generator = new Random();
        for (int i = 0; i < SIZE; i++) {
            numbers[i] = generator.nextInt(MAX);
        }
    }

    @Test
    public void testQuickSort() {
        long startTime = System.currentTimeMillis();

        QuickSort qs = new QuickSort();
        qs.quickSort(numbers);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("QuickSort " + elapsedTime);

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i+1]) {
                Assert.fail("Should not happen");
            }
        }
        Assert.assertTrue(true);
    }

    @Test
    public void testQuickSortRepeatably() {
        for (int i = 0; i < 100; i++) {
            numbers = new int[SIZE];
            Random generator = new Random();
            for (int j = 0; j < numbers.length; j++) {
                numbers[j] = generator.nextInt(MAX);
            }
            QuickSort qs = new QuickSort();
            qs.quickSort(numbers);
            for (int k = 0; k < numbers.length - 1; k++) {
                if (numbers[k] > numbers[k + 1]) {
                    Assert.fail("Should not happen");
                }
            }
            Assert.assertTrue(true);
        }
    }
}

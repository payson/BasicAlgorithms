package binaryHeapsTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import binaryHeaps.*;
/**
 * Created by Payson Wu on 16/03/14.
 */
public class BinaryHeapTest {
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
    public void testHeapSort() {
        long startTime = System.currentTimeMillis();

        BinaryHeap bh = new BinaryHeap(numbers);
        bh.heapSort();

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Heapsort " + elapsedTime);

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i+1]) {
                Assert.fail("Should not happen");
            }
        }
        Assert.assertTrue(true);
    }

    @Test
    public void testHeapSortRepeatably() {
        for (int i = 0; i < 100; i++) {
            numbers = new int[SIZE];
            Random generator = new Random();
            for (int j = 0; j < numbers.length; j++) {
                numbers[j] = generator.nextInt(MAX);
            }
            BinaryHeap bh = new BinaryHeap(numbers);
            bh.heapSort();
            for (int k = 0; k < numbers.length - 1; k++) {
                if (numbers[k] > numbers[k + 1]) {
                    Assert.fail("Should not happen");
                }
            }
            Assert.assertTrue(true);
        }
    }
}

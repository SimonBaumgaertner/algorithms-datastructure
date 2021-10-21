package sorting;

import org.junit.Test;
import sorting.algorithms.InsertionSort;
import sorting.algorithms.MergeSort;

import java.util.Arrays;
import java.util.Random;

public class SortingTest {

    public static final int ARRAY_SIZE = 200000; // e.g. 200000 to see difference in efficiency
    public static final int UPPER_BOUND = 10000;

    @Test
    public void compareAlgorithms() {
        sort(new InsertionSort());
        sort(new MergeSort());
    }

    @Test
    public void insertionSort() {
        sort(new InsertionSort());
    }

    @Test
    public void mergeSort() {
        sort(new MergeSort());
    }

    private void sort(SortingAlgorithm algorithm) {
        int[] arr = generateArrayWithRandomValues(ARRAY_SIZE);
        print(arr);
        long startTime = System.currentTimeMillis();
        System.out.println("sorting with " + getName(algorithm) + " ... ");
        algorithm.sort(arr);
        double timeElapsed = (System.currentTimeMillis() - startTime) / 1000d;
        System.out.println("sorting with " + getName(algorithm) + " took " + timeElapsed + " seconds");
        print(arr);
    }

    private int[] generateArrayWithRandomValues(int amount) {
        Random rand = new Random();
        int arr[] = new int[amount];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(UPPER_BOUND);
        }
        return arr;
    }

    private String getName(SortingAlgorithm algorithm) {
        return algorithm.getClass().toString().split("\\.")[2];
    }

    private void print(int[] arr) {
        if (arr.length < 100) {
            System.out.print("Array: ");
            System.out.println(Arrays.toString(arr));
        }
    }
}

package sorting;


import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] numbersToBeSorted = new int[] {1,24,12,312, 32, 12, 2, 32, 7, 12, 33 ,4,0};
        System.out.println(Arrays.toString(numbersToBeSorted));

        for (int globalIndex = 1; globalIndex < numbersToBeSorted.length; globalIndex++) {
            int value = numbersToBeSorted[globalIndex];
            int workingIndex = globalIndex - 1;
            while(workingIndex >= 0 && numbersToBeSorted[workingIndex] > value) {
                numbersToBeSorted[workingIndex + 1] = numbersToBeSorted[workingIndex];
                workingIndex = workingIndex - 1;
            }
            numbersToBeSorted[workingIndex + 1] = value;
        }
        System.out.println(Arrays.toString(numbersToBeSorted));
    }
}
package sorting;


import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[] {1,24,12,312, 32, 12, 2, 32, 7, 12, 33 ,4,0};
        System.out.println(Arrays.toString(arr));

        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > value) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = value;
        }
        System.out.println(Arrays.toString(arr));
    }
}
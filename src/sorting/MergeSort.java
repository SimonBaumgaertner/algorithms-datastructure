package sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 24, 12, 312, 32, 12, 2, 32, 7, 12, 33, 4, 0, 5};
        System.out.println(Arrays.toString(arr)); // unsorted
        System.out.println(Arrays.toString(mergeSort(arr, 0, arr.length - 1))); // sorted
    }

    /**
     * @param arr array of numbers
     * @param l   starting index of partial array
     * @param r   end index of partial array
     */
    private static int[] mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2; // index on that we will separate the array (last element of first partial array because / operator rounds down)
            // recursive calls for
            mergeSort(arr, l, m); // first half
            mergeSort(arr, m + 1, r); // second half
            // afterwards merge the sorted array
            merge(arr, l, m, r);
        }
        return arr;
    }

    /**
     * @param arr array to be sorted
     * @param l   starting index of partial array
     * @param m   index on that we will separate the array (last element of first partial array)
     * @param r   end index of partial array
     */
    private static void merge(int[] arr, int l, int m, int r) {
        int[] arrTemp = new int[r - l + 1]; // store sorted value to copy later
        int n1 = l, n2 = m + 1; // initialize n1 & n2 as indices for the partials

        for (int k = 0; k < arrTemp.length; k++) { // fill arrTemp
            if (n1 <= m && n2 <= r) {   // true if both partials still have not yet copied elements
                arrTemp[k] = arr[n1] < arr[n2] ? arr[n1++] : arr[n2++]; // add lower element
            } else {                    // -> one of the partials has all elements copied
                arrTemp[k] = n1 <= m ?           arr[n1++] : arr[n2++]; // add element of unfinished partial
            }
        }

        // copy sorted values into arr
        for (int i = l; i <= r; i++) {
            arr[i] = arrTemp[i - l];
        }
    }
}
package eu.davidknotek.algorithms.sorts;

import java.util.Arrays;

public class MergeSort {

    public static int[] mergeSort(int[] array) {
        // If array is has one element only, return array
        if (array.length == 1) return array;

        // Get middle index of array
        int midIndex = array.length / 2;
        // Array from 0 to middle index. The copy of array and call function recursively.
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
        // Array from middle index to end. The copy of array and call function recursively.
        int[] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));

        return merge(left, right);
    }

    public static int[] merge(int[] array1, int[] array2) {
        // Create new array with combined length
        int[] combinet = new int[array1.length + array2.length];

        int index = 0; // in new array
        int i = 0; // in array1
        int j = 0; // in array2

        // Until first array and second array are not empty
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                combinet[index] = array1[i];
                i++;
            } else {
                combinet[index] = array2[j];
                j++;
            }
            index++;
        }

        // Add remaining elements from array1
        while (i < array1.length) {
            combinet[index] = array1[i];
            i++;
            index++;
        }

        // Add remaining elements from array2
        while (j < array2.length) {
            combinet[index] = array2[j];
            j++;
            index++;
        }

        return combinet;
    }
}

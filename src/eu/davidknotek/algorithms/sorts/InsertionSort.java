package eu.davidknotek.algorithms.sorts;

public class InsertionSort {
    public static void insertionSort(int[] array) {
        // Start at second element
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1; // previous element
            while (j >= 0 && temp < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }
}

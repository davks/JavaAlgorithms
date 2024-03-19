package eu.davidknotek.algorithms.sorts;

public class QuickSort {
     public static void quickSort(int[] array) {
         quickSort(array, 0, array.length - 1);
     }

    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = pivot(array, left, right); // Get index of pivot
            quickSort(array, left, pivotIndex - 1); // Sort left part
            quickSort(array, pivotIndex + 1, right); // Sort right part
        }
    }

    private static int pivot(int[] array, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;

        // Loop through array from pivotIndex + 1 to endIndex
        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            // If current element is less than pivot, swap it
            if (array[i] < array[pivotIndex]) {
                swapIndex++;
                swap(array, swapIndex, i);
            }
        }

        // Swap pivot with swapIndex, which is the last position of smaller elements
        swap(array, pivotIndex, swapIndex);

        return swapIndex;
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}

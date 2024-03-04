package eu.davidknotek.algorithms.sorts;

public class BubbleSort {

    /**
     * Sorting existing array
     * @param array
     */
    public static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            // Loop through array
            for (int j = 0; j < i; j++) {
                // If current element is greater than next element swap elements
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}

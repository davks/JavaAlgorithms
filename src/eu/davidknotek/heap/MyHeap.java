package eu.davidknotek.heap;

import java.util.ArrayList;
import java.util.List;

public class MyHeap {

    private List<Integer> heap;

    public MyHeap() {
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }

    // Insert new value
    public void insert(int value) {
        heap.add(value);
        int current = heap.size() - 1; // velikost seznamu mínus jeden (index od 0)

        // While current node is greater than parent node and current is greater like zero
        while (current > 0 && heap.get(current) > heap.get(parent(current))) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Remove max
    public Integer remove() {
        if (heap.size() == 0) {
            return null;
        }

        if (heap.size() == 1) {
            return heap.remove(0);
        }

        int maxValue = heap.get(0); // Max value in the heap
        heap.set(0, heap.remove(heap.size() - 1)); // Set first node to last node
        sinkDown(0);

        return maxValue;
    }

    // Swap
    public void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    private int leftChild(int index) {
        return 2 * index + 1; // +1 je kvuli posunu hodnot v poli (počítá se od indexu 0)
    }

    private int rightChild(int index) {
        return 2 * index + 2; // +2 je kvuli posunu hodnot v poli (počítá se od indexu 0)
    }

    private int parent(int index) {
        return (index - 1) / 2; // -1 je kvuli posunu hodnot v poli (počítá se od indexu 0)
    }

    // Sink down
    private void sinkDown(int index) {
        int maxIndex = index;
        while (true) {
            int leftIndex = leftChild(index);
            int rightIndex = rightChild(index);

            // Find the max index by comparing left and right child if leftIndex exist
            if (leftIndex < heap.size() && heap.get(leftIndex) > heap.get(maxIndex)) {
                maxIndex = leftIndex;
            }

            // If there is a right child and it is greater than the max index
            if (rightIndex < heap.size() && heap.get(rightIndex) > heap.get(maxIndex)) {
                maxIndex = rightIndex;
            }

            // If the max index doesn't refer to the current index
            if (maxIndex != index) {
                swap(index, maxIndex);
                index = maxIndex;
            } else {
                return;
            }
        }
    }
}

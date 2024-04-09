import eu.davidknotek.algorithms.sorts.*;
import eu.davidknotek.avltree.MyAvlTree;
import eu.davidknotek.dynamic.FibonnaciSequence;
import eu.davidknotek.graph.MyGraph;
import eu.davidknotek.hashtable.MyHashTable;
import eu.davidknotek.heap.MyHeap;
import eu.davidknotek.linkedlist.MyDoubleLinkedList;
import eu.davidknotek.linkedlist.MyLinkedList;
import eu.davidknotek.queue.MyQueue;
import eu.davidknotek.stack.MyStack;
import eu.davidknotek.tree.MyBinarySearchTree;
import eu.davidknotek.tree.MyBinarySearchTreeRecursively;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        testDataStructures();
//        testAlgorithms();
    }

    private static void testAlgorithms() {
//        testBubbleSort();
//        testSelectionSort();
//        testInsertionSort();
//        testMergeSort();
//        testQuickSort();
//        testFibonacci();
    }

    private static void testDataStructures() {
//        testLinkedList();
//        testDoubleLinkedList();
//        testStack();
//        testQueue();
//        testBinarySearchTree();
//        testBinarySearchTreeRecursively();
//        testHashTable();
//        testGraph();
//        testHeap();
        testAvlTree();
    }

    private static void testAvlTree() {
        MyAvlTree myAvlTree = new MyAvlTree();
        myAvlTree.insert(5, 10, 15, 20);
//        myAvlTree.insert(10);
//        myAvlTree.insert(15);
//        myAvlTree.insert(20);
        System.out.println(myAvlTree.search(15).height);
        myAvlTree.levelOrder();
        myAvlTree.delete(5);
        myAvlTree.levelOrder();
    }

    private static void testFibonacci() {
        int n = 103;
        Instant start = Instant.now();
        System.out.println("Fib of " + n + ": " + FibonnaciSequence.fib(n));
        System.out.println("Counter: " + FibonnaciSequence.counter);
        Instant end = Instant.now();
        System.out.println("Time: " + (Duration.between(start, end).toSeconds()) + "s");

        Instant start2 = Instant.now();
        System.out.println("Fib of " + n + ": " + FibonnaciSequence.fibMemo(n));
        System.out.println("Counter: " + FibonnaciSequence.counterMemo);
        Instant end2 = Instant.now();
        System.out.println("Time: " + (Duration.between(start2, end2).toMillis()) + "ms");

        Instant start3 = Instant.now();
        System.out.println("Fib of " + n + ": " + FibonnaciSequence.fibMemo2(n));
        System.out.println("Counter: " + FibonnaciSequence.counterMemo2);
        Instant end3 = Instant.now();
        System.out.println("Time: " + (Duration.between(start3, end3).toMillis()) + "ms");

    }

    private static void testQuickSort() {
        int[] myArray = {4, 6, 1, 7, 3, 2, 5};
        QuickSort.quickSort(myArray);
        System.out.println(Arrays.toString(myArray));
    }

    private static void testMergeSort() {
        int[] array1 = {1, 3, 7, 8, 2, 4, 5, 6};

        var result = MergeSort.mergeSort(array1);
        System.out.println(Arrays.toString(result));
    }

    private static void testInsertionSort() {
        int[] myArray = {23, 4, 2, 6, 5, 1, 3};
        InsertionSort.insertionSort(myArray);
        System.out.println(Arrays.toString(myArray));
    }

    private static void testSelectionSort() {
        int[] myArray = {23, 4, 2, 6, 5, 1, 3};
        SelectionSort.selectionSort(myArray);
        System.out.println(Arrays.toString(myArray));
    }

    private static void testBubbleSort() {
        int[] myArray = {23, 4, 2, 6, 5, 1, 3};
        BubbleSort.bubbleSort(myArray);
        System.out.println(Arrays.toString(myArray));
    }

    private static void testBinarySearchTreeRecursively() {
        MyBinarySearchTreeRecursively myBstr = new MyBinarySearchTreeRecursively();
        myBstr.insert(47);
        myBstr.insert(21);
        myBstr.insert(18);
        myBstr.insert(27);
        myBstr.insert(76);
        myBstr.insert(52);
        myBstr.insert(82);
        myBstr.insert(2);

        myBstr.delete(2);

        System.out.println(myBstr.contains(47));
        System.out.println(myBstr.contains(2));

        // Tree traversal
        System.out.println(myBstr.bfs()); // bfs Level-order
        System.out.println(myBstr.dfsPreOrder()); // dfs Pre-order
        System.out.println(myBstr.dfsPostOrder()); // dfs Post-order
        System.out.println(myBstr.dfsInOrder()); // dfs In-order
    }

    private static void testHeap() {
        MyHeap myHeap = new MyHeap();

        myHeap.insert(95);
        myHeap.insert(75);
        myHeap.insert(80);
        myHeap.insert(55);
        myHeap.insert(60);

        System.out.println(myHeap.getHeap());

        myHeap.insert(50);
        System.out.println(myHeap.getHeap());

        myHeap.insert(65);
        System.out.println(myHeap.getHeap());

        myHeap.remove();
        System.out.println(myHeap.getHeap());

        myHeap.remove();
        System.out.println(myHeap.getHeap());
    }

    private static void testGraph() {
        MyGraph myGraph = new MyGraph();

        myGraph.addVertex("A");
        myGraph.addVertex("B");
        myGraph.addVertex("C");
        myGraph.addVertex("D");

        myGraph.addEdge("A", "B");
        myGraph.addEdge("A", "C");
        myGraph.addEdge("A", "D");
        myGraph.addEdge("B", "D");
        myGraph.addEdge("C", "D");


        System.out.println("\nGraph before removeVertex():");
        myGraph.printGraph();

        myGraph.removeVertex("D");

        System.out.println("\nGraph after removeVertex():");
        myGraph.printGraph();
    }

    static void testHashTable() {
        MyHashTable myHashTable = new MyHashTable();
        myHashTable.set("nails", 100);
        myHashTable.set("tile", 50);
        myHashTable.set("lumber", 80);
        myHashTable.set("bolts", 200);
        myHashTable.set("screws", 140);

        System.out.println(myHashTable.remove("tile"));

        myHashTable.set("lumber", 120);
        System.out.println("lumber: " + myHashTable.get("lumber"));

        myHashTable.changeKey("lumber", "wood");

        System.out.println("wood: " + myHashTable.get("wood"));
        System.out.println(myHashTable.keys());

        myHashTable.printTable();
    }

    static void testBinarySearchTree() {
        MyBinarySearchTree myBinarySearchTree = new MyBinarySearchTree();
        myBinarySearchTree.insert(15);
        myBinarySearchTree.insert(3);
        myBinarySearchTree.insert(7);
        myBinarySearchTree.insert(23);
        myBinarySearchTree.insert(18);
        myBinarySearchTree.insert(43);

        System.out.println(myBinarySearchTree.root.left.right.value);
        System.out.println(myBinarySearchTree.root.right.left.value);
        System.out.println(myBinarySearchTree.root.right.right.value);

        System.out.println(myBinarySearchTree.contains(23));
        System.out.println(myBinarySearchTree.contains(30));
    }

    private static void testQueue() {
        MyQueue myQueue = new MyQueue();
        myQueue.enqueue(5);
        myQueue.enqueue(23);
        myQueue.enqueue(43);

        System.out.println("Dequeue: " + myQueue.dequeueValue());
        System.out.println("Dequeue: " + myQueue.dequeueValue());
//        System.out.println("Dequeue: " + myQueue.dequeueValue());

        myQueue.printList();
        myQueue.getFirst();
        myQueue.getLast();
        myQueue.getLength();
    }

    private static void testStack() {
        MyStack myStack = new MyStack();
        myStack.push(5);
        myStack.push(23);
        myStack.push(43);
        System.out.println("Popped: " + myStack.popValue());
        System.out.println("Popped: " + myStack.popValue());
        System.out.println("Popped: " + myStack.popValue());

        myStack.printList();
        myStack.getTop();
        myStack.getHeight();
    }

    private static void testLinkedList() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.append(5);
        myLinkedList.append(23);
        myLinkedList.append(43);

//        myLinkedList.reverse();

//        myLinkedList.insert(1, 100);
//        myLinkedList.set(1, 100);
//        myLinkedList.prepend(3);
//        System.out.println(myLinkedList.get(1));
//        myLinkedList.removeLast();
        myLinkedList.removeFirst();

        myLinkedList.printList();
        myLinkedList.getHead();
        myLinkedList.getTail();
        myLinkedList.getLength();
    }

    private static void testDoubleLinkedList() {
        MyDoubleLinkedList myDoubleLinkedList = new MyDoubleLinkedList();
        myDoubleLinkedList.append(5);
        myDoubleLinkedList.append(23);

        myDoubleLinkedList.prepend(3);
        myDoubleLinkedList.insert(1, 100);
        myDoubleLinkedList.set(1, 200);
        myDoubleLinkedList.removeLast();
        myDoubleLinkedList.removeFirst();
        System.out.println("value: " + myDoubleLinkedList.getValue(1));

        myDoubleLinkedList.printList();
        myDoubleLinkedList.getHead();
        myDoubleLinkedList.getTail();
        myDoubleLinkedList.getLength();
    }
}
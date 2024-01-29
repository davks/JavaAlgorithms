import eu.davidknotek.hashtable.MyHashTable;
import eu.davidknotek.linkedlist.MyDoubleLinkedList;
import eu.davidknotek.linkedlist.MyLinkedList;
import eu.davidknotek.queue.MyQueue;
import eu.davidknotek.stack.MyStack;
import eu.davidknotek.tree.MyBinarySearchTree;

import java.security.Key;

public class Main {
    public static void main(String[] args) {
//        testLinkedList();
//        testDoubleLinkedList();
//        testStack();
//        testQueue();
//        testBinarySearchTree();
        testHashTable();
    }

    static void testHashTable() {
        MyHashTable myHashTable = new MyHashTable();
        myHashTable.set("nails", 100);
        myHashTable.set("tile", 50);
        myHashTable.set("lumber", 80);
        myHashTable.set("bolts", 200);
        myHashTable.set("screws", 140);

        System.out.println(myHashTable.remove("lumber"));

        myHashTable.printTable();

        System.out.println("lumber: " + myHashTable.get("lumber"));

        System.out.println(myHashTable.keys());
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
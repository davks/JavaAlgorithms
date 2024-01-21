package eu.davidknotek.stack;

import eu.davidknotek.linkedlist.MyLinkedList;

public class MyStack {
    private Node top;
    private int height;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;

        }
    }

    public MyStack() {

    }

    public MyStack(int value) {
        push(value);
    }

    public void printList() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next; // move to next node
        }
        System.out.println("\n");
    }

    public void getTop() {
        if (top != null) {
            System.out.println("Top: " + top.value);
        }
    }

    public void getHeight() {
        System.out.println("Height: " + height);
    }

    public void push(int value) {
        Node newNode = new Node(value);

        if (height == 0) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public int popValue() {
        return pop().value;
    }

    public Node pop() {
        if (height == 0) return null;

        Node temp = top;
        top = top.next;
        temp.next = null;

        height--;
        return temp;
    }
}

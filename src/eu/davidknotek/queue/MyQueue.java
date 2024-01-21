package eu.davidknotek.queue;

public class MyQueue {
    private Node first;
    private Node last;
    private int length;

    public class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public MyQueue() {
    }

    public MyQueue(int value) {
        enqueue(value);
    }

    public void printList() {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next; // move to next node
        }
        System.out.println("\n");
    }

    public void getFirst() {
        if (first != null) {
            System.out.println("First: " + first.value);
        }
    }

    public void getLast() {
        if(last != null) {
            System.out.println("Last: " + last.value);
        }
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }

        length++;
    }

    public int dequeueValue() {
        return dequeue().value;
    }

    public Node dequeue() {
        if (length == 0) return null;

        Node temp = first;

        if (length == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            temp.next = null;
        }

        length--;
        return temp;
    }
}

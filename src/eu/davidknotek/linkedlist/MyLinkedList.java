package eu.davidknotek.linkedlist;

public class MyLinkedList {

    private Node head; // first node
    private Node tail; // last node
    private int length; // length of the list

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public MyLinkedList() {
        this.length = 0;
    }

    /*
     * Create new Node
     */
    public MyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next; // move to next node
        }
        System.out.println("\n");
    }

    public void getHead() {
        if (head != null) {
            System.out.println("Head: " + head.value);
        }
    }

    public void getTail() {
        if (tail != null) {
            System.out.println("Tail: " + tail.value);
        }
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    /*
     * Create new Node and append it to the end of the list
     */
    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) { // empty list
            head = newNode;
            tail = newNode;
        } else { // not empty list
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    /*
     * Create new Node and prepend it to the beginning of the list
     */
    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) { // empty list
            head = newNode;
            tail = newNode;
        } else { // not empty list
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    /*
     * Remove the last node
     */
    public Node removeLast() {
        if (length == 0) return null;

        // Set temp and previous node
        Node temp = head;
        Node pre = head;

        // Check if the length list is one, if yes, set head and tail to null
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            // Loop through the list while temp.next is not null (temp.next with null is last node)
            while (temp.next != null) {
                pre = temp; // previous node
                temp = temp.next; // next node
            }
            tail = pre; // set tail to previous node
            tail.next = null; // set tail.next to null
        }
        length--; // decrement length
        return temp;
    }

    /*
     * Remove the first node
     */
    public Node removeFirst() {
        if (length == 0) return null;

        Node temp = head; // temp is the first node in the list

        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next; // set the new head which is the second node
            temp.next = null;
        }
        length--;
        return temp;
    }

    /*
     * Create new Node and insert it at the given index
     */
    public boolean insert(int index, int value) {
        // Check if index is out of bounds
        if (index < 0 || index > length) {
            return false;
        }

        if (index == 0) {
            prepend(value);
            return true;
        }

        if (index == length) {
            append(value);
            return true;
        }

        Node newNode = new Node(value);

        Node temp = get(index - 1); // temp is the node who is linked to the next node
        newNode.next = temp.next; // set newNode.next to temp.next
        temp.next = newNode; // set temp.next to newNode
        length++;

        return false;
    }

    /*
     * Remove the node at the given index
     */
    public Node remove(int index) {
        // Check if index is out of bounds
        if (index < 0 || index >= length) {
            return null;
        }

        if (index == 0) {
            return removeFirst();
        }

        if (index == length - 1) {
            return removeLast();
        }

        Node prev = get(index - 1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length--;

        return temp;
    }

    /*
     * Get the node at the given index
     */
    public Node get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    /*
     * Get the node value at the given index
     */
    public int getValue(int index) {
        return get(index).value;
    }

    /*
     * Set the node value at the given index
     */
    public boolean set(int index, int value) {
        Node temp = get(index);

        if (temp != null) {
            temp.value = value;
            return true;
        } else {
            return false;
        }
    }

    /*
     * Reverse the list
     */
    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;

        Node after = temp.next;
        Node before = null;

        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }
}

import eu.davidknotek.linkedlist.MyDoubleLinkedList;
import eu.davidknotek.linkedlist.MyLinkedList;

public class Main {
    public static void main(String[] args) {
//        testLinkedList();
        testDoubleLinkedList();
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
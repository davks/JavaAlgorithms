package eu.davidknotek.hashtable;

import java.util.ArrayList;

public class MyHashTable {
    private int size = 7;
    private Node[] dataMap;

    class Node {
        String key;
        int value;
        Node next;


        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashTable() {
        dataMap = new Node[size];
    }

    public void printTable() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ": ");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.println(" -> " + temp.key + " : " + temp.value);
                temp = temp.next;
            }
        }
    }

    public void set(String key, int value) {
        int index = hash(key); // get hash (index)

        Node newNode = new Node(key, value); // create new node with data

        if (dataMap[index] == null) { // if there is no data
            dataMap[index] = newNode;
        } else {
            Node temp = dataMap[index]; // if there is data, get first node

            while (temp.next != null) { // go throw nodes until last node
                temp = temp.next;
            }
            temp.next = newNode; // add new node
        }
    }

    public int get(String key) {
        int index = hash(key);

        Node temp = dataMap[index]; // get first node

        while (temp != null) {
            if (temp.key == key) {
                return temp.value; // get the value
            }
            temp = temp.next;
        }

        return 0;
    }

    public ArrayList<String> keys() {
        ArrayList<String> keys = new ArrayList<>();

        for (int i = 0; i < dataMap.length; i++) {
            Node temp = dataMap[i];

            while (temp != null) {
                keys.add(temp.key);
                temp = temp.next;
            }
        }

        return keys;
    }

    /**
     * We get hash from string. The hash is index in array from 0 to 6.
     * @param key string.
     * @return hash, it is number from 0 to 6.
     */
    private int hash(String key) {
        int hash = 0;
        char[] chars = key.toCharArray(); // convert string to char array
        for (int i = 0; i < chars.length; i++) {
            int asciiValue = chars[i]; // get number of char
            hash = (hash + asciiValue * 23) % dataMap.length; // number 23 is a prime, we can get only 0 to 6
        }
        return hash;
    }
}

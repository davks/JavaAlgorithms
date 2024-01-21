package eu.davidknotek.tree;

public class MyBinarySearchTree {

    public Node root;

    public class Node {
        public int value;
        public Node left;
        public Node right;

        private Node(int value) {
            this.value = value;
        }
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
            return true;
        }

        Node temp = root; // start at the top node

        while(true) {
            if (newNode.value == temp.value) return false; // the duplicity node

            if (newNode.value < temp.value) {
                // Left side is open
                if (temp.left == null) { // if left side of node refers to null
                    temp.left = newNode; // insert node
                    return true;
                }
                // Left side is closed
                temp = temp.left; // else set temp to left node
            } else {
                // Right side is open
                if (temp.right == null) { // if right side of node refers to null
                    temp.right = newNode; // insert node
                    return true;
                }
                // Right side is closed
                temp = temp.right; // else set temp to right node
            }
        }
    }

    public boolean contains(int value) {
        Node temp = root; // start at the top node

        while (temp != null) { // find the node until it reaches the last row in the tree
            if (value < temp.value) { // go left
                temp = temp.left;
            } else if (value > temp.value) { // go right
                temp = temp.right;
            } else {
                return true; // found
            }
        }

        return false; // not found
    }
}

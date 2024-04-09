package eu.davidknotek.avltree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MyAvlTree {

    BinaryNode root;

    public MyAvlTree() {
        root = null;
    }

    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    public void postOrder() {
        postOrder(root);
        System.out.println();
    }

    public void levelOrder() {
        levelOrder(root);
        System.out.println();
    }

    public BinaryNode search(int value) {
        return search(root, value);
    }

    public void insert(int... values) {
        for (int value : values) {
            insert(value);
        }
    }

    public void delete(int value) {
        root = deleteNode(root, value);
    }

    public void deleteAvl() {
        root = null;
    }

    private BinaryNode insertNode(BinaryNode node, int nodeValue) {
        // O(1)
        if (node == null) {
            BinaryNode newNode = new BinaryNode();
            newNode.value = nodeValue;
            newNode.height = 1;
            return newNode;
        } else if (nodeValue < node.value) {
            node.left = insertNode(node.left, nodeValue); // O(log n)
        } else {
            node.right = insertNode(node.right, nodeValue); // O(log n)
        }

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1; // O(1)
        int balance = getBalance(node);

        // Right rotation
        if (balance > 1 && nodeValue < node.left.value) { // O(1)
            return rotateRight(node); // O(1)
        }

        // Left rotation
        if (balance < -1 && nodeValue > node.right.value) {
            return rotateLeft(node);
        }

        // Left/right rotation
        if (balance > 1 && nodeValue > node.left.value) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Right/left rotation
        if (balance < -1 && nodeValue < node.right.value) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    private BinaryNode deleteNode(BinaryNode node, int value) {
        if (node == null) {
            System.out.println("Value not found");
            return node;
        }

        // Case 1 - no rotation
        if (value < node.value) { // left side
            node.left = deleteNode(node.left, value);
        } else if (value > node.value) { // right side
            node.right = deleteNode(node.right, value);
        } else { // both sides
            if (node.left != null && node.right != null) {
                BinaryNode temp = node;
                BinaryNode minNodeForRight = minimumNode(temp.right);
                node.value = minNodeForRight.value;
                node.right = deleteNode(node.right, minNodeForRight.value);
            } else if (node.left != null) {
                node = node.left;
            } else if (node.right != null) {
                node = node.right;
            } else {
                node = null; // leaf node
            }
        }
        // Case 2 - rotation required
        int balance = getBalance(node);

        // Right rotation
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rotateRight(node);
        }

        // Left rotation
        if (balance < -1 && getBalance(node.right) <= 0) {
            return rotateLeft(node);
        }

        // Left/right rotation
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Right/left rotation
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    private BinaryNode rotateRight(BinaryNode disbalanceNode) {
        BinaryNode newRoot = disbalanceNode.left;
        disbalanceNode.left = disbalanceNode.left.right;
        newRoot.right = disbalanceNode;

        disbalanceNode.height = Math.max(getHeight(disbalanceNode.left), getHeight(disbalanceNode.right)) + 1;
        newRoot.height = Math.max(getHeight(newRoot.left), getHeight(newRoot.right)) + 1;
        return newRoot;
    }

    private BinaryNode rotateLeft(BinaryNode disbalanceNode) {
        BinaryNode newRoot = disbalanceNode.right;
        disbalanceNode.right = disbalanceNode.right.left;
        newRoot.left = disbalanceNode;

        disbalanceNode.height = Math.max(getHeight(disbalanceNode.left), getHeight(disbalanceNode.right)) + 1;
        newRoot.height = Math.max(getHeight(newRoot.left), getHeight(newRoot.right)) + 1;
        return newRoot;
    }

    private static BinaryNode minimumNode(BinaryNode root) {
        if (root.left == null) {
            return root;
        }
        return minimumNode(root.left);
    }

    private int getBalance(BinaryNode node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    private int getHeight(BinaryNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private void postOrder(BinaryNode node) {
        ArrayList<Integer> result = new ArrayList<>();

        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    private void inOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    private void preOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    private void levelOrder(BinaryNode root) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            if (presentNode != null) {
                System.out.print(presentNode.value + " ");

                if (presentNode.left != null) {
                    queue.add(presentNode.left);
                }
                if (presentNode.right != null) {
                    queue.add(presentNode.right);
                }
            }
        }
    }

    private void insert(int value) {
        root = insertNode(root, value);
    }

    private BinaryNode search(BinaryNode node, int value) {
        if (node == null) {
            System.out.println("Value: " + value + " not found");
            return null;
        } else if (node.value == value) {
            System.out.println("Value: " + value + " found");
            return node;
        } else if (node.value > value) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }
}

package eu.davidknotek.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MyBinarySearchTreeRecursively {

    public Node root;

    public class Node {
        public int value;
        public Node left;
        public Node right;

        private Node(int value) {
            this.value = value;
        }
    }

    public boolean contains(int value) {
        return contains(root, value);
    }

    public void insert(int value) {
        if (root == null) root = new Node(value);
        insert(root, value);
    }

    public void delete(int value) {
        deleteNode(root, value);
    }

    private Node deleteNode(Node currentNode, int value) {
        if (currentNode == null) return null;

        // Traversal
        if (value < currentNode.value) { // go left
            currentNode.left = deleteNode(currentNode.left, value);
        } else if (value > currentNode.value) { // go right
            currentNode.right = deleteNode(currentNode.right, value);
        } else { // we found the node
            // If no daughter node, delete the node
            if (currentNode.left == null && currentNode.right == null) {
                return null;
                // If only one daughter node (on the right), return the daughter node
            } else if (currentNode.left == null) {
                currentNode = currentNode.right;
                // If only one daughter node (on the left), return the daughter node
            } else if (currentNode.right == null) {
                currentNode = currentNode.left;
                // If both daughter nodes, find the smallest value in the right subtree and replace the node
            } else {
                int subTreeMinValue = minValue(currentNode.right);
                currentNode.value = subTreeMinValue;
                currentNode.right = deleteNode(currentNode.right, subTreeMinValue);
            }
        }

        return currentNode;
    }

    /**
     * Looking for the smallest value in the subtree - on the left side
     * @param currentNode
     * @return
     */
    private int minValue(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    private Node insert(Node currentNode, int value) {
        if (currentNode == null) return new Node(value);

        if (value < currentNode.value) {
            currentNode.left = insert(currentNode.left, value);
        } else  if (value > currentNode.value) {
            currentNode.right = insert(currentNode.right, value);
        }

        return currentNode;
    }

    private boolean contains(Node currentNode, int value) {
        if (currentNode == null) return false;

        if (value == currentNode.value) return true;

        if (value < currentNode.value) {
            return contains(currentNode.left, value);
        } else {
            return contains(currentNode.right, value);
        }
    }

    /**
     * BFS - Breadth First Search traversal
     * @return
     */
    public ArrayList<Integer> bfs() {
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        queue.add(currentNode);

        // Go through the tree level by level
        while (queue.size() > 0) {
            currentNode = queue.remove(); // remove the first node
            result.add(currentNode.value); // add the value to the result

            // Add the left children to the queue
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            // Add the right children to the queue
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return result;
    }

    /**
     * DFS - Depth First Search traversal
     * pre-order
     * @return
     */
    public ArrayList<Integer> dfsPreOrder() {
        ArrayList<Integer> result = new ArrayList<>();

        class Traverse {
            Traverse(Node currentNode) {
                // Add the value to the result
                result.add(currentNode.value);

                // Look for the left children
                if (currentNode.left != null) {
                    new Traverse(currentNode.left); // recursive call
                }
                // Look for the right children
                if (currentNode.right != null) {
                    new Traverse(currentNode.right); // recursive call
                }
            }
        }

        new Traverse(root);
        return result;
    }

    /**
     * DFS - Depth First Search traversal
     * post-order
     * @return
     */
    public ArrayList<Integer> dfsPostOrder() {
        ArrayList<Integer> result = new ArrayList<>();

        class Traverse {
            Traverse(Node currentNode) {

                // Look for the left children
                if (currentNode.left != null) {
                    new Traverse(currentNode.left); // recursive call
                }
                // Look for the right children
                if (currentNode.right != null) {
                    new Traverse(currentNode.right); // recursive call
                }

                // Add the value to the result
                result.add(currentNode.value);
            }
        }

        new Traverse(root);
        return result;
    }

    /**
     * DFS - Depth First Search traversal
     * in-order
     * @return
     */
    public ArrayList<Integer> dfsInOrder() {
        ArrayList<Integer> result = new ArrayList<>();

        class Traverse {
            Traverse(Node currentNode) {

                // Look for the left children
                if (currentNode.left != null) {
                    new Traverse(currentNode.left); // recursive call
                }

                // Add the value to the result
                result.add(currentNode.value);

                // Look for the right children
                if (currentNode.right != null) {
                    new Traverse(currentNode.right); // recursive call
                }

            }
        }

        new Traverse(root);
        return result;
    }
}

package eu.davidknotek.trie;

public class MyTrie {

    private enum WordState {
        PREFIX,
        EXIST,
        NOT_EXIST
    }

    private TrieNode root;

    public MyTrie() {
        root = new TrieNode();
        System.out.println("The Trie has been created.");
    }

    public void insert(String word) {
        TrieNode currentNode = root;

        // Start from root node
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node = currentNode.getChildren().get(c);

            if (node == null) {
                node = new TrieNode();
                currentNode.getChildren().put(c, node);
            }

            currentNode = node;

        }
        currentNode.setEndOfWord(true);
        System.out.println("Inserted word " + word);
    }

    public WordState contains(String word) {
        TrieNode currentNode = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node = currentNode.getChildren().get(c);

            if (node == null) {
                return WordState.NOT_EXIST;
            }
            currentNode = node; // continue to the next node
        }

        if (!currentNode.isEndOfWord()) {
            return WordState.PREFIX;
        } else {
            return WordState.EXIST;
        }
    }

    public void delete(String word) {
        if (contains(word) == WordState.EXIST) {
            delete(root, word, 0);
        }
    }

    private boolean delete(TrieNode parentNode, String word, int index) {
        char c = word.charAt(index);
        TrieNode currentNode = parentNode.getChildren().get(c);
        boolean canDeleteCurrentNode;

        // First case: no children
        if (currentNode.getChildren().size() > 1) {
            delete(currentNode, word, index + 1);
            return false; // we didn't delete the current node
        }

        // Second case
        if (index == word.length() - 1) {
            if (currentNode.getChildren().size() >= 1) {
                currentNode.setEndOfWord(false);
                return false;
            } else {
                parentNode.getChildren().remove(c);
                return true; // we deleted the current node
            }
        }

        // Third case: some other words is a prefix
        if (currentNode.isEndOfWord()) {
            delete(currentNode, word, index + 1);
            return false;
        }

        // Fourth case: no other words is depend on this word, we can delete it
        canDeleteCurrentNode = delete(currentNode, word, index + 1);
        if (canDeleteCurrentNode) {
            parentNode.getChildren().remove(c);
            return true;
        } else {
            return false;
        }
    }

//    public void insert(String word) {
//        TrieNode current = root;
//
//        // Start from root node
//        for (int i = 0; i < word.length(); i++) {
//            char c = word.charAt(i);
//
//            if (!current.getChildren().containsKey(c)) {
//                current.getChildren().put(c, new TrieNode());
//            }
//            current = current.getChildren().get(c);
//        }
//        current.setEndOfWord(true);
//        System.out.println("Inserted word " + word);
//    }
}

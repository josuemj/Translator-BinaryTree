public class BinaryTree {
    private Node root;

    /**
     * Being translation1
     */
    private class Node {
        private String word;
        private String translation1;
        private String translation2;
        private Node leftChild;
        private Node rightChild;

        public Node(String word, String translation1, String translation2) {
            this.word = word;
            this.translation1 = translation1;
            this.translation2 = translation2;
            this.leftChild = null;
            this.rightChild = null;
        }
    }

    public void insert(String word, String translation1, String translation2) {
        root = insert(root, word, translation1, translation2);
    }

    private Node insert(Node node, String word, String translation1, String translation2) {
        if (node == null) {
            node = new Node(word, translation1, translation2);
        } else {
            if (word.compareTo(node.word) < 0) {
                node.leftChild = insert(node.leftChild, word, translation1, translation2);
            } else if (word.compareTo(node.word) > 0) {
                node.rightChild = insert(node.rightChild, word, translation1, translation2);
            }
        }
        return node;
    }

    public String getTranslation(String word, String language) {
        Node node = search(root, word);
        if (node == null) {
            return null;
        } else {
            if (language.equals("language1")) {
                return node.translation1;
            } else if (language.equals("language2")) {
                return node.translation2;
            } else {
                return null;
            }
        }
    }

    private Node search(Node node, String word) {
        if (node == null || word.equals(node.word)) {
            return node;
        } else if (word.compareTo(node.word) < 0) {
            return search(node.leftChild, word);
        } else {
            return search(node.rightChild, word);
        }
    }
}

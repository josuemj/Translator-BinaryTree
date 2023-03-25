public class Node {
    String mainWord;
    String traduccion1;
    String traduccion2;
    Node izquierdo;
    Node derecho;

    public Node(String mainWord, String traduccion1,String traduccion2) {

        this.mainWord = mainWord;
        this.traduccion1 = traduccion1;
        this.traduccion2 = traduccion2;

        this.izquierdo = null;
        this.derecho = null;
    }
}
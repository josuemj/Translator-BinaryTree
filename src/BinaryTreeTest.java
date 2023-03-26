import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    /**
     * Unit rest for binary Insertion.
     */
    @org.junit.jupiter.api.Test
    void insert() {
        BinaryTree binaryTreeImplementation = new BinaryTree();
    }

    /**
     * Unit test for translation/search
     */
    @org.junit.jupiter.api.Test
    void getTranslation() {

        BinaryTree binaryTreeImplementation = new BinaryTree();
        binaryTreeImplementation.insert("hello","hola","bonjour");

        String expectectTrans = "hola";
        String unknownWord = "hello";
        String binaryTranslation = binaryTreeImplementation.getTranslation("hello","language1");

        assertEquals(expectectTrans,binaryTranslation);
        //Test passed

    }
}
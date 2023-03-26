import java.util.ArrayList;

public class TrDictionary {

    /**
     * English based tree order
     * word - english word
     * translation 1 - spanish word
     * translation 2 - French translation
     */
    static BinaryTree englishBasedTree = new BinaryTree();


    /**
     * French based tree order
     * word - French word
     * translation 1 - spanish word
     * translation 2 - english translation
     */
    static BinaryTree frenchBasedTree = new BinaryTree();

    /**
     * Spanish based tree order
     * word - Spanish word
     * translation 1 - English translation
     * translation 2 - French translation
     */
    static BinaryTree spanishBasedTree = new BinaryTree();


    /**
     * Array contains all words
     */
    static ArrayList<String> words = Reader.readFile("src/diccionario.txt");

    /**
     * Arrays separate word to set trees.
     */

    static ArrayList<String> englishWords = Controller.createList(0, Reader.readFile("src/diccionario.txt"));
    static ArrayList<String> spanishWords = Controller.createList(1, Reader.readFile("src/diccionario.txt"));
    static ArrayList<String> frenchWords = Controller.createList(2, Reader.readFile("src/diccionario.txt"));


    /**
     * Sets the trees with words to translate.
     */
    public static void setTress() {
        for (int i = 0; i < words.size(); i++) {
            englishBasedTree.insert(englishWords.get(i), spanishWords.get(i), frenchWords.get(i));
            frenchBasedTree.insert(frenchWords.get(i), spanishWords.get(i), englishWords.get(i));
            spanishBasedTree.insert(spanishWords.get(i), englishWords.get(i), frenchWords.get(i));
        }
    }

    /**
     * Method translates the phrase and inside uses the method to detect the language.
     *
     * @param phrase
     */
    public static void translate(String phrase) {
        System.out.println("=========\nTRANSLATION PROCESS STARTED");
        System.out.println("PHRASE: " + phrase);
        setTress();

        phrase = phrase.replaceAll("\\.", ""); //Phrase with no points
        String[] splitedPhrase = phrase.split(" ");
        String language = Controller.detectLanguage(phrase);

        if (language.equals("English")) {
            System.out.println("====================\nSpanish Translation");
            System.out.println(buildTranslation(splitedPhrase, englishBasedTree, "language1"));
            System.out.println("====================\nFrench Translation");
            System.out.println(buildTranslation(splitedPhrase, englishBasedTree, "language2"));
        }

        if (language.equals("Spanish")) {
            System.out.println("====================\nEnglish Translation");
            System.out.println(buildTranslation(splitedPhrase, spanishBasedTree, "language1"));
            System.out.println("====================\nFrench Translation");
            System.out.println(buildTranslation(splitedPhrase, spanishBasedTree, "language2"));
        }

        if (language.equals("French")) {
            System.out.println("====================\nSpanish Translation");
            System.out.println(buildTranslation(splitedPhrase, frenchBasedTree, "language1"));
            System.out.println("====================\nEnglish Translation");
            System.out.println(buildTranslation(splitedPhrase, frenchBasedTree, "language2"));
        }

    }

    /**
     * Translates and builds the final phrase/translation.
     *
     * @param splittedPhrase
     * @param languageTree
     * @param language
     * @return
     */

    public static String buildTranslation(String[] splittedPhrase, BinaryTree languageTree, String language) {
        String finalPhrase = ""; //Building Phrase.
        for (int i = 0; i < splittedPhrase.length; i++) {
            var translation = languageTree.getTranslation(splittedPhrase[i], language);
            if (translation == null) {
                //When word is not in the dictionary.
                finalPhrase = finalPhrase + " '" + splittedPhrase[i] + "' ";
            } else {
                finalPhrase = finalPhrase + " " + translation;
            }
        }
        finalPhrase = finalPhrase + ".";
        return finalPhrase;
    }
}

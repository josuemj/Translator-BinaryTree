import java.lang.reflect.Array;
import java.util.ArrayList;

public class Controller{

    /**
     * Detects if the phrase contains a word in given language list.
     * @param phrase
     * @param language
     * @return
     */

    public static boolean containsWord(String[] phrase,ArrayList<String> language){
        for(int i = 0;i<phrase.length;i++){
            if (language.contains(phrase[i]));
            return true;
        }
        return false;
    }

    /**
     * Method will return the language
     * @param phrase
     * @return
     */
    public static String detectLanguage(String phrase){
        ArrayList<String> englishWords = createList(0,Reader.readFile("src/diccionario.txt"));
        ArrayList<String> spanishWords = createList(1,Reader.readFile("src/diccionario.txt"));
        ArrayList<String> frenchWords = createList(2,Reader.readFile("src/diccionario.txt"));
        phrase = phrase.replaceAll("\\.", ""); //Phrase with no points

        String[] splitedPhrase = phrase.split(" ");

        if(containsWord(splitedPhrase,englishWords)){
            System.out.println("ENGLISH DETECTED");
            return "English";
        }
        if(containsWord(splitedPhrase,spanishWords)){
            System.out.println("SPANISH DETECTED");
            return "Spanish";
        }
        if(containsWord(splitedPhrase,frenchWords)){
            System.out.println("FRENCH DETECTED");
            return "French";
        }
        return null;
    }




    /**
     * Method returns an array of all the words per language
     * 0 = English
     * 1 = Spanish
     * 2 = French
     * @param languageIndex
     * @param allwords
     * @return
     */
    public static ArrayList<String> createList(int languageIndex,ArrayList<String> allwords){
        ArrayList<String> words = new ArrayList<>();
        ArrayList<String[]> translationsList = new ArrayList<>();
        for (int i = 0;i<allwords.size();i++){
            String[] translations = allwords.get(i).split(",");
            translationsList.add(translations);
        }
        for (int i = 0;i<translationsList.size();i++){
            words.add(translationsList.get(i)[languageIndex]);
        }
        return words;
    }

}
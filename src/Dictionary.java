import java.util.ArrayList;

public class Dictionary {

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
    static BinaryTree FrenchBasedTree = new BinaryTree();

    /**
     * Spanish based tree order
     * word - Spanish word
     * translation 1 - English translation
     * translation 2 - French translation
     */
    static BinaryTree spanishBasedTree = new BinaryTree();


    static ArrayList<String> words = Reader.readFile("src/diccionario.txt");

    static ArrayList<String> englishWords = Controller.createList(0,Reader.readFile("src/diccionario.txt"));
    static ArrayList<String> spanishWords = Controller.createList(1,Reader.readFile("src/diccionario.txt"));
    static ArrayList<String> frenchWords = Controller.createList(2,Reader.readFile("src/diccionario.txt"));


    public static void setTrees(){
        for(int i = 0; i<words.size();i++){

            englishBasedTree.insert(englishWords.get(i),spanishWords.get(i),frenchWords.get(i));
            FrenchBasedTree.insert(frenchWords.get(i),spanishWords.get(i),englishWords.get(i));
            spanishBasedTree.insert(spanishWords.get(i),englishWords.get(i),frenchWords.get(i));

        }
    }

    public static void translate(String phrase){
        phrase = phrase.replaceAll("\\.", ""); //Phrase with no points
        String[] splitedPhrase = phrase.split(" ");
        String languajeDetecttion = Controller.detectLanguage(phrase);

        if (languajeDetecttion.equals("English")){

            for(int i = 0; i<splitedPhrase.length;i++){

                try{
                    System.out.println("WORD: "+splitedPhrase[i]);
                    englishBasedTree.getTranslation(splitedPhrase[i],"languaje1");
                    System.out.println(englishBasedTree.getTranslation(splitedPhrase[i],"languaje1"));
                }catch (Exception e){

                }

            }


            if(languajeDetecttion.equals("French")){

                //Uses French BasedTree

                if (languajeDetecttion.equals("Spanish")){

                    //Uses Spanish BasedTree

                }
            }
        }

    }




}

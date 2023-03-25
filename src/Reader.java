import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {

    public static ArrayList<String> readFile(String fileName) {

        ArrayList<String> translations = new ArrayList<String>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = br.readLine()) != null) {
                //System.out.println(line);
                translations.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return translations;
    }





}

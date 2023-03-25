import java.util.ArrayList;
import java.util.Scanner;

public class MainTranslate {

    public static void main(String[] args) {
        ArrayList<String> translation =  Reader.readFile("src/diccionario.txt");

        Controller.createList(2,translation);


        while(true){
            System.out.println("=========================\nWelcome to the translator\n=========================");

            Scanner in = new Scanner(System.in);

            System.out.println("1) Recorrido");
            System.out.println("2) Traducir texto");
            System.out.println("3) Salir");

            String eject = in.nextLine();

            switch (eject){
                case "1":
                    break;

                case "2":
                    Controller.detectLanguage(Reader.readFile("src/Texto.txt").get(0));
                    break;

                case "3":
                    break;

                case "4":
                    break;

                case "5":
                    break;

                case "6":
                    break;

                case "7":
                    break;

                case "8":
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opcion no disponible");
            }
        }
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class MainTranslate {

    public static void main(String[] args) {
        ArrayList<String> translation =  Reader.readFile("src/diccionario.txt");
        while(true){
            System.out.println("=========================\nWelcome to the translator\n=========================");
            Scanner in = new Scanner(System.in);

            System.out.println("1) Recorrido");
            System.out.println("2) Ingles / Espanol");
            System.out.println("3) Espanol / Ingles");
            System.out.println("4) Ingles / Frances");
            System.out.println("5) Espanol / Frances");
            System.out.println("6) Frances / Espanol");
            System.out.println("7) Frances / Ingles");
            System.out.println("8) Salir");

            String eject = in.nextLine();

            switch (eject){
                case "1":
                    break;

                case "2":
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

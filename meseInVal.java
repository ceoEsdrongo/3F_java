import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci il mese per ricevere il corrispondente numerico");
        String mese = sc.nextLine();
        System.out.println(intToStrMese(mese));
    }

    public static int intToStrMese(String mese) {
        mese = mese.toLowerCase();
        return switch (mese) {
            case "gennaio" -> 1;
            case "febbraio" -> 2;
            case "marzo" -> 3;
            case "aprile" -> 4;
            case "maggio" -> 5;
            case "giugno" -> 6;
            case "luglio" -> 7;
            case "agosto" -> 8;
            case "settembre" -> 9;
            case "ottobre" -> 10;
            case "novembre" -> 11;
            case "dicembre" -> 12;
            default -> -1;
        };
    }
}

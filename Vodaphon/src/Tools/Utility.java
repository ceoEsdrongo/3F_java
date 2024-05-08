package Tools;

import java.util.Scanner;

public class Utility {
    public static void ClrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Wait(int x) {
        try {
            Thread.sleep(1000 * x);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int menu(String[] opzioni, Scanner keyboard) {
        int scelta;

        do {
            ClrScr();
            System.out.println("=== " + opzioni[0] + " ===");
            for (int i = 1; i < opzioni.length; i++) {
                System.out.println("[" + i + "]" + " " + opzioni[i]);
            }
            try {
                scelta = Integer.parseInt(keyboard.nextLine());
            }catch(Exception e){
                scelta = Integer.parseInt(keyboard.next());
                keyboard.nextLine();
            }
            if (scelta < 1 || scelta > opzioni.length - 1) {
                System.out.println("Valore errato. Riprova");
                Wait(3);
            }
        } while (scelta < 1 || scelta > opzioni.length - 1);

        return scelta;
    }

    /* metodo che indica il messaggio di errore */
    public static void messaggioErrore(int value) {
        /* switch case per i messaggi di errore */
        switch (value) {
            case 1:
                System.out.println("ERROR! Input out of range");
                break;
            case 2:
                System.out.println("ERROR! Wrong domain");
                break;
            default:
                System.out.println("");
        }
        Wait(3);
        ClrScr();
    }
}
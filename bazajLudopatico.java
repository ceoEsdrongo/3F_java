/*consegna:
realizzare un programma in java in cui:
Giocata utente: l'utente punta 5 numeri sulla ruota di Venezia
         * lista spesa: array di 5 elementi
         * controllo se valori inseriti sono compresi tra 1 e 90
         * controllo che un numero venga inserito una sola volta
         * controllo che vengano inseriti 5 valori, non di più non di meno
         * Visualizza giocate: lista della spesa
         * menu di scelta, opzioni2 (Venezia, Giocatore)

         l'etsrazione deve essre controllata con un vettore di boolean
 */

//inserimento librerie

import java.util.Scanner;
import java.util.Random;

public class Main {
    private static final int[] nEstratti = new int[5];

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Random nEstratto = new Random();
        int scelta = 0;
        int conteggio = 0, nGiusti = 0;
        int[] nG1 = new int[5];
        Boolean[] numeri = new Boolean[90];

        do {
            // Opzioni del menu
            String[] opzioni = {"=== Gioco Dadi === ",
                    "[1] Estrazioni ruota di Venezia",
                    "[2] Giocata utente",
                    "[3] Visualizza utente",
                    "[4] Visualizza Venezia",
                    "[5] Uscite"
            };

            scelta = Menu(opzioni, keyboard);
            Wait(2000);

            switch (scelta) {
                case 1:
                    for (int i = 0; i < nEstratti.length; i++) {
                        nEstratti[i] = Estrazione(nEstratto, nEstratti, i);
                    }
                    System.out.println("I numeri sono stati estratti");
                    break;

                case 2:
                    for (int i = 0; i < nG1.length; i++) {
                        do {
                            System.out.println("Inserisci il " + (i + 1) + " numero");
                            nG1[i] = keyboard.nextInt();

                            for (int j = 0; j < i; j++) {
                                if (nG1[i] == nG1[j]) {
                                    System.out.println("Numero già inserito. Riprova.");
                                    break;
                                }
                            }
                        } while (!(nG1[i] >= 1 && nG1[i] <= 90));
                    }
                    System.out.println("I numeri sono stati registrati");
                    break;

                case 3:
                    visualizza();
                    break;

                case 4:
                    System.out.println("numeri estratti dalla ruota ");

                    break;

                case 5:
                    break;
            }
        } while (scelta != 5);

        Wait(3000);
    }

    private static int Menu(String opzioni[], Scanner tastiera) {
        int scelta;

        do {
            ClrScr();
            System.out.println("------------------");
            System.out.println(opzioni[0]);
            System.out.println("------------------");
            for (int i = 1; i < opzioni.length; i++) {
                System.out.println(opzioni[i]);
            }
            scelta = tastiera.nextInt();

            if (scelta < 1 || scelta > opzioni.length) {
                System.out.println("Opzione Sbagliata");
                Wait(2000);
            }
        } while (scelta < 1 || scelta > opzioni.length - 1);

        return scelta;
    }

    private static int Estrazione(Random caso, int nEstratti[], int i) {
        nEstratti[i] = caso.nextInt(90) + 1;

        for (int j = 0; j < i; j++) {
            while (nEstratti[i] == nEstratti[j]) {
                nEstratti[i] = caso.nextInt(90) + 1;
                j = 0;
            }
        }

        return nEstratti[i];
    }

    private static int VerificaVincita(int i, int nEstratti[], int nG1[]) {
        int contaGiusti = 0;
        for (int j = 0; j < nEstratti.length; j++) {
            if (nG1[i] == nEstratti[j]) {
                contaGiusti++;
            }
        }
        return contaGiusti;
    }

    private static void ClrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void Wait(int attesa) {
        try {
            Thread.sleep(attesa);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void visualizza() {
        for (int i = 0; i < nEstratti.length; i++) {
            System.out.println(nEstratti[i] + " ");
        }
    }
}

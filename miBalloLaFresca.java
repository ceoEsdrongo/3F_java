import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Scanner tastiera = new Scanner(System.in);
        Random random = new Random();

        boolean fine = true;
        int[] numeriCasuali = new int[5];
        int[] vettore = new int[5];

        String[] opzioni = {"Estrazioni lotto", "[1] Ruota Venezia", "[2] Visualizza", "[3] Gioca Utente", "[4] Visualizza Utente", "[5] Exit"};

        do {
            switch (menu(opzioni, tastiera)) {
                case 1:
                    System.out.println("opzione 1");
                    System.out.println("Genera numeri:");
                    for (int i = 0; i < 5; i++) {
                        numeriCasuali[i] = random.nextInt(90) + 1;
                    }
                    break;
                case 2:
                    System.out.println("opzione 2");
                    System.out.println("Visualizzazione numeri:");
                    visualizza(numeriCasuali);
                    break;
                case 3:
                    System.out.println("opzione 3");
                    vettore = giocaUtente(tastiera);
                    break;
                case 4:
                    System.out.println("opzione 4");
                    System.out.println("Visualizzazione numeri:");
                    VisualizzaNumeri(vettore);
                    break;
                case 5:
                    System.out.println("exit");
                    fine = false;
                    break;
            }

            if (vettore[0] != 0) {
                int numeriIndovinati = confrontaNumeri(numeriCasuali, vettore);
                visualizzaRisultato(numeriIndovinati);
            }

            Wait(2000);

        } while (fine);
    }

    private static int menu(String[] opzioni, Scanner kyb) {
        int scelta;
        do {
            ClrScr();
            System.out.println("----" + opzioni[0] + "----");
            for (int i = 1; i < opzioni.length; i++) {
                System.out.println(opzioni[i]);
            }
            System.out.println("-------------");
            scelta = kyb.nextInt();

            if (!(scelta >= 1 && scelta < opzioni.length)) {
                System.out.println("Scelta errata!");
                Wait(2000);
            }

        } while (!(scelta >= 1 && scelta < opzioni.length));
        return scelta;
    }

    private static void visualizza(int[] v) {
        for (int i : v) {
            System.out.println(i);
        }
    }

    private static void VisualizzaNumeri(int[] vettore) {
        for (int numero : vettore) {
            System.out.println(numero + " ");
        }
    }

    private static void ClrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void Wait(int tempo) {
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static int[] giocaUtente(Scanner tastiera) {
        int[] vettore = new int[5];
        for (int i = 0; i < 5; i++) {
            do {
                System.out.println("Inserisci il " + (i + 1) + "° numero: ");
                vettore[i] = tastiera.nextInt();
                if (!isNumeroUnico(vettore, vettore[i], i)) {
                    System.out.println("Numero già inserito. Inserisci un numero diverso.");
                }
            } while (!isNumeroUnico(vettore, vettore[i], i));
        }
        return vettore;
    }

    private static boolean isNumeroUnico(int[] array, int numero, int currentIndex) {
        for (int i = 0; i < currentIndex; i++) {
            if (array[i] == numero) {
                return false;
            }
        }
        return true;
    }

    private static int confrontaNumeri(int[] numeriCasuali, int[] vettore) {
        int numeriIndovinati = 0;
        for (int i : numeriCasuali) {
            for (int j : vettore) {
                if (i == j) {
                    numeriIndovinati++;
                }
            }
        }
        return numeriIndovinati;
    }

    private static void visualizzaRisultato(int numeriIndovinati) {
        switch (numeriIndovinati) {
            case 0:
                System.out.println("Non è stato indovinato nessun numero.");
                break;
            case 1:
                System.out.println("Ambata: Hai indovinato 1 numero.");
                break;
            case 2:
                System.out.println("Ambo: Hai indovinato 2 numeri.");
                break;
            case 3:
                System.out.println("Terno: Hai indovinato 3 numeri.");
                break;
            case 4:
                System.out.println("Quaterna: Hai indovinato 4 numeri.");
                break;
            case 5:
                System.out.println("Cinquina: Hai indovinato tutti e 5 i numeri!");
                break;
        }
    }
}

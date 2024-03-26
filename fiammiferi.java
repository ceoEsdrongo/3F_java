import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] Args) {
        Scanner sc = new Scanner(System.in);
        int pl1 = 0, pl2 = 0, fiammiferi = 21;
        int scelta;
        String[] ops = {"[1]-Sfida tra due giocatori", "[2] Sfida contro il bot", "[3] Il bot vince sempre ", "[4] Exit "};
        String errore = "HAI SBAGLIATO HAI SUPERATO IL LIMITE MAX(3)\n";
        System.out.println(Menu(ops, sc));
        scelta = Menu(ops, sc);
        switch (scelta) {
            case 1: {
                System.out.println("Inizia 1\n");
                Wait(200);
                ClrScr();
                System.out.println("* * * * * * * * * * * * * * * * * * * * *\n");
                System.out.println("| | | | | | | | | | | | | | | | | | | | |\n");
                System.out.println("\n");
                do {
                    System.out.println("Inserisce i fammiferi 1\n");
                    fiammiferi = sceltaFiammiferi(sc, pl1, fiammiferi, 1);
                    for (int i = 0; i < fiammiferi; i++) {
                        System.out.printf(" i -");
                    }
                    if (fiammiferi >= 0) {
                        System.out.println("\nFiammiferi rimanenti:" + fiammiferi + "\n");
                        System.out.println("Inserisce i fammiferi 2\n");
                        fiammiferi = sceltaFiammiferi(sc, pl2, fiammiferi, 2);
                        for (int i = 0; i < fiammiferi; i++) {
                            System.out.printf(" i -");
                        }
                        System.out.println("\nFiammiferi rimanenti:" + fiammiferi + "\n");
                    }
                } while (fiammiferi >= 0);
                break;
            }
            case 2:
                System.out.println("Inizia 1\n");
                Wait(200);
                ClrScr();
                System.out.println("* * * * * * * * * * * * * * * * * * * * *\n");
                System.out.println("| | | | | | | | | | | | | | | | | | | | |\n");
                System.out.println("\n");
                do {
                    System.out.println("Inserisce i fammiferi 1\n");
                    fiammiferi = sceltaFiammiferi(sc, pl1, fiammiferi, 1);
                    for (int i = 0; i < fiammiferi; i++) {
                        System.out.printf(" i -");
                    }
                    if (fiammiferi >= 0) {
                        System.out.println("\nFiammiferi rimanenti:" + fiammiferi + "\n");
                        System.out.println("Inserisce i fammiferi il bot\n");
                        fiammiferi = numRand(1, 3);
                        for (int i = 0; i < fiammiferi; i++) {
                            System.out.printf(" i -");
                        }
                        System.out.println("\nFiammiferi rimanenti:" + fiammiferi + "\n");
                    }
                } while (fiammiferi >= 0);
                break;
            case 3:
                break;
        }
    }

    public static void ClrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Wait(int attesa) {
        try {
            Thread.sleep(attesa);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static int Menu(String ops[], Scanner scanner) {
        int scelta;
        do {
            ClrScr();
            System.out.println("------------------");
            System.out.println(ops[0]);
            System.out.println("------------------");
            for (int i = 1; i < ops.length; i++) {
                System.out.println(ops[i]);
            }
            scelta = scanner.nextInt();

            if ((scelta < 1) || (scelta > ops.length - 1)) {
                System.out.println("Opzione Sbagliata");
                Wait(2000);
            }
        }
        while ((scelta < 1) || (scelta > ops.length - 1));

        return scelta;
    }

    private static int sceltaFiammiferi(Scanner scanner, int giocatore, int fiammiferi, int giocatori) {
        giocatore = scanner.nextInt();
        try {
            if (giocatore > 3)
                System.out.println("errore");
        } catch (Exception x) {
            giocatore = 3;
        }
        fiammiferi = fiammiferi - giocatore;
        if (fiammiferi <= 0) {
            System.out.println("il giocatore " + giocatori + " ha vinto\n");
        }
        return fiammiferi;
    }

    private static int numRand(int minValue, int maxValue) {
        Random num = new Random();
        return num.nextInt(1, 3);
    }
}

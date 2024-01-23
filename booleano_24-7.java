import java.util.Scanner;

import java.util.Random;


public class Main {

    public static void main(String[] args) {

        Scanner tastiera = new Scanner(System.in);

        int opzioni, quantiNumeri = 0, posizione = 0;

        boolean fine = true;

        int[] vetNumeri = null;

        int[] vetPari = null;

        int[] vetDispari = null;

        boolean[] vetNumeriB = null;


        do {

            ClrScr();

            menu();

            System.out.println("seleziona un'opzione");

            opzioni = tastiera.nextInt();

            switch (opzioni) {


                case 1:

                    System.out.println(" quanti numeri vuoi generare?");

                    quantiNumeri = tastiera.nextInt();

                    vetNumeri = numeriCasuali(quantiNumeri);

                    break;

                case 2:

                    System.out.println("visualizza numeri");

                    if (vetNumeri != null)

                        visualizza(vetNumeri);

                    else

                        System.out.println("non è stato creato il vettore");

                    break;

                case 3:

                    System.out.println(" numeri pari");

                    if (vetNumeri != null) {

                        vetPari = new int[quantiNumeri];

                        posizione = 0; // Reset the position for each iteration

                        for (int i = 0; i < quantiNumeri; i++) {

                            if (vetNumeri[i] % 2 == 0) {

                                vetPari[posizione] = vetNumeri[i];

                                posizione = posizione + 1;

                            }

                        }

                    } else

                        System.out.println("non è stato creato il vettore");

                    break;

                case 4:

                    if (vetPari != null)

                        visualizza(vetPari);

                    else

                        System.out.println("non è stato creato il vettore");

                    break;

                case 5:

                    System.out.println(" numeri dispari");

                    if (vetNumeri != null) {

                        vetDispari = new int[quantiNumeri];

                        posizione = 0; // Reset the position for each iteration

                        for (int i = 0; i < quantiNumeri; i++) {

                            if (vetNumeri[i] % 2 != 0) {

                                vetDispari[posizione] = vetNumeri[i];

                                posizione = posizione + 1;

                            }

                        }

                    } else

                        System.out.println("non è stato creato il vettore");

                    break;

                case 6:

                    if (vetDispari != null)

                        visualizza(vetDispari);

                    else

                        System.out.println("non è stato creato il vettore");

                    break;

                case 7:

                    vetNumeriB = numeriCasuali2(10);

                    for (int i = 0; i < vetNumeriB.length; i++) {

                        System.out.println(i + "=" + vetNumeriB[i]);

                    }

                    break;

                case 8:

                    System.out.println(" exit");

                    fine = false;

                    break;

                default:

                    System.out.println("opzione errata");

            }

            Wait(2000);


        } while (fine);

    }


    private static void menu() {

        System.out.println("== app numeri casuali");

        System.out.println("[1] genera numeri");

        System.out.println("[2] visualizza numeri");

        System.out.println("[3] numeri pari");

        System.out.println("[4] visualizza pari");

        System.out.println("[5] numeri dispari");

        System.out.println("[6] visualizza numeri dispari");

        System.out.println("[7] genera numeri modo 2");

        System.out.println("[8] exit");

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


    private static int[] numeriCasuali(int n) {

        int casuale;

        int[] vettore = new int[n];

        Random rn = new Random();

        boolean[] numeriGenerati = new boolean[101];


        for (int i = 0; i < n; i++) {

            do {

                casuale = rn.nextInt(101);

            } while (numeriGenerati[casuale]);

            numeriGenerati[casuale] = true;

            vettore[i] = casuale;

        }


        return vettore;

    }


    private static boolean[] numeriCasuali2(int n) {

        int casuale;

        boolean[] numeriGenerati = new boolean[101];

        for (int i = 0; i < n; i++) {

            do {

                casuale = new Random().nextInt(101);

            } while (numeriGenerati[casuale]);

            numeriGenerati[casuale] = true;

        }


        return numeriGenerati;

    }


    private static void visualizza(int[] v) {

        for (int i = 0; i < v.length; i++) {

            System.out.println(i + "=" + v[i]);

        }

    }

}


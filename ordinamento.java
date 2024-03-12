import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        int cont = 0;
        double media = 0;
        String scelta;
        int max, min;

        System.out.println("Quanto lungo deve essere l'array?");
        int n = tastiera.nextInt();
        int[] array = new int[n];
        System.out.println("Inserisci i componenti dell'array");

        for (int i = 0; i < n; i++) {
            array[i] = tastiera.nextInt();
        }

        for (int i = 0; i < n; i++) {
            System.out.println("I numeri inseriti sono " + array[i]);
        }

        for (int i = 0; i < n; i++) {
            cont += array[i];
        }

        System.out.println("La somma dell'array risulta " + cont);
        media = (double) cont / n;
        System.out.println("La media risulta " + media);

        do {
            System.out.println("Scrivi 'max' per determinare il massimo e 'min' per determinare il minimo, oppure 'cres' per ordinamento crescente o 'dec' per ordinamento decrescente");
            scelta = tastiera.next();

            // Calculate max and min values
            max = array[0];
            min = array[0];
            for (int i = 1; i < n; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
                if (array[i] < min) {
                    min = array[i];
                }
            }

            // Bubble sort for ascending order
            if (scelta.equals("cres")) {
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < n - i - 1; j++) {
                        if (array[j] > array[j + 1]) {
                            // swap arr[j+1] and arr[i]
                            int temp = array[j];
                            array[j] = array[j + 1];
                            array[j + 1] = temp;
                        }
                    }
                }
                System.out.println("Array ordinato in ordine crescente:");
                printArray(array);
            }
            // Bubble sort for descending order
            else if (scelta.equals("dec")) {
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < n - i - 1; j++) {
                        if (array[j] < array[j + 1]) {
                            // swap arr[j] and arr[j+1]
                            int temp = array[j];
                            array[j] = array[j + 1];
                            array[j + 1] = temp;
                        }
                    }
                }
                System.out.println("Array ordinato in ordine decrescente:");
                printArray(array);
            } else if (scelta.equals("max")) {
                System.out.println("Il massimo dell'array risulta " + max);
            } else if (scelta.equals("min")) {
                System.out.println("Il minimo dell'array risulta " + min);
            } else {
                System.out.println("Input non valido. Riprova.");
            }
        } while (!scelta.equals("max") && !scelta.equals("min") && !scelta.equals("cres") && !scelta.equals("dec"));
    }

    // Function to print an array
    public static void printArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

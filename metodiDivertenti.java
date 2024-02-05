import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user to enter two integers
        System.out.print("Enter the first number (a): ");
        int a = scanner.nextInt();

        System.out.print("Enter the second number (b): ");
        int b = scanner.nextInt();

        // Close the scanner after obtaining the numbers


        // Calls to functions with the entered numbers
        int sumResult = sum(a, b);
        int differenceResult = difference(a, b);
        int multiplicationResult = multiplication(a, b);
        double divisionResult = division(a, b);
        double powerResult = power(a, b); //double is better, cause big results
        int Risposta;
        do {
            System.out.println("Dimmi quale operazione vuoi svolgere tra queste che ti elenco adesso; 1== somma, 2==differena, 3==moltiplicazione, 4==divisione, 5==potenza");
            int scelta = scanner.nextInt();
            switch (scelta) {
                case 1:
                    System.out.println("Sum: " + sumResult);
                    break;
                case 2:
                    System.out.println("Difference: " + differenceResult);
                    break;
                case 3:
                    System.out.println("Multiplication: " + multiplicationResult);
                    break;
                case 4:
                    System.out.println("Division: " + divisionResult);
                    break;
                case 5:
                    System.out.println("Power: " + powerResult);
                    break;
                default:
                    System.out.println("La scelta non e' valida");

            }
            System.out.println("Vuoi scegliere un'altra opzione? digita 1 per si o qualsiasi altro numero per un no");

            Risposta = scanner.nextInt();
        } while (Risposta == 1);
        scanner.close();
    }
    private static int sum(int x, int y) {
        int somma;
        somma = x + y;
        return somma;
    }

    private static int difference(int x, int y) {
        int differenza;
        differenza = x - y;
        return differenza;
    }

    private static int multiplication(int x, int y) {
        int moltiplicazione;
        moltiplicazione = x * y;
        return moltiplicazione;
    }

    private static double division(int x, int y) {
        return (double) x / y;
    }
    private static double power(int x, int y) {
        double potenza = 1;
        for (int i = 0; i < y; i++) {
            potenza = potenza * x;

        }
        return potenza;
    }
}

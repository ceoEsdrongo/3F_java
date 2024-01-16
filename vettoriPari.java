import java.util.Random;
import java.util.Scanner;

    public class vettoriPari {
        public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);

        System.out.println("Inserisci i numeri da generare");
        n = sc.nextInt();

        int[] vettore = dentroVettore(n);
        int[] vettore1 = vettore;

        System.out.println("Vettore con solo numeri pari:");
        stampaVettore(vettore);
    }

        private static int[] dentroVettore(int n) {
            int casuale;
            int[] vettore = new int[n];
            Random rn = new Random();
            for (int i = 0; i < n; i++) {
            // Genera solo numeri pari
            casuale = rn.nextInt(50) * 2;
            vettore[i] = casuale;
        }
            return vettore;
    }

        private static void stampaVettore(int[] vettore) {
            for (int i = 0; i < vettore.length; i++) {
            System.out.println(vettore[i]);
        }
    }
}

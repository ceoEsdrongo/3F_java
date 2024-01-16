
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        int n, casuale;
        Scanner sc = new Scanner(System.in);
        Random rn = new Random();
        System.out.println("Quanti numeri vuoi inserire?");
        n = sc.nextInt();
        int [] vettore = new int[n];
        int [] vettore1;
       /* for(int i=0;i<n;i++)
        {
            casuale = rn.nextInt(1,101);
            vettore[i] = casuale;
        }*/
        vettore1 = vettore;
        for(int i=0;i<vettore.length;i++){
            System.out.println(vettore[i]);
        }
        for(int i=0;i<vettore.length;i++){
            System.out.println(vettore1[i]);
        }


    }

    public static int[] caricaVettore(int n) {
        Random random = new Random();
        int casuale;
        int[] vettore = new int[n];
        for (int i = 0; i < n; i++) {
            casuale = random.nextInt(1, 101);
            vettore[i] = casuale;
        }
        return vettore;
    }
}



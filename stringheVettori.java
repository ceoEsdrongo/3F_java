/*Inserire in vettore una sequenza di n stringhe,
stampare a video solamente quelle che iniziano con la lettera maiuscola.*/


import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
            Scanner tastiera = new Scanner(System.in);
            int n;
            //System.out.println("inserisci numero di stringhe ");
            //n = tastiera.nextInt();
            String[] vettore = {"Pippo", "Topolino", "Minnie", "pluto"};
            for(int i=0; i< vettore.length;i++)
            {
                if(vettore[i].charAt(0)>='A'&&vettore[i].charAt(0)<='Z')
                {
                    System.out.println("Maiusc: ");
                }
            }




        }
}

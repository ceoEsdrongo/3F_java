/*Introdurre la possibilità di acquistare tre tipi di vino:
1-Barbera 1,5 Euro Litro
2-Lugana 2 Euro Litro
3-Merlot1Euro Litro.
Gli acquisti possono essere eseguiti da clienti diversi fino alla chiusura della cassa.*/
/*Progettare
  e codificare un programma che consenta di stabilire il totale che ogni cliente
  deve pagare considerando che l’iva applicata è del 21%.
  Specifiche di progetto
  •Ogni bottiglione ha una capacità 1.5L
  •Il costo al litro è di 1Euro
  •Stampare lo scontrino con le seguenti informazioni relative ad ogni cliente:
 il n° di bottiglioni acquistati;
 il prezzo totale di vendita (costo L x litri);
 calcolare l’iva applica al totale imponibile;
 il prezzo di vendita totale comprensivo di iva.
 Introdurre la possibilità di acquistare tre tipi di vino:
 1-Barbera 1,5 Euro Litro
 2-Lugana 2 Euro Litro
 3-Merlot1Euro Litro.
 Gli acquisti possono essere eseguiti da clienti diversi fino alla chiusura della cassa.
 */
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner tastiera=new Scanner(System.in);
    int scelta, barbera=0, lugana=0, merlot=0, clienti=0;
    double prezzo, iva, totale, cassa=0;
    String siNo = "";
    
    do{
      System.out.println("Inserire i vini da aquistare 1-Barbera 1,5 Euro Litro 2-Lugana 2 Euro Litro                 3-Merlot1Euro Litro");
      scelta=tastiera.nextInt();
      if(scelta==1){
        System.out.println("Inserire il numero di bottiglie da acquistare");
        barbera=tastiera.nextInt();
        while(barbera<=0){
          System.out.println("Inserire un numero maggiore di 0");
          barbera=tastiera.nextInt();
      }
        prezzo = barbera*2.25;
        iva=prezzo*0.21;
        totale=prezzo+iva;
        System.out.println("numero bottiglioni aquistati "+barbera+"il costo senza iva "+prezzo+"il prezzo totale è "+totale+ "di cui iva " + iva);
        cassa=cassa+totale;
        clienti++;
        System.out.println("Vuoi continuare?");
        siNo=tastiera.next();
        
      }else if(scelta==2){
        System.out.println("Inserire il numero di bottiglie da acquistare");
          lugana=tastiera.nextInt();
          while(lugana<=0){
            System.out.println("Inserire un numero maggiore di 0");
            lugana=tastiera.nextInt();
        }
          prezzo = lugana*3;
          iva=prezzo*0.21;
          totale=prezzo+iva;
          System.out.println("numero bottiglioni aquistati "+lugana+"il costo senza iva "+prezzo+"il prezzo totale è "+totale+ "di cui iva " + iva);
          cassa=cassa+totale;
          clienti++;
          System.out.println("Vuoi continuare?");
          siNo=tastiera.next();

      }else if(scelta==3){
          System.out.println("Inserire il numero di bottiglie da acquistare");
          merlot=tastiera.nextInt();
          while(merlot<=0){
          System.out.println("Inserire un numero maggiore di 0");
          merlot=tastiera.nextInt();
          }
          prezzo = merlot*1.5;
          iva=prezzo*0.21;
          totale=prezzo+iva;
          System.out.println("numero bottiglioni aquistati "+merlot+"il costo senza iva "+prezzo+"il prezzo totale è "+totale+ "di cui iva " + iva);
          cassa=cassa+totale;
          clienti++;
          System.out.println("Vuoi continuare?");
          siNo=tastiera.next();

      }else {
        System.out.println("Inserire un numero tra 1 e 3");
      }
    } while (siNo.equals("si"));
    System.out.println("grazie da aver aquistato da esdrongo vini e buona giornata");
    System.out.println("Chiusura cassa\n"+"numero clienti"+clienti + "\nguadagno totale"+cassa);
  }
}
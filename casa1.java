/*Data una stringa di caratteri determinare se contiene solo caratteri alfabetici (A..Z);
Per risolvere l'esercizio utilizzare un metodo
 che ritorna un valore bool true se sono tutti alfabetici, false in caso contrario.
Se true stampare "Tutti alfabetici" altrimenti  altrimenti "Stringa errata".*/

public class Main {
    public static void main(String[] args) {
        String[] Alfa = {"A", "1", "B","2" , "C"};
        tipo(Alfa);
        stampaArray(Alfa);

    }
    private static boolean tipo(String[] Alfa){
        boolean cont= true;
        for(int i=0;i<Alfa.length;i++){
            if(Alfa[i].charAt(0)>='A'&&Alfa[i].charAt(0)<='Z'){
                System.out.println(Alfa[i]);
                //inserisco nuovo array
            }
            else {
                cont = false;
            }
        }
        return cont;
    }
    private static void stampaArray(String[] a){
        for (int i = 0; i<a.length; i++)
            System.out.println(a[i]);
    }
}

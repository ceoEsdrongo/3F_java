/*Data una stringa di caratteri determinare se contiene solo caratteri alfabetici (A..Z);
Per risolvere l'esercizio utilizzare un metodo
che ritorna un valore bool true se sono tutti alfabetici, false in caso contrario.
Se true stampare "Tutti alfabetici" altrimenti  altrimenti "Stringa errata".*/
public class Main {
    public static void main(String[] args) {
        String[] az = {"A", "B", "C", "1","2","3" };
        if(magnifico(az)){
            System.out.println("tutti alfabetici");
        }
        else{
            System.out.println("Stringa errata");
        }

    }
    private static boolean magnifico(String[]az){
        boolean cont = true;
        for(int i=0;i< az.length;i++){
            if(az[i].charAt(0)>='A' && az[i].charAt(0)<='C'){
                stampaArray(az[i]);
            }
        }
        return cont;
    }
    private static void stampaArray(String X){
        System.out.println(X);
    }
}


   public class Main {
    public static void main(String[] args) {
        
        // Dichiarazione e inizializzazione dell'array con alcuni valori
        int [] vet1 = {3, 7, 6, 1, 0, 0, 3, 4};
        
        // Dichiarazione di un nuovo array per contenere gli elementi ordinati senza duplicati
        int [] vet2 = new int[vet1.length];
        
        // Variabile per tenere traccia della posizione del primo elemento dispari
        int primoDispari = vet1.length;
        
        // Variabile per contare gli elementi unici
        int unici = 0;
        
        // Ordina l'array in modo che gli elementi pari siano a sinistra e quelli dispari a destra
        int temp;
        for (int i = 0; i < vet1.length; i++) {
            if(vet1[i] % 2 == 0) {
                // Scambia gli elementi pari con quelli dispari
                temp = vet1[unici];
                vet1[unici] = vet1[i];
                vet1[i] = temp;
                unici++;
            }
        }
        
        // Rimuovi i duplicati dall'array ordinato
        int j = 0;
        for (int i = 0; i < unici; i++) {
            if (i == 0 || vet1[i] != vet1[i - 1]) {
                vet2[j++] = vet1[i];
            }
            
            // Memorizza la posizione del primo elemento dispari
            if(vet1[i] % 2 != 0 && i < primoDispari) {
                primoDispari = i;
            }
        }
        
        // Stampa il nuovo array ordinato senza duplicati
        System.out.println("Array ordinato e senza duplicati:");
        for (int i = 0; i < j; i++) {
            System.out.println(vet2[i]);
        }
        
        // Stampa la posizione del primo numero dispari
        System.out.println("Posizione del primo numero dispari: " + primoDispari);
        
        // Stampa i numeri dispari presenti nell'array
        System.out.println("Numeri dispari:");
        for (int i = primoDispari; i < unici; i++) {
            System.out.println(vet1[i]);
        }
    }
}

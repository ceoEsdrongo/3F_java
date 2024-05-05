public class SelectionSort {
    public static void main(String[] args) {
        // Dichiarazione e inizializzazione dell'array con alcuni valori
        int[] array = {15, -2, 7, 1, 4, 9};
        
        // Variabile per tenere traccia della posizione dell'elemento minimo
        int posMin;
        
        // Variabile temporanea per scambiare gli elementi
        int temp;
        
        // Ciclo esterno per attraversare ogni elemento dell'array
        for (int i = 0; i < array.length; i++) {
            // Imposta l'indice corrente come posizione minima iniziale
            posMin = i;
            
            // Ciclo interno per trovare l'elemento minimo nell'array a partire da i
            for (int j = i; j < array.length; j++) {
                // Se l'elemento attuale è minore dell'elemento in posMin, aggiorna posMin
                if (array[j] < array[posMin]) {
                    posMin = j;
                }
            }
            
            // Se l'elemento minimo trovato è diverso dall'elemento corrente, esegui lo scambio
            if (i != posMin) {
                // Scambia gli elementi
                temp = array[i];
                array[i] = array[posMin];
                array[posMin] = temp;
            }
        }
        
        // Stampa gli elementi ordinati dell'array
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}

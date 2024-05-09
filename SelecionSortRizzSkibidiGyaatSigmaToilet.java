
public class Main {
    public static void main(String[] args) {
        // Crea un array di interi con alcuni duplicati
        int[] vet1 = {3, 7, 6, 1, 0, 0, 3, 4};

        // Applica l'ordinamento selection sort sull'array
        selectionSort(vet1);
        // Riordina l'array mettendo i numeri pari a sinistra e dispari a destra
        ordinamento(vet1);
        // Stampa gli elementi unici presenti nell'array
        System.out.print("ARRAY(non so come indicarlo): ");
        doppioni(vet1);
        System.out.println(); // Stampa una nuova riga alla fine degli elementi unici
        
        // Cicla attraverso ogni elemento dell'array e lo stampa
        for (int i : vet1) {
            System.out.print(i + " ");
        }
        System.out.println(); // Stampa una nuova riga dopo l'array finale
    }

    // Metodo per eseguire l'ordinamento selection sort sull'array
    public static void selectionSort(int[] array) {
        // Ciclo esterno: scorre ogni elemento dell'array
        for (int i = 0; i < array.length - 1; i++) {
            // Inizializza la posizione del minimo all'elemento corrente
            int minimo = i;
            // Ciclo interno: cerca il minimo nell'array a partire da `i + 1`
            for (int j = i + 1; j < array.length; j++) {
                // Se trova un elemento più piccolo, aggiorna la posizione del minimo
                if (array[minimo] > array[j]) {
                    minimo = j;
                }
            }
            // Se il minimo non è all'indice `i`, scambia i due elementi
            if (minimo != i) {
                // Scambia `array[i]` e `array[minimo]`
                int temp = array[minimo];
                array[minimo] = array[i];
                array[i] = temp;
            }
        }
    }

    // Metodo per ordinare l'array mettendo i numeri pari a sinistra e dispari a destra
    public static void ordinamento(int[] array) {
        // Indice per l'elemento pari
        int pari = 0;
        // Indice per l'elemento dispari
        int dispari = array.length - 1;
        // Continua finché `pari` non supera `dispari`
        while (pari <= dispari) {
            // Se `array[pari]` è pari, incrementa `pari`
            if (array[pari] % 2 == 0) {
                pari++;
            }
            // Se `array[dispari]` è dispari, decrementa `dispari`
            else if (array[dispari] % 2 != 0) {
                dispari--;
            }
            // Altrimenti, scambia gli elementi pari e dispari
            else {
                int temp = array[pari];
                array[pari] = array[dispari];
                array[dispari] = temp;
                pari++;
                dispari--;
            }
        }
    }

    // Metodo per stampare gli elementi unici presenti nell'array
    public static void doppioni(int[] array) {
        // Variabile per tenere traccia dell'ultimo elemento univoco stampato
        int prev = -1; // Utilizza un valore che non può essere presente nell'array

        // Ciclo attraverso l'array
        for (int i = 0; i < array.length; i++) {
            // Variabile per indicare se `array[i]` è unico
            boolean uno = true;

            // Ciclo interno per verificare se `array[i]` è stato già incontrato
            for (int j = 0; j < i; j++) {
                // Se `array[i]` è uguale a un elemento precedente, non è unico
                if (array[i] == array[j]) {
                    uno = false;
                    break; // Interrompe il ciclo interno
                }
            }

            // Se `array[i]` è unico e diverso da `prev`, stampalo
            if (uno && array[i] != prev) {
                System.out.print(array[i] + " ");
                // Aggiorna `prev` con l'ultimo elemento univoco stampato
                prev = array[i];
            }
        }
    }
}

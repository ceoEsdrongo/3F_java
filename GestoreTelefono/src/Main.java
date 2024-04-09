import java.util.Scanner;

import static Tools.Utility.*;

public class Main {
    public static void main(String[] args) {
        int contacontatti = 0;
        final int nContratti = 3;
        boolean uscita = false;
        Scanner tastiera = new Scanner(System.in);
        Persona[] gestore = new Persona[nContratti];
        String[] opzioni = {"***CENTRO ACCOGGLIENZA VODAFONZ***", "1-Inserimento", "2-Visualizza", "3-Fine"};
        do {

            switch (menu(opzioni, tastiera)) {
                case 1:
                    if (contacontatti < nContratti) {
                        Persona nuovoContatto = LeggiContatto(tastiera);
                        if (trovaContatto(gestore, nuovoContatto, contacontatti) == -1) {
                            gestore[contacontatti] = nuovoContatto;
                            contacontatti++;
                        } else {
                            System.out.println("Il contatto è già presente nella collezione.");
                        }
                    } else {
                        System.out.println("Non ci sono più contratti da vendere");
                    }
                    ;
                    break;
                case 2:
                    if (contacontatti > 0) {
                        Visualizza(gestore, contacontatti);
                    } else {
                        System.out.println("Non ci sono contatti da visualizzare");
                    }
                    ;
                    break;
                case 3:
                    uscita = true;
                    ;
                    break;

            }

        } while (!uscita);
        System.out.println("Fine programma");
    }

    public static Persona LeggiContatto(Scanner tastiera) {
        Persona contatto = new Persona();
        System.out.println("Inserici il nome");
        contatto.nome = tastiera.nextLine();
        System.out.println("Inserici il cognome");
        contatto.cognome = tastiera.nextLine();
        System.out.println("Inserici il numero di telefono");
        contatto.numDiTelefono = tastiera.nextLine();
        String[] opzioni = {"TipoAbbonamento", "1-cellulare", "2-abitazione", "3-azienda"};
        int scelta;
        do {
            scelta = menu(opzioni, tastiera);
            switch (scelta) {
                case 1:
                    contatto.tipo = Tipologia.cellulare;
                    break;
                case 2:
                    contatto.tipo = Tipologia.abitazione;
                    break;
                case 3:
                    contatto.tipo = Tipologia.azienda;
                    break;
            }

        } while (scelta > 3 || scelta < 1);

        return contatto;
    }

    public static int trovaContatto(Persona[] gestore, Persona nuovoContatto, int contacontatti) {
        for (int i = 0; i < contacontatti; i++) {
            if (gestore[i].cognome.equalsIgnoreCase(nuovoContatto.cognome) && gestore[i].nome.equalsIgnoreCase(nuovoContatto.nome)) {
                return i; // Restituisce l'indice del contatto se trovato
            }
        }
        return -1; // Restituisce -1 se il contatto non è stato trovato
    }

    public static void Visualizza(Persona gestore[], int contacontatti) {
        for (int i = 0; i < contacontatti; i++) {
            System.out.println(gestore[i].anagrafica());
        }
    }
}
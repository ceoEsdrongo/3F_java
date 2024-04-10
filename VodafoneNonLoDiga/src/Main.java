import java.util.Scanner;

import static Tools.Utility.*;

public class Main {
    public static void main(String[] args) {
        int contacontatti = 0;
        final int nContratti = 3;
        boolean uscita = false;
        Scanner tastiera = new Scanner(System.in);
        Persona[] gestore = new Persona[nContratti];
        String[] opzioni = {"***CENTRO ACCOGGLIENZA VODAFONZ***", "1-Inserimento", "2-Visualizza", "3 Ricerca","4-Fine"};
        boolean fine = false;

        int contaContatti = 0;

        do {
            switch (menu(opzioni, tastiera)) {
                case 1 -> {
                    if (nContratti > contaContatti) {
                        boolean presente = false;
                        Persona dettagli = LeggiContatto(tastiera);
                        for (int i = 0; i < contaContatti; i++) {
                            if (dettagli.nome.equals(gestore[i].nome) && dettagli.cognome.equals(gestore[i].cognome)) {
                                System.out.println("La persona con questo nome e cognome è già presente!");
                                presente = true;
                                break;
                            }
                        }
                        if(!presente) {
                            gestore[contaContatti] = dettagli;
                            contaContatti++;
                        }
                    } else {
                        System.out.println("Finiti contratti");
                    }
                }
                case 2 -> {
                    if (contaContatti > 0) {
                        Visualizza(gestore, contaContatti);
                    } else {
                        System.out.println("Non ci sono contatti da visualizzare");
                    }
                }
                case 3 -> {
                    if (contaContatti > 0) {
                        if (verificaPresenzaContatto(tastiera, gestore, contaContatti)) {
                            System.out.println("Contatto presente");
                            Visualizza(gestore, contaContatti);
                        } else {
                            System.out.println("Contatto non presente");
                            System.out.println("Aggiunta del nuovo contatto...");
                            gestore[contaContatti] = LeggiContatto(tastiera);
                            contaContatti++;
                            System.out.println("Contatto aggiunto con successo.");
                        }

                    } else {
                        System.out.println("Non ci sono contatti");
                    }
                }
                case 4 -> fine = true;
            }
        } while (!fine);
        System.out.println("Fine programma");
    }

    public static Persona LeggiContatto(Scanner tastiera) {
        Persona contatto = new Persona();

        System.out.println("Inserisci il nome");
        contatto.nome = tastiera.nextLine();
        System.out.println("Inserisci il cognome");
        contatto.cognome = tastiera.nextLine();
        System.out.println("Inserisci il numero di telefono");
        contatto.numDiTelefono = tastiera.nextLine();
        String[] opzioni = {"Tipo di abbonamento", "1 - cellulare", "2 - Abitazione", "3 - Azienda"};

        int scelta;
        do {
            scelta = menu(opzioni, tastiera);
            switch (scelta) {
                case 1 -> contatto.tipo = Tipologia.cellulare;
                case 2 -> contatto.tipo = Tipologia.abitazione;
                case 3 -> contatto.tipo = Tipologia.azienda;
            }
        } while (scelta > 3 || scelta < 1);

        return contatto;
    }

    public static void Visualizza(Persona[] gestore, int contaContatti) {
        for (int i = 0; i < contaContatti; i++) {
            System.out.println(gestore[i].anagrafica());
        }
    }

    public static boolean verificaPresenzaContatto(Scanner tastiera, Persona[] gestore, int contaContatti) {
        System.out.println("Inserisci il nome");
        String nome = tastiera.nextLine();
        System.out.println("Inserisci il cognome");
        String cognome = tastiera.nextLine();

        for (int i = 0; i < contaContatti; i++) {
            if (gestore[i].nome.equals(nome) && gestore[i].cognome.equals(cognome)) {
                return true; // Contatto presente
            }
        }

        return false; // Contatto non presente
    }
}
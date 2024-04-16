import java.util.Scanner;

import static Tools.Utility.menu;

public class Main {
    public static void main(String[] args) {
        final int nContratti = 3;
        Scanner tastiera = new Scanner(System.in);
        Persona[] gestore = new Persona[nContratti];
        String[] opzioni = {"Gestore Telefonico", "1 - Inserimento", "2 - Visualizza", "3 - Verifica presenza contatto", "4 - Ricerca numero telefono", "5 - Elimina contatto", "6 - Fine"};

        boolean fine = false;
        int contaContatti = 0;
        int posizione = -1;

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
                    boolean visualizzaSingolo = false;
                    if (contaContatti > 0) {
                        Visualizza(gestore, contaContatti, visualizzaSingolo, tastiera, posizione);
                    } else {
                        System.out.println("Non ci sono contatti da visualizzare");
                    }
                }
                case 3 -> {
                    if (contaContatti > 0) {
                        if (verificaPresenzaContatto(tastiera, gestore, contaContatti)!=-1) {
                            System.out.println("Contatto presente");
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
                case 4 -> {
                    boolean visualizzaSingolo = true;
                    if (contaContatti > 0) {
                        posizione = verificaPresenzaContatto(tastiera, gestore, contaContatti);
                        if (posizione!=-1) {
                            System.out.println("Contatto presente");
                            Visualizza(gestore, contaContatti, visualizzaSingolo, tastiera, posizione);
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
                case 5 -> eliminaContatto(gestore, contaContatti, tastiera);
                case 6 -> fine = true;
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

    public static void Visualizza(Persona[] gestore, int contaContatti, boolean visualizzaSingolo, Scanner tastiera, int posizione) {
        if (!visualizzaSingolo){
            for (int i = 0; i < contaContatti; i++) {
                System.out.println(gestore[i].anagrafica());
            }
        } else {
            System.out.println(gestore[posizione].ricercaSingola());
        }
    }

    public static int verificaPresenzaContatto(Scanner tastiera, Persona[] gestore, int contaContatti) {
        System.out.println("Inserisci il nome");
        String nome = tastiera.nextLine();
        System.out.println("Inserisci il cognome");
        String cognome = tastiera.nextLine();

        for (int i = 0; i < contaContatti; i++) {
            if (gestore[i].nome.equals(nome) && gestore[i].cognome.equals(cognome)) {
                return i;
            }
        }

        return -1;
    }

    public static void eliminaContatto(Persona[] gestore, int contaContatti, Scanner tastiera) {
        System.out.println("Seleziona il metodo per trovare e cancellare il contatto:");
        System.out.println("1 - Inserendo il numero di telefono");
        System.out.println("2 - Inserendo il cognome e il nome");
        int scelta = tastiera.nextInt();
        tastiera.nextLine();

        switch (scelta) {
            case 1:
                eliminaContattoPerNumero(gestore, contaContatti, tastiera);
                break;
            case 2:
                eliminaContattoPerNome(gestore, contaContatti, tastiera);
                break;
            default:
                System.out.println("Scelta non valida.");
        }
    }

    public static void eliminaContattoPerNumero(Persona[] gestore, int contaContatti, Scanner tastiera) {
        System.out.println("Inserisci il numero di telefono del contatto da eliminare:");
        String numeroTelefono = tastiera.nextLine();

        for (int i = 0; i < contaContatti; i++) {
            if (gestore[i].numDiTelefono.equals(numeroTelefono)) {
                for (int j = i; j < contaContatti - 1; j++) {
                    gestore[j] = gestore[j + 1];
                }
                gestore[contaContatti - 1] = new Persona();
                contaContatti--;
                System.out.println("Contatto eliminato con successo.");
                return;
            }
        }
        System.out.println("Contatto non trovato.");
    }

    public static void eliminaContattoPerNome(Persona[] gestore, int contaContatti, Scanner tastiera) {
        System.out.println("Inserisci il nome del contatto da eliminare:");
        String nome = tastiera.nextLine();
        System.out.println("Inserisci il cognome del contatto da eliminare:");
        String cognome = tastiera.nextLine();

        for (int i = 0; i < contaContatti; i++) {
            if (gestore[i].nome.equals(nome) && gestore[i].cognome.equals(cognome)) {
                for (int j = i; j < contaContatti - 1; j++) {
                    gestore[j] = gestore[j + 1];
                }
                gestore[contaContatti - 1] = new Persona();
                contaContatti--;
                System.out.println("Contatto eliminato con successo.");
                return;
            }
        }
        System.out.println("Contatto non trovato.");
    }
}

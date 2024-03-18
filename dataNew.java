import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        int i = 0;

        int data;
        boolean lunghezzaData1;
        boolean formatData;
        do {
            do {
                System.out.println("Inserisci una data (max 8 cifre, min 7)");
                data = tastiera.nextInt();
                boolean bisestile = Bisestile(data);
                lunghezzaData1 = CtrlData(data);
                formatData = DataOn(data, bisestile);
            } while(lunghezzaData1);
        } while(!formatData);

        int[] dataNumeri = PatternData(data);
        System.out.println("Il giorno è " + dataNumeri[i]);
        i++;
        System.out.println("Il mese è " + dataNumeri[i]);
        i++;
        System.out.println("L'anno  è " + dataNumeri[i]);
        MeseStringa(dataNumeri);

        // Menu per aggiungere o togliere giorni
        boolean continua = true;
        while (continua) {
            System.out.println("\nMenu:");
            System.out.println("1. Aggiungi giorni");
            System.out.println("2. Togli giorni");
            System.out.println("3. Esci");
            System.out.print("Scelta: ");
            int scelta = tastiera.nextInt();
            
            switch (scelta) {
                case 1:
                    System.out.print("Inserisci il numero di giorni da aggiungere: ");
                    int giorniAggiunti = tastiera.nextInt();
                    dataNumeri = data_up(dataNumeri, giorniAggiunti);
                    System.out.println("Nuova data dopo l'aggiunta di " + giorniAggiunti + " giorni:");
                    MeseStringa(dataNumeri);
                    break;
                case 2:
                    System.out.print("Inserisci il numero di giorni da togliere: ");
                    int giorniTolto = tastiera.nextInt();
                    dataNumeri = data_down(dataNumeri, giorniTolto);
                    System.out.println("Nuova data dopo la rimozione di " + giorniTolto + " giorni:");
                    MeseStringa(dataNumeri);
                    break;
                case 3:
                    continua = false;
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }
        }
    }

    public static boolean CtrlData(int data) {
        return data < 1010001 || data >= 31129999;
    }

    public static int[] PatternData(int data) {
        int[] separatore = new int[3];
        int i = 2;
        separatore[i] = data % 10000;
        i--;
        separatore[i] = (data % 1000000 - data % 10000) / 10000;
        i--;
        separatore[i] = (data % 100000000 - data % 1000000) / 1000000;
        return separatore;
    }

    public static void MeseStringa(int[] dataNumeri) {
        switch (dataNumeri[1]) {
            case 1:
                System.out.println(dataNumeri[0] + " Gennaio " + dataNumeri[2]);
                break;
            case 2:
                System.out.println(dataNumeri[0] + " Febbraio " + dataNumeri[2]);
                break;
            case 3:
                System.out.println(dataNumeri[0] + " Marzo " + dataNumeri[2]);
                break;
            case 4:
                System.out.println(dataNumeri[0] + " Aprile " + dataNumeri[2]);
                break;
            case 5:
                System.out.println(dataNumeri[0] + " Maggio " + dataNumeri[2]);
                break;
            case 6:
                System.out.println(dataNumeri[0] + " Giugno " + dataNumeri[2]);
                break;
            case 7:
                System.out.println(dataNumeri[0] + " Luglio " + dataNumeri[2]);
                break;
            case 8:
                System.out.println(dataNumeri[0] + " Agosto " + dataNumeri[2]);
                break;
            case 9:
                System.out.println(dataNumeri[0] + " Settembre " + dataNumeri[2]);
                break;
            case 10:
                System.out.println(dataNumeri[0] + " Ottobre " + dataNumeri[2]);
                break;
            case 11:
                System.out.println(dataNumeri[0] + " Novembre " + dataNumeri[2]);
                break;
            case 12:
                System.out.println(dataNumeri[0] + " Dicembre " + dataNumeri[2]);
        }
    }

    public static boolean DataOn(int data, boolean bisestile) {
        int[] separatore = new int[3];
        boolean controllo = true;
        int i = 2;
        separatore[i] = data % 10000;
        --i;
        separatore[i] = (data % 1000000 - data % 10000) / 10000;
        --i;
        separatore[i] = (data % 100000000 - data % 1000000) / 1000000;
        switch (separatore[1]) {
            case 1:
                if (separatore[0] > 31) {
                    controllo = false;
                }
                break;
            case 2:
                if (bisestile) {
                    if (separatore[0] > 29) {
                        controllo = false;
                    }
                } else if (separatore[0] > 28) {
                    controllo = false;
                }
                break;
            case 3:
                if (separatore[0] > 31) {
                    controllo = false;
                }
                break;
            case 4:
                if (separatore[0] > 30) {
                    controllo = false;
                }
                break;
            case 5:
                if (separatore[0] > 31) {
                    controllo = false;
                }
                break;
            case 6:
                if (separatore[0] > 30) {
                    controllo = false;
                }
                break;
            case 7:
                if (separatore[0] > 31) {
                    controllo = false;
                }
                break;
            case 8:
                if (separatore[0] > 31) {
                    controllo = false;
                }
                break;
            case 9:
                if (separatore[0] > 30) {
                    controllo = false;
                }
                break;
            case 10:
                if (separatore[0] > 31) {
                    controllo = false;
                }
                break;
            case 11:
                if (separatore[0] > 30) {
                    controllo = false;
                }
                break;
            case 12:
                if (separatore[0] > 31) {
                    controllo = false;
                }
                break;
            default:
                controllo = false;
        }

        if (separatore[2] > 9999) {
            controllo = false;
        }

        return controllo;
    }

    public static boolean Bisestile(int data) {
        int[] separatore = new int[3];
        int i = 2;
        separatore[i] = data % 10000;
        --i;
        separatore[i] = (data % 1000000 - data % 10000) / 10000;
        --i;
        separatore[i] = (data % 100000000 - data % 1000000) / 1000000;
        return separatore[0] % 4 == 0 && separatore[0] % 100 != 0 || separatore[0] % 400 == 0;
    }

    // Metodo per aggiungere giorni alla data
    public static int[] data_up(int[] dataNumeri, int giorniAggiunti) {
        // Consideriamo solo il giorno (dataNumeri[0])
        dataNumeri[0] += giorniAggiunti;
        // Aggiustiamo la data se il nuovo giorno supera il limite massimo del mese
        int mese = dataNumeri[1];
        int anno = dataNumeri[2];
        switch (mese) {
            case 1: // Gennaio
            case 3: // Marzo
            case 5: // Maggio
            case 7: // Luglio
            case 8: // Agosto
            case 10: // Ottobre
            case 12: // Dicembre
                if (dataNumeri[0] > 31) {
                    dataNumeri[0] -= 31;
                    mese++;
                }
                break;
            case 4: // Aprile
            case 6: // Giugno
            case 9: // Settembre
            case 11: // Novembre
                if (dataNumeri[0] > 30) {
                    dataNumeri[0] -= 30;
                    mese++;
                }
                break;
            case 2: // Febbraio
                if (Bisestile(anno)) {
                    if (dataNumeri[0] > 29) {
                        dataNumeri[0] -= 29;
                        mese++;
                    }
                } else {
                    if (dataNumeri[0] > 28) {
                        dataNumeri[0] -= 28;
                        mese++;
                    }
                }
                break;
        }
        // Aggiustiamo l'anno se il nuovo mese supera il limite di dicembre
        if (mese > 12) {
            mese -= 12;
            anno++;
        }
        dataNumeri[1] = mese;
        dataNumeri[2] = anno;
        return dataNumeri;
    }

    // Metodo per togliere giorni dalla data
    public static int[] data_down(int[] dataNumeri, int giorniTolto) {
        // Consideriamo solo il giorno (dataNumeri[0])
        dataNumeri[0] -= giorniTolto;
        // Aggiustiamo la data se il nuovo giorno diventa negativo
        int mese = dataNumeri[1];
        int anno = dataNumeri[2];
        while (dataNumeri[0] <= 0) {
            mese--; // Scendiamo di un mese
            // Aggiustiamo il mese se diventa negativo
            if (mese <= 0) {
                mese += 12;
                anno--; // Scendiamo di un anno
            }
            // Determiniamo quanti giorni ha il mese precedente
            int giorniNelMesePrecedente;
            switch (mese) {
                case 1: // Gennaio
                case 3: // Marzo
                case 5: // Maggio
                case 7: // Luglio
                case 8: // Agosto
                case 10: // Ottobre
                case 12: // Dicembre
                    giorniNelMesePrecedente = 31;
                    break;
                case 4: // Aprile
                case 6: // Giugno
                case 9: // Settembre
                case 11: // Novembre
                    giorniNelMesePrecedente = 30;
                    break;
                case 2: // Febbraio
                    if (Bisestile(anno)) {
                        giorniNelMesePrecedente = 29;
                    } else {
                        giorniNelMesePrecedente = 28;
                    }
                    break;
                default:
                    giorniNelMesePrecedente = 0; // Caso di errore, non dovrebbe mai succedere
            }
            dataNumeri[0] += giorniNelMesePrecedente; // Aggiungiamo i giorni del mese precedente
        }
        dataNumeri[1] = mese;
        dataNumeri[2] = anno;
        return dataNumeri;
    }
}

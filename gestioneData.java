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
}

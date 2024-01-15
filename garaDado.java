import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random valore = new Random();

        int valFaccia= valore.nextInt(0,6)+1;

        int valFaccia2= valore.nextInt(0,6)+1;

        for(int n=1;n<=2;n++){

            for(int i=1; i<=6; i++){

                dado(i);

                attesa(1);

                cls();

            }

            if(n==1){

                attesa(1);

                System.out.println("Al primo concorrente è uscito  " + valFaccia);

                dado(valFaccia);

                System.out.println("Ritira il dado");

            }else{

                attesa(1);

                System.out.println("Al secondo concorrente è uscito " + valFaccia2);

                dado(valFaccia2);

            }

        }

        if(valFaccia>valFaccia2) {

            System.out.println("il primo concorrente ha vinto");

        }else if(valFaccia<valFaccia2){

            System.out.println("il secondo concorrente ha vinto");

        }else{

            System.out.println("draw");

        }

    }

    public static void dado(int faccia){

        switch (faccia){

            case 1: System.out.println("\t\t\t\t ╔════════╗");

                System.out.println("\t\t\t\t ║        ║");

                System.out.println("\t\t\t\t ║    0   ║");

                System.out.println("\t\t\t\t ║        ║");

                System.out.println("\t\t\t\t ╚════════╝");

                break;

            case 2: System.out.println("\t\t\t\t ╔════════╗");

                System.out.println("\t\t\t\t ║0       ║");

                System.out.println("\t\t\t\t ║        ║");

                System.out.println("\t\t\t\t ║       0║");

                System.out.println("\t\t\t\t ╚════════╝");

                break;

            case 3: System.out.println("\t\t\t\t ╔════════╗");

                System.out.println("\t\t\t\t ║0       ║");

                System.out.println("\t\t\t\t ║    0   ║");

                System.out.println("\t\t\t\t ║       0║");

                System.out.println("\t\t\t\t ╚════════╝");

                break;

            case 4: System.out.println("\t\t\t\t ╔════════╗");

                System.out.println("\t\t\t\t ║0      0║");

                System.out.println("\t\t\t\t ║        ║");

                System.out.println("\t\t\t\t ║0      0║");

                System.out.println("\t\t\t\t ╚════════╝");

                break;

            case 5: System.out.println("\t\t\t\t ╔════════╗");

                System.out.println("\t\t\t\t ║0      0║");

                System.out.println("\t\t\t\t ║    0   ║");

                System.out.println("\t\t\t\t ║0      0║");

                System.out.println("\t\t\t\t ╚════════╝");

                break;

            case 6: System.out.println("\t\t\t\t ╔════════╗");

                System.out.println("\t\t\t\t ║0      0║");

                System.out.println("\t\t\t\t ║0      0║");

                System.out.println("\t\t\t\t ║0      0║");

                System.out.println("\t\t\t\t ╚════════╝");

                break;

            default:

                System.out.println("Valore non valido");

                break;

        }

    }

    public static void attesa(int x) {

        try {

            Thread.sleep(1000*x);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

    }

    public static void cls() {

        try {

            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

        } catch (Exception E) {

            System.out.println(E);

        }

    }

}


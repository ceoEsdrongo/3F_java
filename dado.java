import java.util.Random;
public class dado {
    public static void main(String[] args)
    {
        System.out.println("Benvenuto!");
        Random valore = new Random();
        int valFaccia= valore.nextInt(0,6)+1;
        for(int i=1; i<=6; i++){
            dado(i);
            attesa(1);
            cls();
        }
        System.out.println("è uscita la faccia numero " + valFaccia);
        dado(valFaccia);
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
            default:System.out.println("Valore non valido");break;
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
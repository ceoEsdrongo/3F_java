public class Main {
    public static void main(String[] args) {
        int [] numerini = {-1, 5, -7,24,-12};
        tuttiPositivi(numerini);
        stampaArray(numerini);
        int [] numerinino = {-66, 45, -27,234,-122};
        tuttiPositivi(numerinino);
        stampaArray(numerinino);

    }
    private static void tuttiPositivi(int[] x)
    {
        int [] positivi = new int[x.length];
        for(int i=0;i<x.length;i++){
            if (x[i]<0){
                x[i]=x[i]*-1;
            }

        }
    }
    private static void stampaArray(int[] a){
        for (int i = 0; i<a.length; i++)
            System.out.println(a[i]);
    }
}

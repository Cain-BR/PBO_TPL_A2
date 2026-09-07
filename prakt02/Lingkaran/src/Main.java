public class Main {
    public static void main(String[] args) {
        Lingkaran obj01 = new Lingkaran(r:10);
        String L = String.format("%8.2f", obj01.Luas());
        String K = String.format("%8.2f", obj01.Keliling());
        System.out.println("Luasnya: " + L);
        System.out.println("Kelilingnya: " + K);
    }
}
public class Main {
    public static void main(String[] args) {
        Kalkulator kalkulator = new Kalkulator();
        System.out.println(kalkulator.tambah(5, 10));
        System.out.println(kalkulator.tambah(5.5, 10.2));
        System.out.println(kalkulator.tambah(5, 10, 15));
        Hewan a = new Kucing();
        Hewan b = new Anjing();
        Hewan c = new Kuda();
        Hewan d = new Serigala();
        a.suara();
        b.suara();
        c.suara();
        d.suara();
    }
}

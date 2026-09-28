public class Bebek implements Terbang, Berenang {

    @Override
    public void bunyiTerbang() {
        System.out.println("Klepak klepak");
    }

    @Override
    public void bunyiMendarat() {
        System.out.println("Gedebug");
    }

    @Override
    public void suaraBerenang() {
        System.out.println("Gejebur");
    }

    @Override
    public void suaraMenyelam() {
        System.out.println("Blebek blebek");
    }
}
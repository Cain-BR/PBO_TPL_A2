public class Main {
    public static void main(String[] args) {
        Mahasiswa m1 = new Mahasiswa("Yusuf", "J04096");
        Mahasiswa m2 = new Mahasiswa("Adrian", "J04044");
        Mahasiswa m3 = new Mahasiswa("Ibrahim", "J04107");

        Matakuliah mk1 = new Matakuliah("PBO", "TPL001");
        Matakuliah mk2 = new Matakuliah("Basis Data", "TPL002");
        Matakuliah mk3 = new Matakuliah("RKPL", "TPL003");

        m1.tambahMatkul(mk1);
        m1.tambahMatkul(mk2);
        m1.tambahMatkul(mk3);
        m1.tampilkanMK();
        System.out.println();
        mk1.tampilkanPeserta();
        mk1.tambahMahasiswa(m2);
        System.out.println();
        mk1.tampilkanPeserta();
    }
}
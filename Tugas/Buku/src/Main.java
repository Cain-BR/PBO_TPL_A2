public class Main {
    public static void main(String[] args) {
        Perpustakaan perpus = new Perpustakaan("Perpustakaan");

        // Buat genre
        GenreBuku fiksi = new GenreBuku("G1", "Fiksi");
        GenreBuku teknologi = new GenreBuku("G2", "Teknologi");
        perpus.tambahGenre(fiksi);
        perpus.tambahGenre(teknologi);

        // Buat buku
        Buku buku1 = new Buku("B1", "Laskar Pelangi", "Andrea Hirata", fiksi);
        Buku buku2 = new Buku("B2", "Clean Code", "Robert C. Martin", teknologi);
        Buku buku3 = new Buku("B3", "Bumi Manusia", "Pramoedya A. Toer", fiksi);
        perpus.tambahBuku(buku1);
        perpus.tambahBuku(buku2);
        perpus.tambahBuku(buku3);

        // Buat member
        Member ghazy = new Member("M1", "Ghazy");
        Member syafiq = new Member("M2", "Syafiq");
        perpus.tambahMember(ghazy);
        perpus.tambahMember(syafiq);

        System.out.println();
        perpus.tampilkanSemuaBuku();

        System.out.println();
        ghazy.pinjamBuku(buku1);
        syafiq.pinjamBuku(buku2);
        syafiq.pinjamBuku(buku1); // akan gagal, sudah dipinjam Ghazy

        System.out.println();
        perpus.tampilkanSemuaBuku();

        System.out.println();
        ghazy.tampilkanBukuDipinjam();
        syafiq.tampilkanBukuDipinjam();

        System.out.println();
        ghazy.kembalikanBuku(buku1);
        syafiq.pinjamBuku(buku1); // sekarang berhasil

        System.out.println();
        perpus.tampilkanBukuByGenre(fiksi);
    }
}
public class Main {
    public static void main(String[] args) {
        Perpustakaan perpus = new Perpustakaan("Perpustakaan IPB Vokasi");

        // Buat genre
        GenreBuku fiksi = new GenreBuku("G1", "Fiksi");
        GenreBuku teknologi = new GenreBuku("G2", "Teknologi");
        perpus.tambahGenre(fiksi);
        perpus.tambahGenre(teknologi);

        // Buat buku
        Buku buku1 = new Buku("B1", "Laskar Pelangi", "Andrea Hirata", fiksi);
        Buku buku2 = new Buku("B2", "Clean Code", "Robert C. Martin", teknologi);
        Buku buku3 = new Buku("B3", "Bumi Manusia", "Pramoedya A. Toer", fiksi);
        Buku buku4 = new Buku("B4", "Effective Java", "Joshua Bloch", teknologi);
        perpus.tambahBuku(buku1);
        perpus.tambahBuku(buku2);
        perpus.tambahBuku(buku3);
        perpus.tambahBuku(buku4);

        // Buat member: Member bersifat abstract, jadi yang dibuat instance-nya
        // adalah subclass-nya (Mahasiswa / Dosen) -> ini contoh polymorphism
        Member orang1 = new Mahasiswa("M1", "Orang1", "J0304xxxxx");
        Member orang2 = new Dosen("M2", "Orang2", "1980xxxxxx");
        perpus.tambahMember(orang1);
        perpus.tambahMember(orang2);

        System.out.println();
        perpus.tampilkanSemuaBuku();

        // Mahasiswa coba pinjam 4 buku, padahal batasnya 3
        System.out.println();
        seiya.pinjamBuku(buku1);
        seiya.pinjamBuku(buku2);
        seiya.pinjamBuku(buku3);
        seiya.pinjamBuku(buku4); // ditolak, sudah 3 buku (batas mahasiswa)

        // Dosen batasnya lebih longgar
        System.out.println();
        pakBudi.pinjamBuku(buku4);

        System.out.println();
        seiya.tampilkanBukuDipinjam();
        pakBudi.tampilkanBukuDipinjam();
    }
}
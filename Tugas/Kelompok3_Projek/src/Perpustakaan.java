import java.util.ArrayList;
import java.util.List;

public class Perpustakaan {
    private String namaPerpustakaan;
    private List<Member> daftarMember;
    private List<Buku> daftarBuku;
    private List<GenreBuku> daftarGenre;

    public Perpustakaan(String namaPerpustakaan) {
        this.namaPerpustakaan = namaPerpustakaan;
        this.daftarMember = new ArrayList<>();
        this.daftarBuku = new ArrayList<>();
        this.daftarGenre = new ArrayList<>();
    }

    public void tambahMember(Member member) {
        daftarMember.add(member);
    }

    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
    }

    public void tambahGenre(GenreBuku genre) {
        daftarGenre.add(genre);
    }

    public void tampilkanSemuaBuku() {
        System.out.println("=== Katalog Buku di " + namaPerpustakaan + " ===");
        for (Buku b : daftarBuku) {
            b.tampilkanInfo();
        }
    }

    public void tampilkanBukuByGenre(GenreBuku genre) {
        System.out.println("=== Buku dengan genre: " + genre.getNamaGenre() + " ===");
        for (Buku b : daftarBuku) {
            if (b.getGenre() == genre) {
                b.tampilkanInfo();
            }
        }
    }
}
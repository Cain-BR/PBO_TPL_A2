public class Buku {
    private String idBuku;
    private String judul;
    private String penulis;
    private GenreBuku genre;
    private boolean sedangDipinjam;
    private Member peminjam; // referensi ke Member yang sedang pinjam (bisa null)

    public Buku(String idBuku, String judul, String penulis, GenreBuku genre) {
        this.idBuku = idBuku;
        this.judul = judul;
        this.penulis = penulis;
        this.genre = genre;
        this.sedangDipinjam = false;
        this.peminjam = null;
    }

    public String getIdBuku() {
        return idBuku;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public GenreBuku getGenre() {
        return genre;
    }

    public boolean isSedangDipinjam() {
        return sedangDipinjam;
    }

    public void setSedangDipinjam(boolean sedangDipinjam) {
        this.sedangDipinjam = sedangDipinjam;
    }

    public Member getPeminjam() {
        return peminjam;
    }

    public void setPeminjam(Member peminjam) {
        this.peminjam = peminjam;
    }

    public void tampilkanInfo() {
        String status = sedangDipinjam
                ? "Dipinjam oleh " + peminjam.getNama()
                : "Tersedia";
        System.out.println("[" + idBuku + "] " + judul + " - " + penulis
                + " | Genre: " + genre + " | Status: " + status);
    }

    @Override
    public String toString() {
        return judul;
    }
}
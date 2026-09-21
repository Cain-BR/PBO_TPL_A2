import java.util.ArrayList;
import java.util.List;

public abstract class Member implements Peminjam {
    private final String idMember;
    private final String nama;
    private final List<Buku> daftarBukuDipinjam;

    public Member(String idMember, String nama) {
        this.idMember = idMember;
        this.nama = nama;
        this.daftarBukuDipinjam = new ArrayList<>();
    }

    // method abstrak: setiap turunan Member wajib menentukan batas pinjamnya sendiri
    public abstract int getMaksPinjam();

    public String getIdMember() {
        return idMember;
    }

    public String getNama() {
        return nama;
    }

    public List<Buku> getDaftarBukuDipinjam() {
        return daftarBukuDipinjam;
    }

    @Override
    public void pinjamBuku(Buku buku) {
        if (buku.isSedangDipinjam()) {
            System.out.println("Gagal: buku \"" + buku.getJudul() + "\" sedang dipinjam oleh "
                    + buku.getPeminjam().getNama());
            return;
        }
        if (daftarBukuDipinjam.size() >= getMaksPinjam()) {
            System.out.println("Gagal: " + nama + " sudah mencapai batas maksimal "
                    + getMaksPinjam() + " buku");
            return;
        }
        buku.setSedangDipinjam(true);
        buku.setPeminjam(this);
        daftarBukuDipinjam.add(buku);
        System.out.println(nama + " berhasil meminjam \"" + buku.getJudul() + "\"");
    }

    @Override
    public void kembalikanBuku(Buku buku) {
        if (!daftarBukuDipinjam.contains(buku)) {
            System.out.println(nama + " tidak sedang meminjam \"" + buku.getJudul() + "\"");
            return;
        }
        buku.setSedangDipinjam(false);
        buku.setPeminjam(null);
        daftarBukuDipinjam.remove(buku);
        System.out.println(nama + " mengembalikan \"" + buku.getJudul() + "\"");
    }

    public void tampilkanBukuDipinjam() {
        System.out.println("Buku yang dipinjam oleh " + nama + " (maks " + getMaksPinjam() + "):");
        if (daftarBukuDipinjam.isEmpty()) {
            System.out.println("  (tidak ada)");
        } else {
            for (Buku b : daftarBukuDipinjam) {
                System.out.println("  - " + b.getJudul());
            }
        }
    }
}
public class Mahasiswa extends Member {
    private String nim;

    public Mahasiswa(String idMember, String nama, String nim) {
        super(idMember, nama);
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }

    @Override
    public int getMaksPinjam() {
        return 3; // mahasiswa maksimal pinjam 3 buku
    }
}
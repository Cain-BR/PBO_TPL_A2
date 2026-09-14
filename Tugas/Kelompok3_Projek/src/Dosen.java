public class Dosen extends Member {
    private String nip;

    public Dosen(String idMember, String nama, String nip) {
        super(idMember, nama);
        this.nip = nip;
    }

    public String getNip() {
        return nip;
    }

    @Override
    public int getMaksPinjam() {
        return 10; // dosen maksimal pinjam 10 buku
    }
}
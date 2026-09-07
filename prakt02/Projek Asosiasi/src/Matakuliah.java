Import java.util.ArrayList;
Import java.util.List;
public class Matakuliah {
    private String namaMatkul;
    private String kode;
    private List<Mahasiswa> daftarMahasiswa;

    public Matakuliah(String nm, String ko) {
        this.namaMatkul = nm;
        this.kode = ko;
        this.daftarMahasiswa = new ArrayList<>();
    }

    public String getNamaMatkul() {
        return namaMatkul;
    }

    public String getKode() {
        return kode;
    }

    public List<Mahasiswa> getDaftarMahasiswa() {
        return daftarMahasiswa;
    }

    public void tambahMahasiswa(Mahasiswa mhs) {
        if(!daftarMahasiswa.contains(mhs)) {
            daftarMahasiswa.add(mhs);
            mhs.tambahMatkul(this);
        }
    }

    public void tampilkanPeserta(){
        int i=1;
        System.out.println("Daftar Peserta Matakuliah " + namaMatkul + ":");
        for (Mahasiswa mhs : daftarMahasiswa) {
            System.out.println(i + ". " + mhs.getNama() + " (" + mhs.getNim() + ")");
            i = i + 1;
        }
    }
}
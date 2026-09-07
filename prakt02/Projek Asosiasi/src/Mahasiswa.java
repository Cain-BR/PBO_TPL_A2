Import java.util.ArrayList;
Import java.util.List;
public class Mahasiswa {
    private String nama;
    private String nim;
    private List<Matakuliah> daftarMatakuliah;

    public Mahasiswa(String na, String ni) {
        this.nama = na;
        this.nim = ni;
        this.daftarMatakuliah = new ArrayList<>();
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public void tambahMatkul(Matakuliah mk){
        if(!daftarMatakuliah.contains(mk)) {
            daftarMatakuliah.add(mk);
            mk.tambahMahasiswa(this);
        }
    }

    public void tampilkanMK(){
        int i=1;
        System.out.println("Daftar Matakuliah " + nama + ":");
        for (Matakuliah mk : daftarMatakuliah) {
            System.out.println(i + ". " + mk.getKode() + " " + mk.getNamaMatkul());
            i = i + 1;
        }
    }
}
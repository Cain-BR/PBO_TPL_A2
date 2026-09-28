import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RuangBankKomunitas implements Pengingat, Keamanan {
    private String namaKomunitas;
    private String passwordKomunitas;
    private boolean terbuka = false;
    private List<Transaksi> daftarTransaksi = new ArrayList<>();
    private LocalDate jatuhTempoUtang;
    private String pesanUtang;
 
    public RuangBankKomunitas(String namaKomunitas, String passwordKomunitas) {
        this.namaKomunitas = namaKomunitas;
        this.passwordKomunitas = passwordKomunitas;
    }
 
    public void tambahTransaksi(Transaksi t) {
        if (!terbuka) {
            System.out.println("Akses ditolak: masuk ke ruang \"" + namaKomunitas + "\" dulu.");
            return;
        }
        daftarTransaksi.add(t);
    }
 
    public double hitungSaldo() {
        double saldo = 0;
        for (Transaksi t : daftarTransaksi) {
            saldo += t.hitungNominalBersih();
        }
        return saldo;
    }
 
    @Override
    public void jadwalkanPengingat(LocalDate tanggal, String pesan) {
        this.jatuhTempoUtang = tanggal;
        this.pesanUtang = pesan;
        System.out.println("Pengingat utang komunitas dijadwalkan: " + tanggal);
    }
 
    @Override
    public void kirimNotifikasi() {
        System.out.println("NOTIFIKASI [" + namaKomunitas + "]: " + pesanUtang
                + " (deadline " + jatuhTempoUtang + ")");
    }
 
    @Override
    public boolean login(String password) {
        terbuka = passwordKomunitas.equals(password);
        System.out.println(terbuka
                ? "Berhasil masuk ke ruang \"" + namaKomunitas + "\"."
                : "Password komunitas salah.");
        return terbuka;
    }
 
    @Override
    public void logout() {
        terbuka = false;
        System.out.println("Keluar dari ruang \"" + namaKomunitas + "\".");
    }
}

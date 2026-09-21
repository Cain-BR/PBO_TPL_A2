import java.util.ArrayList;
import java.util.List;

public class User extends Entitas implements Autentikasi {
    private final String namaKtp;
    private final String password; // di aplikasi nyata simpan hash (mis. BCrypt), bukan teks asli
    private final List<Komunitas> daftarKomunitas = new ArrayList<>();

    private User(String namaKtp, String password) {
        super("USR");
        this.namaKtp = namaKtp;
        this.password = password;
    }

    public static User register(String namaKtp, String password) {
        if (namaKtp == null || namaKtp.isBlank()) {
            throw new IllegalArgumentException("Nama sesuai KTP wajib diisi");
        }
        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("Password minimal 6 karakter");
        }
        return new User(namaKtp, password);
    }

    @Override
    public boolean login(String password) {
        return this.password.equals(password);
    }

    public Komunitas mendirikanKomunitas(String nama, String suratIzin, String passAksesKom) {
        Komunitas komunitas = new Komunitas(nama, suratIzin, passAksesKom);
        komunitas.tambahAnggota(getId());
        komunitas.buatBankKomunitas();
        daftarKomunitas.add(komunitas);
        return komunitas;
    }

    public boolean bergabungKomunitas(String idKom, String passAksesKom) {
        Komunitas komunitas = Komunitas.cari(idKom);
        if (komunitas == null || !komunitas.verifikasiAksesKomunitas(passAksesKom)) {
            return false;
        }
        if (!komunitas.tambahAnggota(getId())) {
            return false;
        }
        daftarKomunitas.add(komunitas);
        return true;
    }

    public Transaksi lakukanTransaksi(Komunitas komunitas, double nominal, String buktiBelanja) {
        if (!komunitas.adalahAnggota(getId())) {
            throw new IllegalStateException("Anda bukan anggota komunitas ini");
        }
        Transaksi transaksi = new Transaksi(getId(), nominal, buktiBelanja);
        if (!komunitas.getBankKomunitas().mencatatTransaksi(transaksi)) {
            throw new IllegalStateException("Transaksi ditolak: bukti tidak valid atau saldo tidak cukup");
        }
        return transaksi;
    }

    public Laporan buatLaporan(String idTransaksi, String alasanReport) {
        return Laporan.ajukanLaporan(idTransaksi, alasanReport);
    }

    @Override
    public String getRingkasan() {
        return String.format("User[%s] %s, %d komunitas", getId(), namaKtp, daftarKomunitas.size());
    }
}
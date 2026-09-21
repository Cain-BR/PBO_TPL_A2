import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Komunitas extends Entitas implements AksesTerproteksi {
    // Pengganti database sederhana agar komunitas bisa dicari lewat id.
    private static final Map<String, Komunitas> REGISTRI = new HashMap<>();

    private final String namaKomunitas;
    private final String suratIzin;
    private final String passAksesKom;
    private final Set<String> anggota = new LinkedHashSet<>();
    private BankKomunitas bankKomunitas;

    // Package-private: komunitas hanya dibuat lewat User.mendirikanKomunitas()
    Komunitas(String namaKomunitas, String suratIzin, String passAksesKom) {
        super("KOM");
        this.namaKomunitas = namaKomunitas;
        this.suratIzin = suratIzin;
        this.passAksesKom = passAksesKom;
    }

    public static Komunitas buatBaru(String namaKomunitas, String suratIzin, String passAksesKom) {
        Komunitas komunitas = new Komunitas(namaKomunitas, suratIzin, passAksesKom);
        REGISTRI.put(komunitas.getId(), komunitas);
        return komunitas;
    }

    public static Komunitas cari(String idKom) {
        return REGISTRI.get(idKom);
    }

    @Override
    public boolean verifikasiAksesKomunitas(String passAksesKom) {
        return this.passAksesKom.equals(passAksesKom);
    }

    public boolean tambahAnggota(String idUser) {
        return anggota.add(idUser); // false jika sudah menjadi anggota
    }

    public boolean adalahAnggota(String idUser) {
        return anggota.contains(idUser);
    }

    /** Membuat bank komunitas (satu komunitas hanya punya satu bank). */
    public BankKomunitas buatBankKomunitas() {
        if (bankKomunitas == null) {
            bankKomunitas = new BankKomunitas();
        }
        return bankKomunitas;
    }

    public BankKomunitas getBankKomunitas() {
        return bankKomunitas;
    }

    public String getNamaKomunitas() {
        return namaKomunitas;
    }

    @Override
    public String getRingkasan() {
        return String.format("Komunitas[%s] %s (izin: %s), %d anggota", getId(), namaKomunitas, suratIzin, anggota.size());
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BankKomunitas extends Bank {
    private final List<GroupingDana> daftarGrouping = new ArrayList<>();
    private final List<Transaksi> riwayatTransaksi = new ArrayList<>();

    BankKomunitas() {
        super("BNK");
    }

    /** Saldo yang belum dialokasikan ke grouping mana pun. */
    public double saldoTersedia() {
        double teralokasi = daftarGrouping.stream().mapToDouble(GroupingDana::getJumlahDana).sum();
        return cekSaldo() - teralokasi;
    }

    public GroupingDana buatGroupingDana(String namaAlokasi, double jumlahDana) {
        if (jumlahDana < 0 || jumlahDana > saldoTersedia()) {
            throw new IllegalArgumentException("Saldo tersedia tidak cukup untuk alokasi ini");
        }
        GroupingDana grouping = new GroupingDana(namaAlokasi, jumlahDana);
        daftarGrouping.add(grouping);
        return grouping;
    }

    public Optional<GroupingDana> cariGrouping(String idGrouping) {
        return daftarGrouping.stream().filter(g -> g.getId().equals(idGrouping)).findFirst();
    }

    /** Memindahkan dana dari satu grouping ke grouping lain. */
    public boolean realokasikan(String idAsal, String idTujuan, double jumlah) {
        Optional<GroupingDana> asal = cariGrouping(idAsal);
        Optional<GroupingDana> tujuan = cariGrouping(idTujuan);
        if (asal.isEmpty() || tujuan.isEmpty()) {
            return false;
        }
        return asal.get().realokasikanDana(idTujuan, jumlah) && tujuan.get().alokasikanDana(jumlah);
    }

    @Override
    public boolean mencatatTransaksi(Transaksi transaksi) {
        if (!transaksi.validasiBuktiBelanja()) {
            return false;
        }
        if (!updateSaldo(-transaksi.getNominal())) { // transaksi belanja = saldo berkurang
            return false;
        }
        riwayatTransaksi.add(transaksi);
        return true;
    }

    public List<Transaksi> getRiwayatTransaksi() {
        return List.copyOf(riwayatTransaksi);
    }

    @Override
    public String getRingkasan() {
        return String.format("BankKomunitas[%s] saldo Rp%,.0f (tersedia Rp%,.0f), %d grouping, %d transaksi",
                getId(), cekSaldo(), saldoTersedia(), daftarGrouping.size(), riwayatTransaksi.size());
    }
}
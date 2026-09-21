public class GroupingDana extends Entitas implements AlokasiDana {
    private final String namaAlokasi;
    private double jumlahDana;

    GroupingDana(String namaAlokasi, double jumlahDana) {
        super("GRP");
        this.namaAlokasi = namaAlokasi;
        this.jumlahDana = jumlahDana;
    }

    public String getNamaAlokasi() {
        return namaAlokasi;
    }

    public double getJumlahDana() {
        return jumlahDana;
    }

    @Override
    public boolean alokasikanDana(double jumlah) {
        if (jumlah <= 0) {
            return false;
        }
        jumlahDana += jumlah;
        return true;
    }

    /**
     * Mengurangi dana pada grouping ini. Penambahan ke grouping tujuan
     * diselesaikan oleh BankKomunitas.realokasikan(...).
     */
    @Override
    public boolean realokasikanDana(String idGroupingTujuan, double jumlah) {
        if (jumlah <= 0 || jumlah > jumlahDana || getId().equals(idGroupingTujuan)) {
            return false;
        }
        jumlahDana -= jumlah;
        return true;
    }

    @Override
    public String getRingkasan() {
        return String.format("GroupingDana[%s] %s = Rp%,.0f", getId(), namaAlokasi, jumlahDana);
    }
}
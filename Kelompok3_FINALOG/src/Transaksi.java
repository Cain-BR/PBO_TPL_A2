public class Transaksi extends Entitas implements Tervalidasi {
    private final String idUser;
    private final double nominal;
    private final String buktiBelanja;

    Transaksi(String idUser, double nominal, String buktiBelanja) {
        super("TRX");
        this.idUser = idUser;
        this.nominal = nominal;
        this.buktiBelanja = buktiBelanja;
    }

    public String getIdUser() {
        return idUser;
    }

    public double getNominal() {
        return nominal;
    }

    @Override
    public boolean validasiBuktiBelanja() {
        return nominal > 0 && buktiBelanja != null && !buktiBelanja.isBlank();
    }

    public Transaksi getDetailTransaksi() {
        return this;
    }

    @Override
    public String getRingkasan() {
        return String.format("Transaksi[%s] oleh %s, Rp%,.0f, bukti: %s", getId(), idUser, nominal, buktiBelanja);
    }
}
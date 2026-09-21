/** INTERFACE: kontrak pengelolaan saldo dan pencatatan transaksi. */
public interface PengelolaSaldo {
    double cekSaldo();

    /** nominal positif = tambah saldo, negatif = kurangi saldo. */
    boolean updateSaldo(double nominal);

    boolean mencatatTransaksi(Transaksi transaksi);
}
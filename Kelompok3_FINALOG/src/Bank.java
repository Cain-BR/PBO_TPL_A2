/**
 * ABSTRACT CLASS yang mengimplementasikan interface PengelolaSaldo secara parsial:
 * logika saldo (cekSaldo, updateSaldo) sudah jadi, sedangkan mencatatTransaksi()
 * sengaja dibiarkan abstrak agar tiap jenis bank menentukan aturannya sendiri.
 */
public abstract class Bank extends Entitas implements PengelolaSaldo {
    private double totalSaldo;

    protected Bank(String prefix) {
        super(prefix);
    }

    @Override
    public double cekSaldo() {
        return totalSaldo;
    }

    @Override
    public boolean updateSaldo(double nominal) {
        if (totalSaldo + nominal < 0) {
            return false; // saldo tidak boleh negatif
        }
        totalSaldo += nominal;
        return true;
    }

    @Override
    public abstract boolean mencatatTransaksi(Transaksi transaksi);
}
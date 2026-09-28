import java.time.LocalDate;

public class Pengeluaran extends Transaksi {
    
    private String buktiBelanja;
 
    public Pengeluaran(String id, double nominal, LocalDate tgl, String ket, String buktiBelanja) {
        super(id, nominal, tgl, ket);
        this.buktiBelanja = buktiBelanja;
    }
 
    @Override
    public double hitungNominalBersih() {
        return -nominal;
    }
 
    @Override
    public String getKategori() {
        return "PENGELUARAN";
    }
 
    public boolean adaBuktiBelanja() {
        return buktiBelanja != null && !buktiBelanja.isEmpty();
    }
 
    public void laporkanJikaTidakTransparan() {
        if (!adaBuktiBelanja()) {
            System.out.println("  -> LAPORAN: pengeluaran " + idTransaksi
                    + " tidak memiliki bukti belanja, diajukan ke pemilik bank komunitas.");
        } else {
            System.out.println("  -> Pengeluaran " + idTransaksi + " transparan (bukti: " + buktiBelanja + ").");
        }
    }
}

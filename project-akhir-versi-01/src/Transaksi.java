import java.time.LocalDate;

public abstract class Transaksi {
    
    protected String idTransaksi;
    protected double nominal;
    protected LocalDate tanggal;
    protected String keterangan;
 
    public Transaksi(String idTransaksi, double nominal, LocalDate tanggal, String keterangan) {
        this.idTransaksi = idTransaksi;
        this.nominal = nominal;
        this.tanggal = tanggal;
        this.keterangan = keterangan;
    }
 
    public abstract double hitungNominalBersih();
    public abstract String getKategori();
 
    public void tampilkanRingkasan() {
        System.out.println("[" + getKategori() + "] " + idTransaksi
                + " | " + tanggal
                + " | " + keterangan
                + " | Nominal: Rp" + nominal
                + " | Bersih: Rp" + hitungNominalBersih());
    }
}

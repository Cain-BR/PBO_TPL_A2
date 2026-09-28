import java.time.LocalDate;

public class Pemasukan extends Transaksi {
    
    private double biayaAdmin;
 
    public Pemasukan(String id, double nominal, LocalDate tgl, String ket, double biayaAdmin) {
        super(id, nominal, tgl, ket);
        this.biayaAdmin = biayaAdmin;
    }
 
    @Override
    public double hitungNominalBersih() {
        return nominal - biayaAdmin;
    }
 
    @Override
    public String getKategori() {
        return "PEMASUKAN";
    }
 
    public void alokasikanKeDana(String namaDana, double persen) {
        double jumlah = hitungNominalBersih() * persen / 100;
        System.out.println("  -> Dialokasikan Rp" + jumlah + " (" + persen + "%) ke dana \"" + namaDana + "\"");
    }
}

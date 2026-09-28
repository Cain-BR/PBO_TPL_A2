import java.time.LocalDate;

public class PengingatKas implements Pengingat{
    private LocalDate tanggalJatuhTempo;
    private String pesan;
 
    @Override
    public void jadwalkanPengingat(LocalDate tanggal, String pesan) {
        this.tanggalJatuhTempo = tanggal;
        this.pesan = pesan;
        System.out.println("Pengingat kas dijadwalkan pada " + tanggal);
    }
 
    @Override
    public void kirimNotifikasi() {
        System.out.println("NOTIFIKASI: " + pesan + " (jatuh tempo " + tanggalJatuhTempo + ")");
    }
}

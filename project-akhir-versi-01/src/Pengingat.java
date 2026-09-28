import java.time.LocalDate;

public interface Pengingat {
    void jadwalkanPengingat(LocalDate tanggal, String pesan);
    void kirimNotifikasi();
}

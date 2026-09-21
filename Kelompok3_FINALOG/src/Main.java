import java.util.List;

public class Main {
    public static void main(String[] args) {
        User budi = User.register("Budi Santoso", "rahasia123");
        User sari = User.register("Sari Wulandari", "sandi4567");

        System.out.println("Login Budi (benar)  : " + budi.login("rahasia123"));
        System.out.println("Login Sari (salah)  : " + sari.login("salah"));

        // Budi mendirikan komunitas (bank komunitas otomatis dibuat)
        Komunitas kom = budi.mendirikanKomunitas("Komunitas Bazar Kampus", "SIU-2026/001", "kom-pass");
        BankKomunitas bank = kom.getBankKomunitas();

        System.out.println("Sari gabung (salah) : " + sari.bergabungKomunitas(kom.getId(), "salah"));
        System.out.println("Sari gabung (benar) : " + sari.bergabungKomunitas(kom.getId(), "kom-pass"));

        // Isi saldo & buat grouping dana
        bank.updateSaldo(5_000_000);
        GroupingDana konsumsi = bank.buatGroupingDana("Konsumsi", 2_000_000);
        GroupingDana dekorasi = bank.buatGroupingDana("Dekorasi", 1_000_000);

        // Sari melakukan transaksi belanja
        Transaksi trx = sari.lakukanTransaksi(kom, 350_000, "nota-konsumsi-001.jpg");

        // Transaksi tanpa bukti ditolak
        try {
            sari.lakukanTransaksi(kom, 100_000, "");
        } catch (IllegalStateException e) {
            System.out.println("Ditolak             : " + e.getMessage());
        }

        // Budi melaporkan transaksi Sari
        Laporan laporan = budi.buatLaporan(trx.getId(), "Nominal pada nota tidak sesuai");
        laporan.perbaruiStatus(StatusLaporan.DITINJAU);
        System.out.println("Status laporan      : " + laporan.getStatusLaporan());

        // Realokasi dana Konsumsi -> Dekorasi
        System.out.println("Realokasi berhasil  : " + bank.realokasikan(konsumsi.getId(), dekorasi.getId(), 500_000));

        // POLIMORFISME lewat abstract class Entitas
        System.out.println("\n--- Ringkasan (polimorfisme via Entitas) ---");
        List<Entitas> semua = List.of(budi, sari, kom, bank, konsumsi, dekorasi, trx, laporan);
        for (Entitas e : semua) {
            System.out.println(e.getRingkasan());
        }

        // POLIMORFISME lewat interface
        System.out.println("\n--- Lewat interface ---");
        PengelolaSaldo pengelola = bank;
        AlokasiDana alokasi = konsumsi;
        System.out.printf("PengelolaSaldo.cekSaldo()      : Rp%,.0f%n", pengelola.cekSaldo());
        System.out.println("AlokasiDana.alokasikanDana(-1) : " + alokasi.alokasikanDana(-1));
    }
}
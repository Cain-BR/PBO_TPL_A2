import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Abstract Class ===");
        Pemasukan iuran = new Pemasukan("TRX-001", 500000, LocalDate.now(), "Iuran kas panitia", 2500);
        Pengeluaran belanja = new Pengeluaran("TRX-002", 150000, LocalDate.now(), "Beli konsumsi", "nota-0912.jpg");
        Pengeluaran tanpaBukti = new Pengeluaran("TRX-003", 80000, LocalDate.now(), "Sewa alat", null);
 
        iuran.tampilkanRingkasan();
        iuran.alokasikanKeDana("Dana Darurat", 20);
        belanja.tampilkanRingkasan();
        belanja.laporkanJikaTidakTransparan();
        tanpaBukti.tampilkanRingkasan();
        tanpaBukti.laporkanJikaTidakTransparan();
 
        System.out.println("\n=== Interface 1 saja (Pengingat) ===");
        PengingatKas pk = new PengingatKas();
        pk.jadwalkanPengingat(LocalDate.now().plusDays(7), "Saatnya bayar kas bulanan");
        pk.kirimNotifikasi();
 
        System.out.println("\n=== Interface 2 saja (Keamanan) ===");
        AkunPengguna akun = new AkunPengguna("Seiya", "3201xxxxxxxxxxxx", "FNL-0001", "rahasia123");
        akun.login("salah");
        akun.login("rahasia123");
        akun.logout();
 
        System.out.println("\n=== Kedua Interface sekaligus ===");
        RuangBankKomunitas ruang = new RuangBankKomunitas("Panitia Festival", "komunitas456");
        ruang.tambahTransaksi(iuran); // ditolak, belum login
        ruang.login("komunitas456");
        ruang.tambahTransaksi(iuran);
        ruang.tambahTransaksi(belanja);
        ruang.tambahTransaksi(tanpaBukti);
        System.out.println("Saldo komunitas: Rp" + ruang.hitungSaldo());
        ruang.jadwalkanPengingat(LocalDate.now().plusDays(3), "Utang ke vendor belum lunas");
        ruang.kirimNotifikasi();
        ruang.logout();
    }
}

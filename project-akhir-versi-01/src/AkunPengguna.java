public class AkunPengguna implements Keamanan {
    private final String namaKtp;
    private final String noKtp;
    private final String noRekening;
    private final String password;
    private boolean sedangLogin = false;
 
    public AkunPengguna(String namaKtp, String noKtp, String noRekening, String password) {
        this.namaKtp = namaKtp;
        this.noKtp = noKtp;
        this.noRekening = noRekening;
        this.password = password;
    }
 
    @Override
    public boolean login(String passwordInput) {
        sedangLogin = this.password.equals(passwordInput);
        System.out.println(sedangLogin
                ? "Login berhasil. Selamat datang, " + namaKtp + " (KTP: " + noKtp + ", Rek: " + noRekening + ")"
                : "Login gagal: password salah.");
        return sedangLogin;
    }
 
    @Override
    public void logout() {
        sedangLogin = false;
        System.out.println(namaKtp + " telah logout.");
    }
}

public class Person {
    private String nama;
    private String alamat;
    private String email;

    public Person(String nama, String email, String alamat) {
        this.nama = nama;
        this.email = email;
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setNama(String nama) {
        if (nama != null && !nama.trim().isEmpty()) {
            this.nama = nama;
        } else {
            System.out.println("Nama tidak boleh kosong.");
        }
    }

    public void setEmail(String email) {
        if (email != null && !email.trim().isEmpty()) {
            this.email = email;
        } else {
            System.out.println("Email tidak boleh kosong.");
        }
    }
}
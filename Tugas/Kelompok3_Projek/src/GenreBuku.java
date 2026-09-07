public class GenreBuku {
    private String idGenre;
    private String namaGenre;

    public GenreBuku(String idGenre, String namaGenre) {
        this.idGenre = idGenre;
        this.namaGenre = namaGenre;
    }

    public String getIdGenre() {
        return idGenre;
    }

    public String getNamaGenre() {
        return namaGenre;
    }

    @Override
    public String toString() {
        return namaGenre;
    }
}
/** INTERFACE: kontrak untuk pos dana yang bisa dialokasikan/direalokasikan. */
public interface AlokasiDana {
    boolean alokasikanDana(double jumlahDana);

    boolean realokasikanDana(String idGroupingTujuan, double jumlahDana);
}
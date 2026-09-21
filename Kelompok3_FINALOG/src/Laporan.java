public class Laporan extends Entitas {
    private final String idTransaksi;
    private final String alasanReport;
    private StatusLaporan status = StatusLaporan.DIAJUKAN;

    private Laporan(String idTransaksi, String alasanReport) {
        super("LAP");
        this.idTransaksi = idTransaksi;
        this.alasanReport = alasanReport;
    }

    public static Laporan ajukanLaporan(String idTransaksi, String alasanReport) {
        if (alasanReport == null || alasanReport.isBlank()) {
            throw new IllegalArgumentException("Alasan laporan wajib diisi");
        }
        return new Laporan(idTransaksi, alasanReport);
    }

    public void perbaruiStatus(StatusLaporan statusBaru) {
        this.status = statusBaru;
    }

    public String getStatusLaporan() {
        return status.name();
    }

    @Override
    public String getRingkasan() {
        return String.format("Laporan[%s] untuk %s: \"%s\" (%s)", getId(), idTransaksi, alasanReport, status);
    }
}
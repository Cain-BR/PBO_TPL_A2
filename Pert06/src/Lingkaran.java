public class Lingkaran extends BidangDatar {
    private double jariJari;

    public Lingkaran(double jariJari) {
        this.jariJari = jariJari;
    }

    @Override
    public double hitungLuas() {
        return 3.14 * jariJari * jariJari;
    }
}

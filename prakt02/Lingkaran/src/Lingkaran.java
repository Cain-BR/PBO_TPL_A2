public class Lingkaran {
    //Daftar atribut
    private double jariJari;

    //Daftar Method
    public Lingkaran(double r) {
        this.jariJari = r;
    }

    public double Luas() {
        return Math.PI * jariJari * jariJari;
    }

    public double Keliling() {
        return 2 * Math.PI * jariJari;
    }
}
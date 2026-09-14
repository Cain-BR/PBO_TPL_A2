public class Main {
    public static void main(String[] args) {
        Mahasiswa mahasiswa1 = new Mahasiswa(
            "231001",
            "Andi Saputra",
            "TPL",
            3,
            3.75);

        System.out.println("NIM :" + mahasiswa1.getNim());
        System.out.println("Nama :" + mahasiswa1.getNama());
        System.out.println("Program Studi :" + mahasiswa1.getProgramStudi());
        System.out.println("Semester :" + mahasiswa1.getSemester());
        System.out.println("IPK :" + mahasiswa1.getIpk());
        System.out.println("Predikat :" + mahasiswa1.cekPredikat());

        mahasiswa1.naikSemester();
        mahasiswa1.setIpk(3.90);

        System.out.println("--- Setelah Update ---");
        System.out.println("Semester :" + mahasiswa1.getSemester());
        System.out.println("IPK :" + mahasiswa1.getIpk());
        System.out.println("Predikat :" + mahasiswa1.cekPredikat());
    }
}
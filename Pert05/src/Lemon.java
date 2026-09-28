public class Lemon implements Nutrition, Flavor {
    @Override
    public void getNutrition() {
        System.out.println("Lemon contains vitamin C");
    }

    @Override
    public void flavor() {
        System.out.println("Lemon has a sour flavor");
    }
}

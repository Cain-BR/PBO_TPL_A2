public class Main {
    public static void main(String[] args) throws Exception {
        Pig myPig = new Pig();
        myPig.animalSound();
        myPig.sleep();
        myPig.ciriKhas();

        Dog myDog = new Dog();
        myDog.animalSound();
        myDog.sleep();
        myDog.ciriKhas();

        Elephant myElephant = new Elephant();
        myElephant.animalSound();
        myElephant.sleep();
        myElephant.ciriKhas();

        Lemon myDish = new Lemon();
        myDish.getNutrition();
        myDish.flavor();
    }
}

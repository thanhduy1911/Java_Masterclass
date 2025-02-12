package section_8.CompositionChallenge;

public class SmartKitchen extends Product {
    private DishWasher dishWasher;
    private Refrigerator refrigerator;
    private CoffeeMaker coffeeMaker;

    public SmartKitchen(String brand, boolean hasWorkToDo) {
        super(brand, hasWorkToDo);
    }
}

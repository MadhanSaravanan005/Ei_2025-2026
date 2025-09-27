package src;

public class MealDirector {
    private final MealBuilder builder;

    public MealDirector(MealBuilder builder) {
        this.builder = builder;
    }

    public Meal constructMeal() {
        builder.buildCrust();
        builder.buildSauce();
        builder.buildToppings();
        return builder.getMeal();
    }
}

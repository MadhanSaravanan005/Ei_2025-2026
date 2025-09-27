package src;

public class VegPizzaBuilder extends MealBuilder {
    @Override
    public void buildCrust() {
        meal.setCrust("Thin Crust");
    }

    @Override
    public void buildSauce() {
        meal.setSauce("Tomato Sauce");
    }

    @Override
    public void buildToppings() {
        meal.addTopping("Olives");
        meal.addTopping("Bell Peppers");
        meal.addTopping("Jalapenos");
    }
}

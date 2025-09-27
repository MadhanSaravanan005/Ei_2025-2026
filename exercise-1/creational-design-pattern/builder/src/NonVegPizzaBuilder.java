package src;

public class NonVegPizzaBuilder extends MealBuilder {
    @Override
    public void buildCrust() {
        meal.setCrust("Cheese-Stuffed Crust");
    }

    @Override
    public void buildSauce() {
        meal.setSauce("Pesto Sauce");
    }

    @Override
    public void buildToppings() {
        meal.addTopping("Pepperoni");
        meal.addTopping("Chicken");
        meal.addTopping("Bacon");
    }
}

package src;

public abstract class MealBuilder {
    protected Meal meal = new Meal();

    public abstract void buildCrust();
    public abstract void buildSauce();
    public abstract void buildToppings();

    public Meal getMeal() {
        return meal;
    }
}

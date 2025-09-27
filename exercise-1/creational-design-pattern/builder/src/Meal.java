package src;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private String crust;
    private String sauce;
    private List<String> toppings = new ArrayList<>();

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public void addTopping(String topping) {
        toppings.add(topping);
    }

    @Override
    public String toString() {
        return "Pizza with " + crust + " crust, " + sauce + " sauce, Toppings: " + toppings;
    }
}

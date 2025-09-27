import src.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to Pizza Builder!");
        System.out.println("Please select the type of pizza you want:");
        System.out.println("1. Vegetarian Pizza");
        System.out.println("2. Non-Vegetarian Pizza");
        System.out.print("Enter your choice (1 or 2): ");
        
        int choice = scanner.nextInt();
        MealDirector director;
        Meal pizza;
        
        switch(choice) {
            case 1:
                director = new MealDirector(new VegPizzaBuilder());
                pizza = director.constructMeal();
                System.out.println("\nYour Vegetarian Pizza: " + pizza);
                break;
            case 2:
                director = new MealDirector(new NonVegPizzaBuilder());
                pizza = director.constructMeal();
                System.out.println("\nYour Non-Vegetarian Pizza: " + pizza);
                break;
            default:
                System.out.println("Invalid choice! Please select 1 or 2.");
                break;
        }
        
        scanner.close();
    }
}

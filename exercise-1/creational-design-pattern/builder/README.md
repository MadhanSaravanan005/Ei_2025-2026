# Builder Pattern Example

## Overview
This project demonstrates the Builder design pattern in Java. The Builder pattern allows you to construct complex objects step by step, providing a clear separation between the construction process and the representation of the object. In this example, a Pizza ordering system is implemented using the Builder pattern to create different types of pizzas.

## Structure
- **Meal**: A class that represents the pizza product with crust, sauce, and toppings.
- **MealBuilder**: An abstract builder class that defines the construction steps.
- **VegPizzaBuilder**: A concrete builder that creates vegetarian pizzas.
- **NonVegPizzaBuilder**: A concrete builder that creates non-vegetarian pizzas.
- **MealDirector**: A director class that orchestrates the construction process.
- **Main**: A client class that demonstrates the use of the Builder pattern with user interaction.

## How to Run
1. Ensure you have Java installed on your machine.
2. Compile the Java files: `javac -d out Main.java src/*.java`
3. Run the Main class: `java -cp out Main`

## Expected Output
```
Welcome to Pizza Builder!
Please select the type of pizza you want:
1. Vegetarian Pizza
2. Non-Vegetarian Pizza
Enter your choice (1 or 2): 1

Your Vegetarian Pizza: Pizza with Thin Crust crust, Tomato Sauce sauce, Toppings: [Olives, Bell Peppers, Jalapeños]
```

# Abstract Factory Pattern Example

## Overview
This project demonstrates the Abstract Factory design pattern in Java. The pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes. In this example, a car assembly system can create either luxury or economy car parts (engine, seat, tire) using different factories.

## Structure
- **CarPartsFactory**: Interface declaring methods to create abstract products (Engine, Seat, Tire)
- **LuxuryCarFactory / EconomyCarFactory**: Concrete factories implementing CarPartsFactory to produce luxury or economy car parts
- **Engine, Seat, Tire**: Abstract product interfaces
- **LuxuryEngine, EconomyEngine, etc.**: Concrete product classes implementing the product interfaces
- **CarAssembler**: Client class that assembles a car using a given factory
- **Main**: Entry point that lets the user choose the type of car to assemble

## How to Run
1. Ensure you have Java (JDK) installed on your machine
2. Compile the code:
   ```bash
   javac -d out -sourcepath src src/parts/*.java src/factory/*.java src/client/*.java src/main/Main.java
   ```
3. Run the program:
   ```bash
   java -cp out main.Main
   ```
4. Follow the on-screen prompt to choose the car type (luxury/economy)

## Example Output
```
Choose car type (luxury/economy):
luxury
Car Assembled with: V8 Engine, Leather Seat, Alloy Wheels
```
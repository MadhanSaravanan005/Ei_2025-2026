# Strategy Pattern Example

## Overview
This project demonstrates the use of the **Strategy Pattern** in Java. The pattern is used to define a family of algorithms (travel strategies), encapsulate each one, and make them interchangeable. This allows the algorithm to vary independently from the clients that use it.

## Structure
- **TravelStrategy**: An interface that all travel strategy types implement.
- **CarStrategy, BusStrategy, WalkingStrategy**: Concrete implementations of the TravelStrategy interface.
- **Traveler**: Context class that uses a TravelStrategy to determine how to travel to work.
- **Main**: The main class that demonstrates the pattern by allowing user to choose different travel strategies.


## How to Run
1. Ensure you have Java installed on your machine.
2. Compile the Java files:
   ```bash
   javac -d out Main.java src/*.java
   ```
3. Run the Main class:
   ```bash
   java -cp out Main
   ```

## Sample Output
When you run the program, you'll be prompted to choose a travel mode:
```
Choose your travel mode: 1. Car  2. Bus  3. Walking
1
Traveling to work by Car.
```

Or:
```
Choose your travel mode: 1. Car  2. Bus  3. Walking
2
Traveling to work by Bus.
```
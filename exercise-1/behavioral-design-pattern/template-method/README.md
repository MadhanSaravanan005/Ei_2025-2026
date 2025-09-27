# Template Pattern Example

## Overview
This project demonstrates the **Template Method design pattern** in Java. The Template Method pattern defines the skeleton of an algorithm in a superclass but lets subclasses override specific steps of the algorithm without changing its structure. In this example, we have a game framework where different sports games follow the same general flow but implement specific behaviors differently.

## Structure

### Files
- **`Game.java`**: Abstract base class that defines the template method for playing games
- **`Cricket.java`**: Concrete implementation of the Game class for cricket
- **`Football.java`**: Concrete implementation of the Game class for football
- **`Main.java`**: Driver class that demonstrates the pattern by allowing user to choose and play different games



## Template Method Pattern Components

### 1. Abstract Class (Game)
- Contains the **template method** `play()` that defines the algorithm skeleton
- Defines abstract methods that must be implemented by concrete classes:
  - `initialize()`: Set up the game
  - `startPlay()`: Begin the game
  - `playTurn()`: Execute a single turn/round
  - `isGameOver()`: Check if game should end
  - `endPlay()`: Clean up and finish the game

### 2. Concrete Classes (Cricket & Football)
- Implement the abstract methods with game-specific logic
- Follow the same algorithm flow but with different implementations

## How to Run

1. **Prerequisites**: Ensure you have Java installed on your machine (Java 8 or higher)

2. **Compile the Java files**:
   ```bash
   javac src/*.java Main.java
   ```

3. **Run the Main class**:
   ```bash
   java Main
   ```

4. **Follow the prompts**: Choose between Football (1) or Cricket (2)

## Sample Output

### Football Game
```
Choose Game to Play:
1. Football
2. Cricket
1
Football Game Initialized. Setting up field and rules.
Kick-off! Football Game Started.
Football Turn: Dribble, pass, shoot, defend.
Football Turn: Dribble, pass, shoot, defend.
Football Turn: Dribble, pass, shoot, defend.
Football Game Over. Whistle blown!
```
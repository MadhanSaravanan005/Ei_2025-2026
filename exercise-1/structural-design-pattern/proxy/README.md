# Movie Ticket Booking Proxy Pattern

## Overview
This project demonstrates the use of the **Proxy Pattern** in Java. The pattern is used to control access to movie ticket booking by providing an intermediary (proxy) that adds validation and access control before delegating to the real booking service.

## Structure
- **MovieTicket**: An interface that defines the contract for movie ticket booking operations.
- **RealMovieTicketBooking**: The concrete implementation that handles the actual ticket booking at the theater counter.
- **ProxyMovieTicketBooking**: A proxy class that controls access to the real booking service, implementing validation and access control (limiting seats to maximum of 5).
- **Main**: The client class that demonstrates the proxy pattern usage with user input.

## Key Components
- **Subject Interface**: `MovieTicket` interface defines common operations for both real object and proxy
- **Real Subject**: `RealMovieTicketBooking` performs the actual ticket booking functionality
- **Proxy**: `ProxyMovieTicketBooking` controls access, adds validation, and delegates to real subject
- **Client**: Interacts with proxy transparently as if it were the real object

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
4. Enter a movie name when prompted.
5. Enter the number of seats when prompted.

## Expected Output
Depending on the number of seats requested:
- **Seats ≤ 5**: Booking proceeds successfully
- **Seats > 5**: Proxy blocks the request with validation message

## Example Run
```
Enter movie name: Avengers
Enter number of seats: 3
Booking via agent (proxy)...
3 ticket(s) booked successfully for Avengers at the theater counter.
```

```
Enter movie name: Spider-Man  
Enter number of seats: 8
Cannot book more than 5 seats at once. Please try again with a smaller number.
```
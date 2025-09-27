# Payment Bridge Pattern

## Overview
This project demonstrates the use of the **Bridge Pattern** in Java. The pattern is used to separate the abstraction of payment processing from the implementation of specific payment methods (UPI, Credit Card, PayPal), allowing both to vary independently without affecting each other.

## Structure
- **Payment**: An abstract class that defines the payment abstraction and holds a reference to PaymentMethod.
- **OnlinePayment**: A concrete implementation of the Payment abstraction that handles online payment processing.
- **PaymentMethod**: An interface that all payment method implementations must implement.
- **UpiPayment, CreditCardPayment, PayPalPayment**: Concrete implementations of the PaymentMethod interface representing different payment mechanisms.

## Key Components
- **Abstraction Layer**: `Payment` class maintains a reference to `PaymentMethod` (the bridge)
- **Implementation Layer**: Various payment methods that implement the core payment functionality
- **Bridge**: The composition relationship between `Payment` and `PaymentMethod` classes

## How to Run
1. Ensure you have Java installed on your machine.
2. Compile the Java files: 
   ```bash
   javac src/*.java Main.java
   ```
3. Run the Main class:
   ```bash
   java Main
   ```
4. Enter a payment amount when prompted.

## Expected Output
Depending on the amount entered:
- **Amount ≤ 1000**: `Paid [amount] using UPI.`
- **Amount ≤ 5000**: `Paid [amount] using Credit Card.`
- **Amount > 5000**: `Paid [amount] using PayPal.`

## Example Run
```
Enter payment amount: 500
Paid 500.0 using UPI.
```

```
Enter payment amount: 3000
Paid 3000.0 using Credit Card.
```

```
Enter payment amount: 8000
Paid 8000.0 using PayPal.
```

## Pattern Benefits
- **Decoupling**: Payment processing logic is separated from payment method implementations
- **Flexibility**: Easy to add new payment methods without modifying existing payment classes
- **Runtime Selection**: Payment method can be chosen dynamically based on business logic
- **Maintainability**: Changes to payment methods don't affect the payment processing abstraction
import java.util.Scanner;
import src.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter payment amount: ");
        double amount = scanner.nextDouble();

        PaymentMethod method;

        
        if (amount <= 1000) {
            method = new UpiPayment();
        } else if (amount <= 5000) {
            method = new CreditCardPayment();
        } else {
            method = new PayPalPayment();
        }

        Payment payment = new OnlinePayment(method);
        payment.makePayment(amount);

        scanner.close();
    }
}

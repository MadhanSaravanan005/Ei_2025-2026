package src;

public class OnlinePayment extends Payment {

    public OnlinePayment(PaymentMethod paymentMethod) {
        super(paymentMethod);
    }

    @Override
    public void makePayment(double amount) {
        paymentMethod.pay(amount);
    }
}

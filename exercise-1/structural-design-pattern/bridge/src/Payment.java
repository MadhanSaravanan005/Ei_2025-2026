package src;

public abstract class Payment {
    protected PaymentMethod paymentMethod;

    protected Payment(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public abstract void makePayment(double amount);
}

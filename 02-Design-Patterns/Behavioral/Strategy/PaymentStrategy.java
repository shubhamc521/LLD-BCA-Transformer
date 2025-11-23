/**
 * Strategy interface for payment methods
 */

public interface PaymentStrategy {
    void pay(double amount);
    String getPaymentType();
}

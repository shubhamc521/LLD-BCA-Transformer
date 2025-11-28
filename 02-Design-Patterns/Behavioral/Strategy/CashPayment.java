/**
 * Concrete Strategy - Cash Payment
 */

public class CashPayment implements PaymentStrategy {
    
    @Override
    public void pay(double amount) {
        System.out.println("Processing cash payment of $" + amount);
        System.out.println("Please provide exact change");
        System.out.println("Payment received!");
    }
    
    @Override
    public String getPaymentType() {
        return "Cash";
    }
}

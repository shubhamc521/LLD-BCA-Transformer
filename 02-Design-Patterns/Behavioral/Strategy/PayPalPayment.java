/**
 * Concrete Strategy - PayPal Payment
 */

public class PayPalPayment implements PaymentStrategy {
    private String email;
    private String password;
    
    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    @Override
    public void pay(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
        System.out.println("PayPal email: " + email);
        System.out.println("Authenticating...");
        System.out.println("Payment successful!");
    }
    
    @Override
    public String getPaymentType() {
        return "PayPal";
    }
}

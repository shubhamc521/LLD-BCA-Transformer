/**
 * Demo class to demonstrate Strategy Pattern
 */

public class StrategyDemo {
    public static void main(String[] args) {
        System.out.println("=== Strategy Pattern Demo: Payment System ===\n");
        
        // Create shopping cart
        ShoppingCart cart = new ShoppingCart();
        
        // Add items to cart
        System.out.println("--- Adding items to cart ---");
        cart.addItem(new Item("Laptop", 999.99));
        cart.addItem(new Item("Mouse", 29.99));
        cart.addItem(new Item("Keyboard", 79.99));
        
        // Pay with Credit Card
        System.out.println("\n=== Scenario 1: Credit Card Payment ===");
        cart.setPaymentStrategy(new CreditCardPayment("1234567890123456", "123", "12/25"));
        cart.checkout();
        
        // Clear cart for next scenario
        System.out.println("\n");
        cart.clear();
        
        // New shopping session
        System.out.println("\n--- Adding items to cart ---");
        cart.addItem(new Item("Headphones", 149.99));
        cart.addItem(new Item("USB Cable", 9.99));
        
        // Pay with PayPal
        System.out.println("\n=== Scenario 2: PayPal Payment ===");
        cart.setPaymentStrategy(new PayPalPayment("user@example.com", "password123"));
        cart.checkout();
        
        // Clear cart for next scenario
        System.out.println("\n");
        cart.clear();
        
        // New shopping session
        System.out.println("\n--- Adding items to cart ---");
        cart.addItem(new Item("Book", 19.99));
        
        // Pay with Cash
        System.out.println("\n=== Scenario 3: Cash Payment ===");
        cart.setPaymentStrategy(new CashPayment());
        cart.checkout();
        
        // Try checkout without payment method
        System.out.println("\n=== Scenario 4: No Payment Method ===");
        ShoppingCart cart2 = new ShoppingCart();
        cart2.addItem(new Item("Pen", 2.99));
        cart2.checkout();
        
        System.out.println("\n=== Demo Complete ===");
    }
}

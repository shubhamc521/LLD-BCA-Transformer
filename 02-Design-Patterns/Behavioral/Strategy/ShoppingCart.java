/**
 * Context class that uses PaymentStrategy
 */

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> items;
    private PaymentStrategy paymentStrategy;
    
    public ShoppingCart() {
        this.items = new ArrayList<>();
    }
    
    public void addItem(Item item) {
        items.add(item);
        System.out.println("Added: " + item.getName() + " - $" + item.getPrice());
    }
    
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
        System.out.println("\nPayment method set to: " + paymentStrategy.getPaymentType());
    }
    
    public double calculateTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }
    
    public void checkout() {
        if (paymentStrategy == null) {
            System.out.println("Please select a payment method!");
            return;
        }
        
        double total = calculateTotal();
        System.out.println("\n--- Checkout Summary ---");
        System.out.println("Items: " + items.size());
        System.out.println("Total amount: $" + total);
        System.out.println("\nProcessing payment using " + paymentStrategy.getPaymentType() + "...");
        paymentStrategy.pay(total);
    }
    
    public void clear() {
        items.clear();
        System.out.println("Cart cleared!");
    }
}

class Item {
    private String name;
    private double price;
    
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
}

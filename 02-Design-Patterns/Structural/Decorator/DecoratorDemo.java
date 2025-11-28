/**
 * Demo class to demonstrate Decorator Pattern
 */

public class DecoratorDemo {
    
    private static void printOrder(Coffee coffee) {
        System.out.println("Order: " + coffee.getDescription());
        System.out.println("Cost: $" + String.format("%.2f", coffee.getCost()));
        System.out.println();
    }
    
    public static void main(String[] args) {
        System.out.println("=== Decorator Pattern Demo: Coffee Shop ===\n");
        
        // Order 1: Simple coffee
        System.out.println("--- Order 1: Basic Coffee ---");
        Coffee coffee1 = new SimpleCoffee();
        printOrder(coffee1);
        
        // Order 2: Coffee with milk
        System.out.println("--- Order 2: Coffee with Milk ---");
        Coffee coffee2 = new SimpleCoffee();
        coffee2 = new MilkDecorator(coffee2);
        printOrder(coffee2);
        
        // Order 3: Coffee with milk and sugar
        System.out.println("--- Order 3: Coffee with Milk and Sugar ---");
        Coffee coffee3 = new SimpleCoffee();
        coffee3 = new MilkDecorator(coffee3);
        coffee3 = new SugarDecorator(coffee3);
        printOrder(coffee3);
        
        // Order 4: Deluxe coffee with all add-ons
        System.out.println("--- Order 4: Deluxe Coffee ---");
        Coffee coffee4 = new SimpleCoffee();
        coffee4 = new MilkDecorator(coffee4);
        coffee4 = new SugarDecorator(coffee4);
        coffee4 = new WhippedCreamDecorator(coffee4);
        printOrder(coffee4);
        
        // Order 5: Double milk, double sugar
        System.out.println("--- Order 5: Extra Milk and Sugar ---");
        Coffee coffee5 = new SimpleCoffee();
        coffee5 = new MilkDecorator(coffee5);
        coffee5 = new MilkDecorator(coffee5);  // Add milk twice
        coffee5 = new SugarDecorator(coffee5);
        coffee5 = new SugarDecorator(coffee5);  // Add sugar twice
        printOrder(coffee5);
        
        // Order 6: Built in one line
        System.out.println("--- Order 6: One-liner Coffee ---");
        Coffee coffee6 = new WhippedCreamDecorator(
                            new SugarDecorator(
                                new MilkDecorator(
                                    new SimpleCoffee())));
        printOrder(coffee6);
        
        System.out.println("=== Demo Complete ===");
        System.out.println("\nKey Points:");
        System.out.println("- Each decorator adds functionality dynamically");
        System.out.println("- Decorators can be stacked in any order");
        System.out.println("- Same decorator can be applied multiple times");
        System.out.println("- Open/Closed Principle: extend without modifying");
    }
}

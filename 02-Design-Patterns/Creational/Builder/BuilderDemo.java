/**
 * Demo class to demonstrate Builder Pattern
 */

public class BuilderDemo {
    public static void main(String[] args) {
        System.out.println("=== Builder Pattern Demo: Computer Configuration ===\n");
        
        // Example 1: Basic computer with only required parameters
        System.out.println("--- Configuration 1: Basic Office Computer ---");
        Computer basicComputer = new Computer.Builder("Intel i3", "8GB")
            .build();
        System.out.println(basicComputer);
        
        // Example 2: Gaming computer with many optional parameters
        System.out.println("--- Configuration 2: Gaming Computer ---");
        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
            .setStorage("2TB NVMe SSD")
            .setGraphicsCard("NVIDIA RTX 4090")
            .setMotherboard("ASUS ROG")
            .setPowerSupply("1000W")
            .setCoolingSystem("Liquid Cooling")
            .enableWifi()
            .enableBluetooth()
            .build();
        System.out.println(gamingComputer);
        
        // Example 3: Budget laptop
        System.out.println("--- Configuration 3: Budget Laptop ---");
        Computer budgetLaptop = new Computer.Builder("AMD Ryzen 3", "4GB")
            .setStorage("128GB SSD")
            .enableWifi()
            .build();
        System.out.println(budgetLaptop);
        
        // Example 4: Workstation for professional work
        System.out.println("--- Configuration 4: Professional Workstation ---");
        Computer workstation = new Computer.Builder("AMD Threadripper", "64GB")
            .setStorage("4TB SSD")
            .setGraphicsCard("NVIDIA A6000")
            .setMotherboard("Professional Grade")
            .setPowerSupply("1200W")
            .setCoolingSystem("Advanced Liquid Cooling")
            .build();
        System.out.println(workstation);
        
        // Example 5: Demonstrating fluent interface
        System.out.println("--- Configuration 5: Custom Build (Fluent Interface) ---");
        Computer customBuild = new Computer.Builder("Intel i7", "16GB")
            .setStorage("1TB NVMe SSD")
            .setGraphicsCard("NVIDIA RTX 3060")
            .enableWifi()
            .build();
        System.out.println(customBuild);
        
        // Example 6: Error handling - missing required parameters
        System.out.println("--- Testing Validation ---");
        try {
            Computer invalidComputer = new Computer.Builder(null, "8GB").build();
        } catch (IllegalStateException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
        
        System.out.println("\n=== Demo Complete ===");
        System.out.println("\nKey Benefits:");
        System.out.println("1. Readable code with method names");
        System.out.println("2. Optional parameters easily managed");
        System.out.println("3. Immutable objects created");
        System.out.println("4. Flexible construction process");
        System.out.println("5. Validation in build() method");
    }
}

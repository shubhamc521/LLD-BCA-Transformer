/**
 * Demo class to demonstrate Factory Pattern
 */

public class FactoryDemo {
    public static void main(String[] args) {
        System.out.println("=== Factory Pattern Demo ===\n");
        
        // Create different vehicles using factory
        Vehicle car = VehicleFactory.createVehicle("CAR");
        System.out.println("\n--- Creating Car ---");
        System.out.println("Type: " + car.getType());
        System.out.println("Wheels: " + car.getWheels());
        car.design();
        car.manufacture();
        
        Vehicle bike = VehicleFactory.createVehicle("BIKE");
        System.out.println("\n--- Creating Bike ---");
        System.out.println("Type: " + bike.getType());
        System.out.println("Wheels: " + bike.getWheels());
        bike.design();
        bike.manufacture();
        
        Vehicle truck = VehicleFactory.createVehicle("TRUCK");
        System.out.println("\n--- Creating Truck ---");
        System.out.println("Type: " + truck.getType());
        System.out.println("Wheels: " + truck.getWheels());
        truck.design();
        truck.manufacture();
        
        // Using factory with additional parameters
        System.out.println("\n--- Creating Premium Car ---");
        Vehicle premiumCar = VehicleFactory.createVehicle("CAR", true);
        premiumCar.design();
        
        // Demonstrate error handling
        System.out.println("\n--- Error Handling ---");
        try {
            Vehicle unknown = VehicleFactory.createVehicle("AIRPLANE");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

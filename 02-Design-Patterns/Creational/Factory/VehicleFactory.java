/**
 * Factory class - responsible for creating Vehicle objects
 */

public class VehicleFactory {
    
    /**
     * Factory method to create different types of vehicles
     * @param vehicleType - type of vehicle to create
     * @return Vehicle instance
     */
    public static Vehicle createVehicle(String vehicleType) {
        if (vehicleType == null || vehicleType.isEmpty()) {
            return null;
        }
        
        switch (vehicleType.toUpperCase()) {
            case "CAR":
                return new Car();
            case "BIKE":
                return new Bike();
            case "TRUCK":
                return new Truck();
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + vehicleType);
        }
    }
    
    /**
     * Alternative factory method with additional parameters
     */
    public static Vehicle createVehicle(String vehicleType, boolean premium) {
        Vehicle vehicle = createVehicle(vehicleType);
        if (vehicle != null && premium) {
            System.out.println("Adding premium features to " + vehicleType);
        }
        return vehicle;
    }
}

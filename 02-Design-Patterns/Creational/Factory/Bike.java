/**
 * Concrete Product - Bike implementation
 */

public class Bike implements Vehicle {
    
    @Override
    public void design() {
        System.out.println("Designing a Bike with 2 wheels and streamlined body");
    }
    
    @Override
    public void manufacture() {
        System.out.println("Manufacturing Bike: Installing engine, assembling parts");
    }
    
    @Override
    public int getWheels() {
        return 2;
    }
    
    @Override
    public String getType() {
        return "Bike";
    }
}

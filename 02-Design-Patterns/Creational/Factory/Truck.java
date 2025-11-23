/**
 * Concrete Product - Truck implementation
 */

public class Truck implements Vehicle {
    
    @Override
    public void design() {
        System.out.println("Designing a Truck with 6 wheels and large cargo body");
    }
    
    @Override
    public void manufacture() {
        System.out.println("Manufacturing Truck: Installing heavy-duty engine, assembling parts");
    }
    
    @Override
    public int getWheels() {
        return 6;
    }
    
    @Override
    public String getType() {
        return "Truck";
    }
}

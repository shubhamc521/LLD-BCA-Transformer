/**
 * Concrete Product - Car implementation
 */

public class Car implements Vehicle {
    
    @Override
    public void design() {
        System.out.println("Designing a Car with 4 wheels and sedan body");
    }
    
    @Override
    public void manufacture() {
        System.out.println("Manufacturing Car: Installing engine, assembling parts");
    }
    
    @Override
    public int getWheels() {
        return 4;
    }
    
    @Override
    public String getType() {
        return "Car";
    }
}

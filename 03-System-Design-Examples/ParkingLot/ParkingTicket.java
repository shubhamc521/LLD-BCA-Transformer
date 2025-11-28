/**
 * Parking ticket issued when a vehicle enters the parking lot
 */

import java.time.LocalDateTime;
import java.util.UUID;

public class ParkingTicket {
    private String ticketId;
    private Vehicle vehicle;
    private LocalDateTime entryTime;
    private int floorNumber;
    private int spotNumber;
    
    public ParkingTicket(Vehicle vehicle, int floorNumber, int spotNumber) {
        this.ticketId = UUID.randomUUID().toString().substring(0, 8);
        this.vehicle = vehicle;
        this.entryTime = LocalDateTime.now();
        this.floorNumber = floorNumber;
        this.spotNumber = spotNumber;
    }
    
    public String getTicketId() {
        return ticketId;
    }
    
    public Vehicle getVehicle() {
        return vehicle;
    }
    
    public LocalDateTime getEntryTime() {
        return entryTime;
    }
    
    public int getFloorNumber() {
        return floorNumber;
    }
    
    public int getSpotNumber() {
        return spotNumber;
    }
    
    @Override
    public String toString() {
        return "Ticket{" +
                "ID='" + ticketId + '\'' +
                ", Vehicle=" + vehicle +
                ", Floor=" + floorNumber +
                ", Spot=" + spotNumber +
                ", EntryTime=" + entryTime +
                '}';
    }
}

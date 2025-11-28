# Parking Lot System Design

## Problem Statement

Design a parking lot system that can handle multiple types of vehicles with different parking spot requirements.

## Requirements

### Functional Requirements
1. The parking lot should have multiple floors
2. Support different types of vehicles: Car, Bike, Truck
3. Different parking spot sizes: Compact, Standard, Large
4. Track available and occupied spots
5. Issue parking tickets when vehicle enters
6. Calculate parking fee when vehicle exits
7. Display available spots for each vehicle type

### Non-Functional Requirements
1. System should be scalable
2. Easy to maintain and extend
3. Thread-safe for concurrent access
4. Efficient spot allocation

## Design Considerations

### Classes Needed
1. **ParkingLot** - Main class (Singleton)
2. **ParkingFloor** - Represents a floor
3. **ParkingSpot** - Abstract class for spots
4. **Vehicle** - Abstract class for vehicles
5. **ParkingTicket** - Ticket information
6. **Payment** - Payment processing

### Vehicle Types
- Bike (2-wheeler)
- Car (4-wheeler)
- Truck (heavy vehicle)

### Parking Spot Types
- Compact Spot (for bikes)
- Standard Spot (for cars)
- Large Spot (for trucks)

### Spot Allocation Logic
- Bike can park in: Compact, Standard, or Large
- Car can park in: Standard or Large
- Truck can only park in: Large

## Class Diagram

```
┌──────────────────┐
│   ParkingLot     │ (Singleton)
├──────────────────┤
│ - floors: List   │
│ + addFloor()     │
│ + parkVehicle()  │
│ + unparkVehicle()│
└──────────────────┘
         │
         │ has
         ▼
┌──────────────────┐
│  ParkingFloor    │
├──────────────────┤
│ - spots: List    │
│ + addSpot()      │
│ + getAvailable() │
└──────────────────┘
         │
         │ has
         ▼
┌──────────────────┐
│  ParkingSpot     │ (Abstract)
├──────────────────┤
│ - spotNumber     │
│ - vehicle        │
│ + assignVehicle()│
│ + removeVehicle()│
└──────────────────┘
         △
         │
    ┏────┸────┓
    ▼         ▼
┌────────┐ ┌────────┐
│Compact │ │Standard│
│  Spot  │ │  Spot  │
└────────┘ └────────┘

┌──────────────────┐
│     Vehicle      │ (Abstract)
├──────────────────┤
│ - licensePlate   │
│ - type           │
└──────────────────┘
         △
         │
    ┏────┸────┓
    ▼         ▼
┌────────┐ ┌────────┐
│  Bike  │ │  Car   │
└────────┘ └────────┘

┌──────────────────┐
│  ParkingTicket   │
├──────────────────┤
│ - ticketId       │
│ - vehicle        │
│ - spot           │
│ - entryTime      │
└──────────────────┘
```

## Design Patterns Used

1. **Singleton Pattern**
   - ParkingLot class (only one instance needed)

2. **Factory Pattern**
   - Creating different vehicle types
   - Creating different spot types

3. **Strategy Pattern**
   - Different pricing strategies (hourly, daily, flat rate)

## Key Features

1. **Spot Management**
   - Automatic spot allocation
   - Spot availability tracking
   - Floor-wise distribution

2. **Ticket System**
   - Unique ticket ID
   - Entry timestamp
   - Vehicle and spot information

3. **Payment Calculation**
   - Time-based calculation
   - Different rates for different vehicles
   - Grace period handling

4. **Display System**
   - Available spots per floor
   - Available spots per vehicle type
   - Occupancy statistics

## Extension Points

1. Add reservation system
2. Add monthly/yearly passes
3. Add handicap parking spots
4. Add electric vehicle charging spots
5. Add valet parking
6. Add multi-level pricing
7. Add payment methods (cash, card, UPI)

## Files

- `Vehicle.java` - Abstract vehicle class
- `Bike.java`, `Car.java`, `Truck.java` - Concrete vehicle classes
- `ParkingSpot.java` - Abstract parking spot class
- `CompactSpot.java`, `StandardSpot.java`, `LargeSpot.java` - Concrete spot classes
- `ParkingTicket.java` - Ticket information
- `ParkingFloor.java` - Floor management
- `ParkingLot.java` - Main parking lot class
- `ParkingDemo.java` - Demo application

## Usage Example

```java
// Get parking lot instance
ParkingLot parkingLot = ParkingLot.getInstance();

// Park a vehicle
Vehicle car = new Car("ABC-123");
ParkingTicket ticket = parkingLot.parkVehicle(car);

// ... some time passes ...

// Unpark and pay
double amount = parkingLot.unparkVehicle(ticket);
System.out.println("Payment: $" + amount);
```

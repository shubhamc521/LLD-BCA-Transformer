# Factory Pattern

## Intent
Define an interface for creating an object, but let subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses.

## Motivation
- You need to create objects but don't want to specify the exact class
- The creation logic is complex or should be centralized
- You want to decouple object creation from usage

## Problem
When you directly instantiate objects using `new` keyword:
- Code becomes tightly coupled to concrete classes
- Difficult to change or extend without modifying existing code
- Testing becomes harder

## Solution
Create a factory class/method that encapsulates the object creation logic.

## Structure

```
┌──────────────┐
│   Product    │ (Interface)
└──────────────┘
       △
       │
   ┌───┴───┐
   │       │
┌──────┐ ┌────────┐
│Product│ │Product │
│   A   │ │   B    │
└──────┘ └────────┘
       
┌──────────────┐
│   Factory    │
├──────────────┤
│+createProduct│
│  (type)      │
└──────────────┘
```

## Types of Factory Pattern

### 1. Simple Factory
- Not a true design pattern but a programming idiom
- Centralized object creation

### 2. Factory Method Pattern
- Uses inheritance
- Subclasses decide which class to instantiate

### 3. Abstract Factory Pattern
- Creates families of related objects
- More complex, used when multiple related products need to be created

## Advantages
- Loose coupling between creator and concrete products
- Single Responsibility - creation code in one place
- Open/Closed Principle - can introduce new types without breaking existing code
- Easier testing and mocking

## Disadvantages
- Can become complex with many product types
- May introduce unnecessary complexity for simple object creation

## When to Use
- Class doesn't know ahead of time what objects it needs to create
- Class wants its subclasses to specify the objects it creates
- Classes delegate responsibility to helper subclasses
- Object creation is complex and should be centralized

## Real-World Examples
- `Calendar.getInstance()` in Java
- Database connection factories
- Shape factories (Circle, Rectangle, Triangle)
- Vehicle factories (Car, Bike, Truck)
- Document creators (PDF, Word, Excel)

## Related Patterns
- Abstract Factory
- Template Method
- Prototype

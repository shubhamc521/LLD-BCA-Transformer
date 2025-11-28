# Design Patterns

Design patterns are typical solutions to common problems in software design. They represent best practices and can speed up the development process by providing tested, proven development paradigms.

## Categories of Design Patterns

### 1. Creational Patterns
These patterns deal with object creation mechanisms, trying to create objects in a manner suitable to the situation.

- **Singleton Pattern** - Ensures a class has only one instance
- **Factory Pattern** - Creates objects without specifying exact class
- **Abstract Factory Pattern** - Creates families of related objects
- **Builder Pattern** - Constructs complex objects step by step
- **Prototype Pattern** - Creates objects by cloning existing ones

### 2. Structural Patterns
These patterns deal with object composition and typically identify simple ways to realize relationships between different objects.

- **Adapter Pattern** - Allows incompatible interfaces to work together
- **Decorator Pattern** - Adds new functionality to objects dynamically
- **Proxy Pattern** - Provides a surrogate or placeholder for another object
- **Facade Pattern** - Provides a simplified interface to a complex subsystem
- **Composite Pattern** - Composes objects into tree structures
- **Bridge Pattern** - Separates abstraction from implementation
- **Flyweight Pattern** - Reduces memory usage by sharing data

### 3. Behavioral Patterns
These patterns are concerned with algorithms and the assignment of responsibilities between objects.

- **Observer Pattern** - Defines a subscription mechanism
- **Strategy Pattern** - Defines a family of algorithms
- **Command Pattern** - Encapsulates a request as an object
- **State Pattern** - Allows an object to alter its behavior
- **Template Method Pattern** - Defines skeleton of algorithm in base class
- **Iterator Pattern** - Provides sequential access to elements
- **Chain of Responsibility Pattern** - Passes requests along a chain
- **Mediator Pattern** - Reduces coupling between components
- **Memento Pattern** - Saves and restores object state
- **Visitor Pattern** - Separates algorithms from objects

## How to Use This Section

Each pattern folder contains:
- README.md - Detailed explanation of the pattern
- UML diagram
- Java implementation with examples
- Use cases and when to apply the pattern
- Advantages and disadvantages

## Quick Reference

| Pattern | Category | Purpose | When to Use |
|---------|----------|---------|-------------|
| Singleton | Creational | One instance | Global access point needed |
| Factory | Creational | Create objects | Object creation is complex |
| Observer | Behavioral | Notify changes | One-to-many dependency |
| Strategy | Behavioral | Interchangeable algorithms | Multiple algorithm variants |
| Decorator | Structural | Add responsibilities | Extend functionality dynamically |
| Adapter | Structural | Make interfaces compatible | Integrate legacy code |

## Learning Path

1. Start with **Creational Patterns** - Learn how to create objects efficiently
2. Move to **Structural Patterns** - Understand object composition
3. Master **Behavioral Patterns** - Learn about object collaboration

## Best Practices

- Don't force patterns where they don't fit
- Understand the problem before applying a pattern
- Keep it simple - use patterns to simplify, not complicate
- Patterns should emerge from refactoring, not be applied upfront
- Combine patterns when appropriate

## Resources

- Gang of Four (GoF) Design Patterns book
- Head First Design Patterns
- Refactoring.Guru website
- Java Design Patterns documentation

---

Navigate to individual pattern folders to explore detailed implementations!

# Object-Oriented Programming Concepts

## Introduction

Object-Oriented Programming (OOP) is a programming paradigm based on the concept of "objects" which contain data (attributes) and code (methods).

## Four Pillars of OOP

### 1. Encapsulation

**Definition:** Bundling data and methods that operate on that data within a single unit (class), and restricting direct access to some components.

**Benefits:**
- Data hiding and protection
- Flexibility and maintainability
- Loose coupling
- Code reusability

**Example:**
```java
public class BankAccount {
    // Private data - hidden from outside
    private double balance;
    private String accountNumber;
    
    // Public methods - controlled access
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    
    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
    
    public double getBalance() {
        return balance;
    }
}
```

### 2. Inheritance

**Definition:** A mechanism where a new class (child/derived) acquires properties and behaviors of an existing class (parent/base).

**Benefits:**
- Code reusability
- Method overriding
- Hierarchical classification
- Polymorphism support

**Types:**
- Single Inheritance
- Multilevel Inheritance
- Hierarchical Inheritance
- (Multiple Inheritance via Interfaces in Java)

**Example:**
```java
// Base class
public class Animal {
    protected String name;
    
    public void eat() {
        System.out.println(name + " is eating");
    }
}

// Derived class
public class Dog extends Animal {
    public Dog(String name) {
        this.name = name;
    }
    
    public void bark() {
        System.out.println(name + " is barking");
    }
}

// Usage
Dog dog = new Dog("Buddy");
dog.eat();   // Inherited method
dog.bark();  // Own method
```

### 3. Polymorphism

**Definition:** The ability of objects to take multiple forms. Same interface, different implementations.

**Types:**

**A. Compile-Time Polymorphism (Method Overloading)**
```java
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    
    public double add(double a, double b) {
        return a + b;
    }
    
    public int add(int a, int b, int c) {
        return a + b + c;
    }
}
```

**B. Runtime Polymorphism (Method Overriding)**
```java
public class Shape {
    public void draw() {
        System.out.println("Drawing a shape");
    }
}

public class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

public class Rectangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}

// Usage
Shape shape1 = new Circle();
Shape shape2 = new Rectangle();
shape1.draw();  // Calls Circle's draw()
shape2.draw();  // Calls Rectangle's draw()
```

### 4. Abstraction

**Definition:** Hiding complex implementation details and showing only essential features.

**Ways to Achieve:**
- Abstract classes
- Interfaces

**Abstract Class Example:**
```java
public abstract class Vehicle {
    protected String brand;
    
    // Abstract method - no implementation
    public abstract void start();
    
    // Concrete method
    public void stop() {
        System.out.println("Vehicle stopped");
    }
}

public class Car extends Vehicle {
    @Override
    public void start() {
        System.out.println("Car starting with key");
    }
}
```

**Interface Example:**
```java
public interface Drawable {
    void draw();  // Implicitly public and abstract
}

public interface Colorable {
    void setColor(String color);
}

public class Circle implements Drawable, Colorable {
    private String color;
    
    @Override
    public void draw() {
        System.out.println("Drawing circle");
    }
    
    @Override
    public void setColor(String color) {
        this.color = color;
    }
}
```

## Key OOP Concepts

### 1. Class
Blueprint for creating objects.

```java
public class Student {
    // Attributes
    private String name;
    private int rollNumber;
    
    // Constructor
    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }
    
    // Methods
    public void study() {
        System.out.println(name + " is studying");
    }
}
```

### 2. Object
Instance of a class.

```java
Student student1 = new Student("John", 101);
Student student2 = new Student("Alice", 102);
```

### 3. Constructor
Special method to initialize objects.

```java
public class Book {
    private String title;
    
    // Default constructor
    public Book() {
        this.title = "Unknown";
    }
    
    // Parameterized constructor
    public Book(String title) {
        this.title = title;
    }
}
```

### 4. Method
Function defined inside a class.

```java
public class Calculator {
    // Instance method
    public int add(int a, int b) {
        return a + b;
    }
    
    // Static method
    public static int multiply(int a, int b) {
        return a * b;
    }
}
```

## Composition vs Inheritance

### Composition (Has-A Relationship)
```java
public class Engine {
    public void start() {
        System.out.println("Engine started");
    }
}

public class Car {
    private Engine engine;  // Car HAS-A Engine
    
    public Car() {
        this.engine = new Engine();
    }
    
    public void start() {
        engine.start();
    }
}
```

### Inheritance (Is-A Relationship)
```java
public class Vehicle {
    public void move() {
        System.out.println("Vehicle moving");
    }
}

public class Car extends Vehicle {
    // Car IS-A Vehicle
}
```

**When to Use:**
- Use Composition when you want flexibility and loose coupling
- Use Inheritance when there's a clear "is-a" relationship
- Favor Composition over Inheritance (Design principle)

## Access Modifiers

| Modifier | Class | Package | Subclass | World |
|----------|-------|---------|----------|-------|
| public | ✓ | ✓ | ✓ | ✓ |
| protected | ✓ | ✓ | ✓ | ✗ |
| default | ✓ | ✓ | ✗ | ✗ |
| private | ✓ | ✗ | ✗ | ✗ |

## Best Practices

1. **Encapsulate Data**
   - Keep fields private
   - Provide public getters/setters

2. **Program to Interfaces**
   - Depend on abstractions, not concrete classes

3. **Favor Composition**
   - More flexible than inheritance

4. **Single Responsibility**
   - Each class should have one reason to change

5. **Open/Closed Principle**
   - Open for extension, closed for modification

6. **Use Meaningful Names**
   - Classes: Nouns (Student, Car)
   - Methods: Verbs (calculateTotal, sendEmail)

## Common Pitfalls

1. **God Object** - Class that does too much
2. **Tight Coupling** - Classes too dependent on each other
3. **Deep Inheritance** - Too many levels of inheritance
4. **Premature Optimization** - Optimizing before needed
5. **Not Using Interfaces** - Missing abstraction opportunities

## Conclusion

OOP provides a structured way to design software that is:
- Modular
- Reusable
- Maintainable
- Scalable
- Easy to test

Master these concepts to write better object-oriented code!

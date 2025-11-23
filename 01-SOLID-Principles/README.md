# SOLID Principles

SOLID is an acronym for five design principles that make software designs more understandable, flexible, and maintainable.

## The Five Principles

1. **S**ingle Responsibility Principle (SRP)
2. **O**pen/Closed Principle (OCP)
3. **L**iskov Substitution Principle (LSP)
4. **I**nterface Segregation Principle (ISP)
5. **D**ependency Inversion Principle (DIP)

## 1. Single Responsibility Principle (SRP)

**Definition:** A class should have only one reason to change, meaning it should have only one job or responsibility.

**Example:**

```java
// Bad Example - Multiple Responsibilities
class Employee {
    public void calculatePay() { /* ... */ }
    public void saveToDatabase() { /* ... */ }
    public void generateReport() { /* ... */ }
}

// Good Example - Single Responsibility
class Employee {
    private String name;
    private double salary;
    // Employee data and basic operations
}

class PayrollCalculator {
    public double calculatePay(Employee employee) { /* ... */ }
}

class EmployeeRepository {
    public void save(Employee employee) { /* ... */ }
}

class ReportGenerator {
    public void generateReport(Employee employee) { /* ... */ }
}
```

## 2. Open/Closed Principle (OCP)

**Definition:** Software entities should be open for extension but closed for modification.

**Example:**

```java
// Bad Example - Need to modify class for new shapes
class AreaCalculator {
    public double calculateArea(Object shape) {
        if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            return Math.PI * circle.radius * circle.radius;
        } else if (shape instanceof Rectangle) {
            Rectangle rect = (Rectangle) shape;
            return rect.width * rect.height;
        }
        return 0;
    }
}

// Good Example - Open for extension
interface Shape {
    double calculateArea();
}

class Circle implements Shape {
    private double radius;
    
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle implements Shape {
    private double width;
    private double height;
    
    public double calculateArea() {
        return width * height;
    }
}

class AreaCalculator {
    public double calculateArea(Shape shape) {
        return shape.calculateArea();
    }
}
```

## 3. Liskov Substitution Principle (LSP)

**Definition:** Objects of a superclass should be replaceable with objects of a subclass without breaking the application.

**Example:**

```java
// Bad Example - Violates LSP
class Bird {
    public void fly() { /* ... */ }
}

class Penguin extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins can't fly!");
    }
}

// Good Example - Follows LSP
abstract class Bird {
    abstract void move();
}

class FlyingBird extends Bird {
    public void move() {
        fly();
    }
    
    private void fly() { /* ... */ }
}

class Penguin extends Bird {
    public void move() {
        swim();
    }
    
    private void swim() { /* ... */ }
}
```

## 4. Interface Segregation Principle (ISP)

**Definition:** No client should be forced to depend on methods it does not use.

**Example:**

```java
// Bad Example - Fat Interface
interface Worker {
    void work();
    void eat();
    void sleep();
}

class HumanWorker implements Worker {
    public void work() { /* ... */ }
    public void eat() { /* ... */ }
    public void sleep() { /* ... */ }
}

class RobotWorker implements Worker {
    public void work() { /* ... */ }
    public void eat() { /* Not applicable */ }
    public void sleep() { /* Not applicable */ }
}

// Good Example - Segregated Interfaces
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

interface Sleepable {
    void sleep();
}

class HumanWorker implements Workable, Eatable, Sleepable {
    public void work() { /* ... */ }
    public void eat() { /* ... */ }
    public void sleep() { /* ... */ }
}

class RobotWorker implements Workable {
    public void work() { /* ... */ }
}
```

## 5. Dependency Inversion Principle (DIP)

**Definition:** High-level modules should not depend on low-level modules. Both should depend on abstractions.

**Example:**

```java
// Bad Example - High-level depends on low-level
class MySQLDatabase {
    public void save(String data) { /* ... */ }
}

class UserService {
    private MySQLDatabase database;
    
    public UserService() {
        this.database = new MySQLDatabase();
    }
    
    public void saveUser(String user) {
        database.save(user);
    }
}

// Good Example - Both depend on abstraction
interface Database {
    void save(String data);
}

class MySQLDatabase implements Database {
    public void save(String data) { /* ... */ }
}

class MongoDatabase implements Database {
    public void save(String data) { /* ... */ }
}

class UserService {
    private Database database;
    
    public UserService(Database database) {
        this.database = database;
    }
    
    public void saveUser(String user) {
        database.save(user);
    }
}
```

## Benefits of SOLID Principles

- **Maintainability:** Easier to maintain and update code
- **Scalability:** System can grow without major refactoring
- **Testability:** Easier to write unit tests
- **Flexibility:** Easy to add new features
- **Reusability:** Components can be reused in different contexts
- **Understandability:** Code is easier to read and understand

## When to Apply SOLID

- When designing new systems
- When refactoring existing code
- When code becomes difficult to maintain
- When adding new features becomes challenging
- During code reviews

## Conclusion

SOLID principles are fundamental guidelines for writing clean, maintainable object-oriented code. While it's important to understand and apply these principles, remember that they are guidelines, not strict rules. Use judgment to apply them appropriately based on your specific context.

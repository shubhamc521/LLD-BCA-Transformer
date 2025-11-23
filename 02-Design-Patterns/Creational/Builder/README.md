# Builder Pattern

## Intent
Separate the construction of a complex object from its representation, allowing the same construction process to create different representations.

## Motivation
When creating a complex object with many optional parameters or construction steps, the constructor can become unwieldy. The Builder pattern provides a flexible solution for constructing complex objects step by step.

## Problem
Creating objects with many parameters leads to:
- Telescoping constructors (many overloaded constructors)
- Hard to read and maintain code
- Easy to pass parameters in wrong order
- Difficult to add new parameters
- Required vs optional parameters unclear

## Solution
Use a Builder class to construct the object step by step, providing a fluent interface for setting properties.

## Structure

```
┌──────────────┐
│   Director   │
├──────────────┤        ┌──────────────┐
│ - builder    │◇───────│   Builder    │ «interface»
├──────────────┤        ├──────────────┤
│ + construct()│        │ + buildPart()│
└──────────────┘        │ + getResult()│
                        └──────────────┘
                               △
                               │
                        ┌──────┴──────┐
                        │   Concrete  │
                        │   Builder   │
                        ├─────────────┤
                        │ + buildPart()│
                        │ + getResult()│
                        └─────────────┘
                               │
                               │ creates
                               ▼
                        ┌──────────────┐
                        │   Product    │
                        └──────────────┘
```

## Participants

1. **Builder (Interface)**
   - Specifies abstract interface for creating parts of Product

2. **ConcreteBuilder**
   - Constructs and assembles parts of the product
   - Defines and keeps track of the representation it creates
   - Provides interface for retrieving the product

3. **Director**
   - Constructs object using Builder interface
   - Optional - client can play this role

4. **Product**
   - Complex object under construction

## Advantages
- Control over construction process
- Immutable objects (can make product immutable)
- Fluent interface - readable code
- Step-by-step construction
- Can construct different representations with same code
- Single Responsibility Principle
- Isolates complex construction code

## Disadvantages
- More code - need to create builder
- Increased complexity for simple objects
- Must create separate builder for each product type

## When to Use
- Object has many optional parameters
- Object construction requires many steps
- Need different representations of the same construction
- Want to create immutable objects
- Telescoping constructor anti-pattern appears
- Need to construct composite objects

## Real-World Examples
- StringBuilder in Java
- HTTP request builders (OkHttp, Retrofit)
- SQL query builders
- Document builders (HTML, XML)
- Meal builders (Burger, Pizza)
- Computer configuration builders
- Form builders in UI frameworks

## Fluent Builder Pattern

Most common variation uses method chaining:

```java
Product product = new Product.Builder()
    .setProperty1(value1)
    .setProperty2(value2)
    .setProperty3(value3)
    .build();
```

## Builder Types

### 1. Classic Builder (Gang of Four)
Separate builder class, optional director

### 2. Fluent Builder
Method chaining for readability

### 3. Static Inner Builder
Builder as static inner class of product

### 4. Step Builder
Forces certain order of method calls

## Related Patterns
- Abstract Factory - similar but focuses on families of products
- Composite - builder often builds composites
- Singleton - builders are often singletons
- Template Method - director uses template method

## Implementation Considerations

### Required vs Optional Parameters
- Constructor takes required parameters
- Builder methods for optional parameters

### Immutability
- Make product immutable after building
- No setters on product
- Builder creates new instance

### Validation
- Validate in build() method
- Throw exception if invalid state
- Or return null/Optional

## Code Structure

```java
// Product
class Product {
    private String part1;
    private String part2;
    
    // Private constructor - can only be created by Builder
    private Product(Builder builder) {
        this.part1 = builder.part1;
        this.part2 = builder.part2;
    }
    
    // Static inner Builder class
    static class Builder {
        private String part1;
        private String part2;
        
        public Builder setPart1(String part1) {
            this.part1 = part1;
            return this;  // Return this for chaining
        }
        
        public Builder setPart2(String part2) {
            this.part2 = part2;
            return this;
        }
        
        public Product build() {
            // Validation can go here
            return new Product(this);
        }
    }
}
```

## Builder vs Constructor

| Builder | Constructor |
|---------|------------|
| Many optional parameters | All required |
| Step-by-step | All at once |
| Method names clarify | Position matters |
| Easy to extend | Hard to extend |
| More code | Less code |

## Builder vs Factory

| Builder | Factory |
|---------|---------|
| Complex construction | Simple creation |
| Step-by-step | One method |
| Same product type | Different types |
| Client controls process | Factory controls |

## Best Practices

1. **Use for Complex Objects**
   - 4+ parameters or complex construction

2. **Make Product Immutable**
   - No setters after building

3. **Validate in build()**
   - Throw exception if invalid

4. **Return this for Chaining**
   - Fluent interface pattern

5. **Use Static Inner Class**
   - Keep builder close to product

6. **Required Parameters in Constructor**
   - Builder constructor takes required params

7. **Consistent Naming**
   - setX() or withX() or just x()

## Example Scenarios

### 1. Complex Configuration
Application settings with many optional parameters

### 2. Email Message
Subject, body, attachments, recipients, etc.

### 3. HTTP Request
URL, headers, method, body, timeout, etc.

### 4. Database Query
SELECT, FROM, WHERE, JOIN, ORDER BY, etc.

### 5. UI Components
Window with title, size, position, buttons, etc.

## Lombok @Builder

Modern Java with Lombok library:

```java
@Builder
public class User {
    private String name;
    private int age;
    private String email;
}

// Usage
User user = User.builder()
    .name("John")
    .age(30)
    .email("john@example.com")
    .build();
```

## Testing

Builder pattern makes testing easier:

```java
// Easy to create test objects
Product testProduct = new Product.Builder()
    .setPart1("test1")
    .setPart2("test2")
    .build();
```

## Common Mistakes

1. **Using for Simple Objects** - Overkill for 1-2 parameters
2. **Not Validating** - Build invalid objects
3. **Mutable Products** - Defeats immutability benefit
4. **Too Many Builders** - One builder per product variation
5. **Forgetting build()** - Easy to forget final step

## Conclusion

The Builder pattern is excellent for:
- Creating complex objects with many parameters
- Making code more readable and maintainable
- Creating immutable objects
- Providing a fluent API

Use it wisely and your code will be cleaner and easier to work with!

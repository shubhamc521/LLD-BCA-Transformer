# Strategy Pattern

## Intent
Define a family of algorithms, encapsulate each one, and make them interchangeable. Strategy lets the algorithm vary independently from clients that use it.

## Also Known As
- Policy Pattern

## Motivation
Often you want to use different variants of an algorithm within an object and be able to switch from one algorithm to another at runtime.

## Problem
When you have multiple ways to do something (algorithms) and you want to:
- Choose the algorithm at runtime
- Avoid conditional statements (if-else, switch-case)
- Make the code more maintainable and extendable

## Solution
Define a family of algorithms in separate classes that implement a common interface, allowing them to be interchangeable.

## Structure

```
┌──────────────┐
│   Context    │
├──────────────┤
│ - strategy   │◇──────┐
├──────────────┤       │
│ + execute()  │       │
└──────────────┘       │
                       │
                ┌──────▼──────┐
                │  Strategy   │ «interface»
                ├─────────────┤
                │+ algorithm()│
                └─────────────┘
                       △
                       │
           ┌───────────┼───────────┐
           │           │           │
    ┌──────────┐ ┌──────────┐ ┌──────────┐
    │Strategy  │ │Strategy  │ │Strategy  │
    │    A     │ │    B     │ │    C     │
    └──────────┘ └──────────┘ └──────────┘
```

## Participants

1. **Strategy (Interface)**
   - Declares an interface common to all supported algorithms

2. **ConcreteStrategy**
   - Implements the algorithm using the Strategy interface

3. **Context**
   - Maintains a reference to a Strategy object
   - May define an interface for Strategy to access its data

## Advantages
- Family of algorithms can be defined as class hierarchy
- Open/Closed Principle - easy to add new strategies
- Eliminates conditional statements
- Runtime flexibility - can change strategy at runtime
- Clients can choose different implementations

## Disadvantages
- Clients must be aware of different strategies
- Increases number of objects
- Communication overhead between Strategy and Context

## When to Use
- Many related classes differ only in their behavior
- Need different variants of an algorithm
- Algorithm uses data that clients shouldn't know about
- Class defines many behaviors with multiple conditional statements

## Real-World Examples
- Payment methods (Credit Card, PayPal, Cash)
- Sorting algorithms (Bubble Sort, Quick Sort, Merge Sort)
- Compression algorithms (ZIP, RAR, 7Z)
- Route planning (Shortest, Fastest, Scenic)
- Validation strategies (Email, Phone, Password)
- Pricing strategies (Regular, Holiday, Seasonal)

## Related Patterns
- State - similar structure but different intent
- Template Method - uses inheritance instead of composition
- Decorator - changes object's skin vs strategy changes guts

## Implementation Tips

1. **Identify the Algorithm Family**
   - Find algorithms that do similar things differently

2. **Extract to Interface**
   - Define common interface for all algorithms

3. **Create Concrete Strategies**
   - Implement each algorithm in a separate class

4. **Context Uses Strategy**
   - Context delegates to strategy instead of implementing

## Comparison with State Pattern

| Strategy | State |
|----------|-------|
| Client chooses strategy | Context changes state automatically |
| Focuses on algorithm variation | Focuses on state-dependent behavior |
| Strategies are independent | States know about each other |
| Strategy doesn't change | State can change during execution |

## Example Scenarios

### 1. Payment Processing
Different payment methods (Credit Card, PayPal, Bitcoin)

### 2. Travel Planning
Different travel modes (Car, Bus, Train, Flight)

### 3. Data Compression
Different compression algorithms (ZIP, RAR, GZIP)

### 4. Sorting
Different sorting algorithms based on data size

## Code Structure

```java
// Strategy interface
interface Strategy {
    void execute();
}

// Concrete strategies
class StrategyA implements Strategy {
    public void execute() { }
}

class StrategyB implements Strategy {
    public void execute() { }
}

// Context
class Context {
    private Strategy strategy;
    
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    
    public void performAction() {
        strategy.execute();
    }
}
```

## Best Practices

1. **Use when you have multiple algorithms**
2. **Prefer composition over inheritance**
3. **Keep strategies stateless when possible**
4. **Consider using enums for simple strategies**
5. **Document when to use which strategy**

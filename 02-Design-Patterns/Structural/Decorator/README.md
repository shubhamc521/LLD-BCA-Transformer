# Decorator Pattern

## Intent
Attach additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.

## Also Known As
- Wrapper

## Motivation
Sometimes we want to add responsibilities to individual objects, not to an entire class. Inheritance is one way to do this but it's inflexible and static. Decorator pattern offers a more flexible approach.

## Problem
When you want to:
- Add responsibilities to objects dynamically and transparently
- Add responsibilities that can be withdrawn
- Extend functionality without creating too many subclasses
- Avoid modifying existing code

## Solution
Wrap the original object with decorator objects that add new behavior. Decorators implement the same interface as the component they decorate.

## Structure

```
┌──────────────┐
│  Component   │ «interface»
├──────────────┤
│ + operation()│
└──────────────┘
       △
       │
   ┌───┴────────────────────┐
   │                        │
┌──────────────┐    ┌──────────────┐
│   Concrete   │    │  Decorator   │ (Abstract)
│  Component   │    ├──────────────┤
└──────────────┘    │ - component  │◇───┐
                    │ + operation()│    │
                    └──────────────┘    │
                           △            │
                           │            │
                    ┌──────┴──────┐    │
                    │             │    │
             ┌──────────┐  ┌──────────┐│
             │Concrete  │  │Concrete  ││
             │Decorator │  │Decorator ││
             │    A     │  │    B     ││
             └──────────┘  └──────────┘│
                      └─────────────────┘
```

## Participants

1. **Component (Interface)**
   - Defines interface for objects that can have responsibilities added

2. **ConcreteComponent**
   - Object to which additional responsibilities can be attached

3. **Decorator**
   - Maintains reference to Component object
   - Defines interface that conforms to Component

4. **ConcreteDecorator**
   - Adds responsibilities to the component

## Advantages
- More flexible than static inheritance
- Avoids feature-laden classes high up in the hierarchy
- Add/remove responsibilities at runtime
- Combine behaviors by wrapping multiple decorators
- Divide functionality between classes (Single Responsibility)
- Open/Closed Principle - extend without modifying

## Disadvantages
- Many small objects - can be hard to understand
- Decorators and their components aren't identical
- Can be hard to configure (lots of wrapping)
- Can complicate debugging

## When to Use
- Add responsibilities to objects dynamically
- Responsibilities should be withdrawable
- Extension by subclassing is impractical
- Want to avoid explosion of subclasses
- Need to add features to objects without affecting other objects

## Real-World Examples
- Java I/O Streams (BufferedReader, FileReader)
- GUI components (adding scroll bars, borders)
- Pizza with toppings (cheese, pepperoni, olives)
- Coffee with add-ons (milk, sugar, whipped cream)
- Text formatting (bold, italic, underline)
- Notifications with channels (Email, SMS, Slack)

## Related Patterns
- Adapter - changes interface, Decorator enhances responsibilities
- Composite - decorator can be viewed as degenerate composite
- Strategy - decorator changes object's skin, strategy changes guts
- Proxy - controls access, decorator adds responsibilities

## Key Points

### Decorator vs Inheritance
| Decorator | Inheritance |
|-----------|-------------|
| Runtime composition | Compile-time binding |
| Flexible combination | Fixed structure |
| Single responsibility | Can violate SRP |
| Easier to test | Can be harder to test |

### Decorator vs Adapter
| Decorator | Adapter |
|-----------|---------|
| Enhances functionality | Changes interface |
| Same interface | Different interface |
| Wraps one object | Can adapt multiple |

## Implementation Considerations

1. **Interface Conformance**
   - Decorator must conform to component interface

2. **Omitting Abstract Decorator**
   - Can skip if only one responsibility to add

3. **Keeping Component Simple**
   - Component should focus on defining interface

4. **Changing Object's Skin**
   - Strategy changes algorithm, decorator changes appearance

## Common Variations

### 1. Transparent Decorator
Same interface as component - clients don't know it's decorated

### 2. Semi-Transparent Decorator
Adds new methods - clients know it's decorated

### 3. Multiple Decorators
Can wrap an object with multiple decorators

## Example Scenarios

### 1. Coffee Shop
Base coffee + optional milk, sugar, whipped cream

### 2. Text Editor
Plain text + bold, italic, underline formatting

### 3. Notification System
Base notification + Email, SMS, Push notification channels

### 4. Data Stream
Basic stream + compression, encryption layers

## Code Structure

```java
// Component interface
interface Component {
    void operation();
}

// Concrete component
class ConcreteComponent implements Component {
    public void operation() { }
}

// Base decorator
abstract class Decorator implements Component {
    protected Component component;
    
    public Decorator(Component component) {
        this.component = component;
    }
    
    public void operation() {
        component.operation();
    }
}

// Concrete decorator
class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }
    
    public void operation() {
        super.operation();
        addedBehavior();
    }
    
    private void addedBehavior() { }
}
```

## Best Practices

1. **Keep Decorators Focused**
   - Each decorator should add one responsibility

2. **Use Interface/Abstract Class**
   - Component should be interface or abstract class

3. **Preserve Component Interface**
   - Don't add methods that break the interface

4. **Consider Order of Decoration**
   - Order matters when combining decorators

5. **Don't Overuse**
   - Too many decorators can make code hard to understand

## Testing

```java
// Easy to test decorators independently
Component component = new ConcreteComponent();
Component decorated = new ConcreteDecorator(component);

// Test component alone
component.operation();

// Test decorator behavior
decorated.operation();
```

## Java I/O Example

```java
// Real-world example from Java
BufferedReader reader = new BufferedReader(
    new FileReader("file.txt")
);

// FileReader is the component
// BufferedReader is the decorator adding buffering
```

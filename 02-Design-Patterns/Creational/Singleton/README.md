# Singleton Pattern

## Intent
Ensure a class has only one instance and provide a global point of access to it.

## Motivation
Sometimes we need to ensure that a class has exactly one instance. For example:
- Database connections
- Configuration managers
- Logger instances
- Thread pools
- Cache

## Structure

```
┌─────────────────┐
│   Singleton     │
├─────────────────┤
│ - instance      │
├─────────────────┤
│ + getInstance() │
│ - Singleton()   │
└─────────────────┘
```

## Implementation Types

### 1. Eager Initialization
Instance is created at class loading time.

### 2. Lazy Initialization
Instance is created when first requested.

### 3. Thread-Safe Singleton
Handles concurrent access properly.

### 4. Bill Pugh Singleton (Recommended)
Uses inner static helper class.

## Advantages
- Controlled access to sole instance
- Reduced namespace pollution
- Permits refinement of operations and representation
- Lazy initialization possible

## Disadvantages
- Can be difficult to test
- Violates Single Responsibility Principle
- Can mask bad design (too many dependencies)
- Requires special treatment in multithreaded environment

## When to Use
- Exactly one instance of a class is required
- Controlled access to a shared resource is needed
- Global variable is needed but should be encapsulated

## When Not to Use
- When you might need multiple instances in the future
- In unit testing scenarios (hard to mock)
- When it becomes a global state manager

## Related Patterns
- Abstract Factory
- Builder
- Prototype patterns can use Singleton

# Observer Pattern

## Intent
Define a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

## Also Known As
- Publish-Subscribe
- Dependents

## Motivation
A common requirement is to maintain consistency between related objects without making them tightly coupled. The Observer pattern solves this by allowing objects to be notified of changes without knowing the details of the observers.

## Problem
When one object's state changes, other objects need to be updated, but:
- You don't want to tightly couple these objects
- The number of dependent objects is unknown or changes dynamically
- You want to add/remove dependencies at runtime

## Solution
Define a Subject (Observable) that maintains a list of Observers and notifies them of state changes.

## Structure

```
┌─────────────┐         ┌──────────────┐
│   Subject   │◇────────│   Observer   │
├─────────────┤         ├──────────────┤
│+attach()    │         │+update()     │
│+detach()    │         └──────────────┘
│+notify()    │                △
└─────────────┘                │
       △                       │
       │                 ┌─────┴─────┐
┌──────────────┐        │           │
│ConcreteSubject│   ┌────────┐ ┌────────┐
├──────────────┤   │Observer│ │Observer│
│-state        │   │   A    │ │   B    │
│+getState()   │   └────────┘ └────────┘
│+setState()   │
└──────────────┘
```

## Participants

1. **Subject (Observable)**
   - Maintains list of observers
   - Provides interface to attach/detach observers
   - Notifies observers of state changes

2. **Observer**
   - Defines an updating interface for objects that should be notified

3. **ConcreteSubject**
   - Stores state
   - Sends notifications to observers when state changes

4. **ConcreteObserver**
   - Maintains reference to ConcreteSubject
   - Implements update interface to keep state consistent

## Advantages
- Loose coupling between Subject and Observers
- Open/Closed Principle - can add new observers without modifying subject
- Dynamic relationships - can add/remove observers at runtime
- Broadcast communication

## Disadvantages
- Unexpected updates - observers don't know about each other
- Memory leaks if observers aren't properly detached
- Can cause performance issues with many observers
- Complex update order dependencies

## When to Use
- When change to one object requires changing others
- When object should notify others without knowing who they are
- When you need a publish-subscribe mechanism
- When you want loose coupling between objects

## Real-World Examples
- Event handling systems (GUI)
- Social media notifications (followers get updates)
- Stock market monitoring (investors watch stock prices)
- Weather monitoring (display devices watch weather station)
- Newsletter subscriptions
- MVC architecture (Model notifies View of changes)

## Related Patterns
- Mediator - centralizes communication
- Singleton - Subject often implemented as Singleton
- Chain of Responsibility - similar notification mechanism

## Implementation Considerations

### Push Model
Subject pushes data to observers with the notification.

### Pull Model
Observers pull data from subject after receiving notification.

### Which to Use?
- Push: When observers need all the data
- Pull: When observers need different data or selective updates

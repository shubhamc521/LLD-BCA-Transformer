# Open/Closed Principle

Software entities (classes, Modules, Functions) are open for extension but closed for modification.

## 
- Extension : Adding new behavior or feature
- Modification : changing existing code

OCP supports extension but not modification.

DiscountCalculator

```java
public class Customer {
    private final boolean employee;
    private final boolean birthday;
    private final boolean student;

    public Customer(boolean employee, boolean birthday, boolean student) {
        this.employee = employee;
        this.birthday = birthday;
        this.student = student;
    }

    public boolean isEmployee() {
        return employee;
    }

    public boolean isbirthday() {
        return birthday;
    }

    public boolean isStudent() {
        return student;
    }
}
```
BADCODE
```java
public class DiscountCalculator{
    private double total;

    public DiscountCalculator(double total){
        this.total = total;
    }

    public double calculate(Customer c){

        if(c.isEmployee())
        {
            return total * 0.8; // 20% off
        }
        if(c.isbirthday())
        {
            return total * 0.9; // 10% off
        }

        // // Extend it for student // Here to extent the functionality we modified the class
        // // That Violates OCP.
        // if(c.isStudent())
        // {
        //     return total * 0.9; // 10% off
        // }
    return total;
    }
}
```

Extend this for giving student discount.

# Good Code Approch

Interface: An Interface a contract that list few methods and signature that should be implemented by child classes.





GOODCODE
```java

public interface DiscountStrategy {
    double apply(double total);
}

public class EmployeeDiscount implements DiscountStrategy{
    @Override
    public double apply(double total){
        return total * 0.8; // 20% off
    }
}

public class BirthdayDiscount implements DiscountStrategy{
    @Override
    public double apply(double total){
        return total * 0.9; // 10% off
    }
}

public class StudentDiscount implements DiscountStrategy{
    @Override
    public double apply(double total){
        return total * 0.5; // 5% off
    }
}

public class DiwaliDiscount implements DiscountStrategy{
    @Override
    public double apply(double total){
        return total * 0.5; // 5% off
    }
}


public class DiscountCalculator {
    private DiscountStrategy strategy;

    public DiscountCalculator(DiscountStrategy strategy){
        this.strategy = strategy;
    }

    public double calculate (double total){
        return strategy.apply(total);
    }
}
public class DemoDiscount{
    public static void main(String args[]){
        double total = 100;
        DiscountCalculator customer1 = new DiscountCalculator(new EmployeeDiscount());
        System.out.println(customer1.calculate(total));

        DiscountCalculator customer2 = new DiscountCalculator(new StudentDiscount());
        System.out.println(customer2.calculate(total));

    }
}








```
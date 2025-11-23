# Single Responsibility Principle

A class or module should have one and only reason to change. 
Should have only one reponsibility.

Class - Blueprint for objects, Groups data members (fields) and functions (behaviors).
Method - A functions
Module/Component - A file or package containing related classes.



Order - adding items, total, stores data (persist data), Output

BADCODE
```java

//Business Logic // Same domain
public class Order{
    private List<String> items;

    public Order(){
        this.items = new ArrayList<>();
    }

    public addItems(String item){
        items.add(item);
    }

    public double calculateTotal() {
        double total = 0.0;
        for (String item : items){
            total += 10.0;
        }
        return total;
    }

    //Storing Items
    public void saveToDatabase(){
        // logic to push the data into database
        System.out.println("INSERT INTO ORDERS")
    }
    //Output the data
    public String toJson(){
        System.out.println("Items : Price , Total = 0000, Order Successful")
    }

    public static void main(String[] args){
        Order o = new Order();
        o.additems("apple");
        o.additems("Brinjal");
        System.out.println(o.toJson());
        o.saveToDatabase();
    }

}
```
Responsibilities : Calculating, Saving, Formating/Outputting the data

## Refactor it to have single responsibility

Split the responsibilities into classes with single focus.

GOODCODE
```java
public class Order{
    private List<String> items;

    public Order(){
        this.items = new ArrayList<>();
    }

    public addItems(String item){
        items.add(item);
    }

    public double calculateTotal() {
        double total = 0.0;
        for (String item : items){
            total += 10.0;
        }
        return total;
    }
}
public class OrderRepo {
    public void saveToDatabase(){
        // logic to push the data into database
        System.out.println("INSERT INTO ORDERS")
    }
}

public class OrderSerialization{ //OrderOutput  
    public String toJson(){
        System.out.println("{ Items : Price , Total = 0000, Order Successful}")
    }
}   

```



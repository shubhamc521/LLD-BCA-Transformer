# Inteface Segregation Principle

## One Liner
Client Should not be foreced to depend upon interfaces they do not use.

- Interface: a contract that list methods a class must provide.

- Split interfaces into smaller, role focused interfaced.

# Bad Code

```java

public interface Machine {
    void print(Document d);
    void scan(Document d);
    void fax(Document d);
}

// Old Printer - Printer only prints.
public class OldPrinter implements Machine{
    @Override
    public void print(Document d){
        SOP("Printing.....");
    }
 
    @Override
    public void scan(Document d){
        thow new UnsupportedOperationException("Scan not supported");
    }

    @Override
    public void fax(Document d){
        thow new UnsupportedOperationException("Fax not supported");
    }
}

// Client code
public print PrintDemo{
    public static void main(String[] args){
        Machine p = new OldPrinter();
        p.print(new Document("Hello"));

        // p.scan(....) would throw 
     }
}
```

- Developers are not happy as they need to implement irrelavent methods.
- Whenever he calls scan/fax he will get an exception

# Good Code

```java
//Small interfaces
public interface Printer {
    void print(Document d);
}

public interface Scanner {
    void scan(Document d);
}

public interface Fax {
    void fax(Document d);
}

public class OldPrinter implements Printer{
    @Override
    public void print(Document d){
        SOP("Printing.....");
    }
}

public class AllInOnePrinter implements Printer, Scanner, Fax{
    @Override
    public void print(Document d){
        SOP("Printing.....");
    }
 
    @Override
    public void scan(Document d){
        SOP("Scanning.....");
    }

    @Override
    public void fax(Document d){
        SOP("Fax .........");
    }
}

// public class clientPrinter{
//     private Printer printer;

//     public ClientPrinter(Printer p ){
//         this.printer = p;
//     }

//     public void doPirnt(String text)
//         {
//             printer.print(new Document d)
//         }
// }



// Client code
public print PrintDemo{
    public static void main(String[] args){
        Printer p = new OldPrinter();
        p.print(new Document("Hello"));
        // p.scan thows exception

        AllInOnePrinter aip = new AllInOnePrinter();
        aip.print();
        aip.scan();
        aip.fax();
     }
}



```
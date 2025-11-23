# Dependency Injection Principle

# One Liner
- High Level Module should not be dependent on low level modules; both should depend on abstraction.

- Abstraction should not depend on details - details should depend on abstraction

# Bad Code

```java

// Gmailer 
public class Gmailer{
    public void send(String to, String body){
        System.out.println("Sending mail to " + to + ": " + body)
    }
}

public class AuthService(){
    private Gmailer mailer = new Gmailer(); 

    public void register(String email){
        mailer.send(email, "Welcome");
    }
}
```
Change the mail provider to zoho mail here.

# Refactor 
- GOOD Example

```java
public interface Mailer{
    void send(String to, String body);
}

public class Gmailer implements Mailer {
    @Override
    void send(String to, String body){
        SOP("Gmail sent to .....");
    }

}
// Zoho mail

public class AuthService{
    private Mailer mailer;

    //Constructor injection
    public AuthService(Mailer mailer){
        this.mailer = mailer;
    }

    public void register(String email){
        mailer.send(email, "Welcome");
    }
}

public class DemoAuth{
    public static void main(String[] args){
        Mailer gmail = new Gmailer();
        AuthService svc = new AuthService(gmail);
        svc.register("alice@gmail.com");
    }
}






```
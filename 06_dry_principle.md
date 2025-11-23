# DRY - Don't repeat yourself

## ONE Liner
- Avoid duplecating code or logic
- Every Piece of knowledge should have a single, uambigous representation in your code.


# Bad Example

```java
public class UserService{
    public boolean isValidEmail(String email){
        return email.contains("@") && email.contains(".com") //&& email.contains("gmail");
    }
}

public class RegistrationService{
    public boolean isValidEmail(String email){
        return email.contains("@") && email.contains(".com");
    }
}
```
# Good Example
```java
public class ValidationUtils {
    public static boolean isValidEmail(String email){
        return email.contains("@") && email.contains(".com");
    }
}

public class UserService{
    public boolean isValidEmail(String email){
        return ValidationUtils.isValidEmail(email);
    }
}

public class RegistrationService{
    public boolean isValidEmail(String email){
        return ValidationUtils.isValidEmail(email);
    }
}


```
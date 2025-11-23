# Liskov Substitution Principle (LSP)

Subtypes can be substitutable for their bastypes without altering any program.

Subclass can be substitutable for their baseclass without altering any program.

```java

// Base Class: BankAcount that allows deposit and withdraw.

public class BankAccount {
    private double accountBal;

    public BankAcount (double initialBal){
        this.accountBal = initialBal;
    }

    public void deposit(double depositAmount )
    {
        accountBal += depositAmount;
    }

    public void withdraw(double withdrawAmount )
    {
        accountBal -= withdrawAmount;
    }

    public double getBalance(){
        return accountBalance;
    }
}

public class SavingAccount extends BankAccount{
    public SavingAccount(double initialBal){
        super(initialBalance);
    }
    
    // Deposit method

    // Withdraw Method

    //getbal
}

public class CurrentAccount extends BankAccount{
    public CurrentAccount(double initialBal){
        super(initialBalance);
    }
    
    // Deposit method

    // Withdraw Method

    // getbal
}

public class FixedAccount extends BankAccount{
    public FixedAccount(double initialBal){
        super(initialBalance);
    }
    
    // Deposit method

    // -------------Not Withdraw method as we cannot withdraw money from fixedDeposit account.

    //getbal
}

```
Client ---> for(List of BankAccounts[Saving, Saving, Fixed, current]) //This bank ac contains all three types of ac i.e Saving Current and fixed.
            {
                bankac1.deposit(10);
                bankac1.withdraw(10); // Wheneve the bankac1 will be of fixed type this will not work as fixedac doent have withdraw.
                bankac1.getBal();
            }

Whatever the base class can do, child class should do that minimum.

```java
public class BankAccount {
    private double accountBal;

    public BankAcount (double initialBal){
        this.accountBal = initialBal;
    }

    public void deposit(double depositAmount )
    {
        accountBal += depositAmount;
    }

    public double getBalance(){
        return accountBalance;
    }
}

public class SavingAccount extends BankAccount{
    public SavingAccount(double initialBal){
        super(initialBalance);
    }
    
    // Deposit method

    // Withdraw Method

    //getbal
}

public class CurrentAccount extends BankAccount{
    public CurrentAccount(double initialBal){
        super(initialBalance);
    }
    
    // Deposit method

    // Withdraw Method

    //getbal
}

public class FixedAccount extends BankAccount{
    public FixedAccount(double initialBal){
        super(initialBalance);
    }
    
    // Deposit method

    //getbal
}

```

WithdrawAccount --> Saving and Current

NonwithDrawAccoujnt --> FixedDeposit

Client checks ---> If its a withdrawAccount or nonWithdrawAc.





Animal 
    -Eat
    -Sleep
    -Fly //Remove  

Birth 
    - Eat
    - Sleep
    - FLY

Human
    - Eat
    - Sleeps
    - FLY - Throw exception. //

Animal a : 
Human h 





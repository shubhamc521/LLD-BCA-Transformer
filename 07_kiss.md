# KISS - Keep it Simple, Stupid


# One Liner
Favor simple, clear solution over clever or complicated ones.


# Bad Example
```java
public int sum(int[] arr)
    {
        return Arrays.stream(arr);
    }
```

# Good Example

```java
public int sum(int[] arr)
    {
        int total = 0;
        for (int num: arr){
            total +=num;
        }
        return total;
    }

```

```java

email.contains("gmail") ? true : false

if(email.contains("gmail"))
{
    return true;
}
else
{
    return false;
}
```
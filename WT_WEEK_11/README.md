## Code Walkthrough

- Open `IntelliJ IDEA`
- Create a new `Java` Project and name it as `Unit Test`
- Create a new `Java` file i.e. `MyUnit.java` and add the below code.

```java
public class MyUnit {
  public String stringConcat(String s1, String s2) {
    return (s1 + s2);
  }
}
```

- Create a new `Java` file i.e. `MyUnitTest.java` and add the below code.

```java
import org.junit.Assert;
import org.junit.Test;

public class MyUnitTest {
    @Test
    public void testConcater() {
        MyUnit unit = new MyUnit();
        String result = unit.stringConcat("uno", "dos");
        Assert.assertEquals("unodos", result);
    }

    @Test
    public void testFailConcater() {
        MyUnit unit = new MyUnit();
        String result = unit.stringConcat("uno", "dos");
        Assert.assertEquals("vidhan", result);
    }
}
```

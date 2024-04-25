> MyUnit.java

```java
public class MyUnit {
  public String stringConcat(String s1, String s2) {
    retrun (s1 + s2);
  }
}
```

> MyUnitTest.java

```java
import org.junit.Assert;
import org.junit.Test;

public class MyUnitTest {
    @Test
    public void testConcater() {
        MyUnit unit = new MyUnit();
        String result = unit.concater("uno", "dos");
        Assert.assertEquals("unodos", result);
    }
}

```

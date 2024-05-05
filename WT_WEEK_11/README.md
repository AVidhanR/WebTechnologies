### Make sure to have...

- MySQL Community Server (comes with MySQLWorkbench) - [`download here`](https://dev.mysql.com/downloads/file/?id=526408)
- Tomcat 10.1 - [`download here`](https://dlcdn.apache.org/tomcat/tomcat-10/v10.1.23/bin/apache-tomcat-10.1.23.exe)
- IntelliJ IDEA - [`download here`](https://www.jetbrains.com/idea/download/download-thanks.html?platform=windows&code=IIC)
- mysql-connector-j-8.3.0.jar file - [`download here`](https://dev.mysql.com/downloads/file/?id=525082)

---

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

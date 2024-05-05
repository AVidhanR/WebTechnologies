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
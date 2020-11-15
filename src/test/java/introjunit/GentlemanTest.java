package introjunit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GentlemanTest {

    @Test
    public void testByNormalName() {
        String name = "John Doe";

        String üdvözlés = new Gentleman().sayHello(name);

        assertEquals("Hello John Doe", üdvözlés);
    }

    @Test
    public void testbynullName() {
        String name = null;

        String üdvözlés = new Gentleman().sayHello(name);

        assertEquals("Hello Anonymus", üdvözlés);
    }

}

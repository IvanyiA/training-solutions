package week06d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BiscuitTest {
    @Test
    public void testToSting(){
        assertEquals("Type: HIT, amount: 100g", Biscuit.of(BiscuitType.HIT, 100).toString());
    }
}
package stringbasic.stringbasic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCreatorTest {

    @Test
    public void sameThingsInPoolShouldBeTheSameObject() {
        StringCreator sc = new StringCreator();

        assertTrue(sc.createStringForPool() == sc.createStringForPool());
        assertFalse(sc.createStringForHeap() == sc.createStringForHeap());
        assertTrue(sc.createStringForHeap().equals(sc.createStringForPool()));

    }

    @Test
    public void SameStringsShouldBeTheSameByCanonicalRepresentation (){
        StringCreator sc = new StringCreator();

        assertTrue(sc.createStringForHeap().intern()==sc.createStringForHeap().intern());
        assertTrue(sc.createStringForHeap().intern()==sc.createStringForPool().intern());
    }

}
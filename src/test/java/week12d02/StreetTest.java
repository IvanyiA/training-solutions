package week12d02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class StreetTest {

    private Street street;

    @BeforeEach
    void setUp() {

        street = new Street();
        street.sellSite(new Site(0, 10, Fence.PERFECT));
        street.sellSite(new Site(0, 7, Fence.NEED_UPGRADE));

    }

    @Test
    public void numberOfLastSoldSiteTest() {
        assertEquals(4, street.lastSell());
    }
}
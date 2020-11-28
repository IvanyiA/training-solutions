package week05d04;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    @Test
    public void addProductTest() {
        List<Product> testList = new ArrayList<>();
        Store store = new Store(testList);

        assertFalse(store.addProduct(new Product("milk", 2020, 11, 24)));

        assertTrue(store.addProduct(new Product("milk", 2020, 11, 28)));
        assertFalse(store.addProduct(new Product("milk", 2020, 11, 29)));
    }

    @Test
    public void getNumberOfExpiredTest() {
        List<Product> testList = new ArrayList<>();
        testList.add(new Product("milk", 2020, 01, 03));
        Store store = new Store(testList);

        assertEquals(1, store.getNumberOfExpired());
    }


}
package week06d02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    @Test
    public void getProductByCategoryNameTest() {
        Store store = new Store(Arrays.asList(
                new Product("kifli", Category.BAKEDGOODS, 20),
                new Product("zsömle", Category.BAKEDGOODS, 25),
                new Product("tej", Category.DAIRY, 199),
                new Product("joghurt", Category.DAIRY, 150),
                new Product("kasza", Category.OTHER, 233)
        ));

        assertEquals(2, store.getProductByCategoryName(Category.BAKEDGOODS));
        assertEquals(1, store.getProductByCategoryName(Category.OTHER));
    }

}
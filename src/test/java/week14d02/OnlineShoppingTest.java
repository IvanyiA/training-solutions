package week14d02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OnlineShoppingTest {

    OnlineShopping onlineShopping = new OnlineShopping();
    Path file = Path.of("src/main/java/week14d02/orderedItems.txt");

    @BeforeEach
    void setUp() {
        onlineShopping.readFile(file);
    }

    @Test
    void getProductsById() {
        List<String> result = onlineShopping.getProductsById("A233");
        assertEquals(List.of("bread", "flour", "sugar", "tomato"), result);
    }

    @Test
    void getProductsReversedById() {
        List<String> resultReverse = onlineShopping.getProductsReversedById("A312");
        assertEquals(List.of("sugar", "pear", "beer", "apple"), resultReverse);
    }

    @Test
    void getNUmberOfProductSold() {
        int resultCount = onlineShopping.getNUmberOfProductSold("rosemary");
        assertEquals(2, resultCount);
    }

    @Test
    void getNumberOfProductsById() {

        int listSize = onlineShopping.getNumberOfProductsById("A312");
        assertEquals(4, listSize);
    }

    @Test
    void shoppingListStatistics() {

        Map<String, Integer> resultMap = onlineShopping.shoppingListStatistics();
        assertEquals(2, resultMap.get("rosemary").intValue());

    }
}
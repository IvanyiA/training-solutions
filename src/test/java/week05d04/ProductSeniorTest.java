package week05d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductSeniorTest {

    @Test
    void convertPrice() {

        ProductSenior productSenior = new ProductSenior(600, Currency.HUF);

        assertEquals(2, productSenior.convertPrice(Currency.USD));


    }
}
package week06d02;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoreSeniorTest {

    @Test
    void getProductsByCategory() {

        List<Product> products = new ArrayList<>();
        StoreSenior storeSenior = new StoreSenior(products);
        products.add(new Product("tej", Category.DAIRY, 150) );

        assertEquals("Fagyasztott áru: 0 db. Tejtermék: 1 db. Pékáru 0 db. Egyéb: 0 db.", storeSenior.getProductsByCategory());
    }
}
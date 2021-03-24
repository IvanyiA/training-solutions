package week07d04;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingListTest {

    @Test
    void testSum() throws IOException {
        // hogyan lehet lekérdezni az aktuális könyvtárat? a pont az aktuális könyvtár relatív elérési útvonala
        //ezt konvertálja a toRealPath abszolút útvonallá
        System.out.println(Path.of(".").toRealPath());
        //kiírja, hogy hol keres, itt mivel nincs perjel , az tehát a relatív útvonalként van megadva a projekt gyökere a fix pont C:\Users\CFY\training\training-solutions\ alma\korte\beka.txt
//        Path path = Path.of("alma/korte/beka.txt");
//        path.toRealPath();
        //ha az elején van egy perjel, akkor az már nem relatív, hanem abszolút elérési útvonal lesz C:/alma...
//        Path path = Path.of("alma/korte/beka.txt");
//        path.toRealPath();

        ShoppingList shoppingList = new ShoppingList();
        // a projekt gyökerétől kell megadni a String path-t blackslash\\ csak Windows-on jó
        // ha az elején nincs perjel akkor az adott gyökérkönyvtárból kezdi a keresést
        long result = shoppingList.calculateSum("src\\test\\resources\\week07d04\\list.csv");
        // relatív út
        assertEquals(70, result);
    }
}
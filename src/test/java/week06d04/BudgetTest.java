package week06d04;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BudgetTest {

    private Budget budget = new Budget(Arrays.asList(
            new Item(1200, 2020, 11, 3, "fogkefe"),
            new Item(2222, 2020, 3, 4, "fogkrém"),
            new Item(999, 2020, 1, 1, "türülköző")
    ));

    @Test
    public void getItemsByMonthTest() {

        List<Item> result = budget.getItemsByMonth(11);

        assertEquals(1, result.size());
        assertEquals("fogkefe", result.get(0).getName());
    }


}
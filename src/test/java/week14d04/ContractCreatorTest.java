package week14d04;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContractCreatorTest {

    @Test
    public void testCreateSpecificContract() {
        ContractCreator contractCreator = new ContractCreator("John Doe", new ArrayList<>(List.of(1, 2, 3, 4, 5)));
        Contract contract1 = contractCreator.createSpecificContract("Jack Doe");
        Contract contract2 = contractCreator.createSpecificContract("Jane Doe");

        assertEquals(2, contract2.getMonthlyPrices().get(1));

        contract1.getMonthlyPrices().set(0,20);
        assertEquals(20, contract1.getMonthlyPrices().get(0));

    }

}
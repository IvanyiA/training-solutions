package week14d04;

import java.util.ArrayList;
import java.util.List;

public class ContractCreator {

    private final Contract defaultTemplate;

    public ContractCreator(String clientName, List<Integer> monthlyPrices) {
        defaultTemplate = new Contract(clientName, monthlyPrices);    // itt is be lehetett volna vezetni az AL kopikonstruktort !!!
    }

    public Contract createSpecificContract(String client) {
        return new Contract(client, new ArrayList<>(defaultTemplate.getMonthlyPrices()));    // új objektum, kopi konstruktorában ÚJ listát hozunk létre minden egyes névhez külön, visszahatás nélkül
    }

    public static void main(String[] args) {
        ContractCreator contractCreator = new ContractCreator("név", new ArrayList<>(List.of(10, 10, 10)));
        Contract contract1 = contractCreator.createSpecificContract("John Doe");
        Contract contract2 = contractCreator.createSpecificContract("Jack Doe");
        System.out.println(contract1);
        System.out.println(contract2);

        contract1.getMonthlyPrices().set(1, 20);
        System.out.println(contract1);
        System.out.println(contract2);

        Contract contract3 = contractCreator.createSpecificContract("Jane Doe");
        System.out.println(contract3);
    }

}


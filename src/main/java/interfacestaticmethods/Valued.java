package interfacestaticmethods;

import java.util.List;

public interface Valued {

    static double totalValue(List<Valued> products) {
        double result = 0;
        for (Valued product: products){
            result += product.getValue();
        }
        return result;
    }

    double getValue();
}

package week05d04;

import java.util.ArrayList;
import java.util.List;

public class Store {

    public Store(List<Product> products) {
        this.products = products;
    }

    List<Product> products = new ArrayList<>();

    private boolean containsByName(Product waitingProduct) {
        for (Product p : products) {
            if (p.getName().equals(waitingProduct.getName())) {
                return true;
            }
        }
        return false;
    }

    private boolean isValid(Product waitingProduct) {
        if (containsByName(waitingProduct) || waitingProduct.isExpired()) {
            return false;
        }
        return true;
    }

    public boolean addProduct(Product waitingProduct) {
        if (!isValid(waitingProduct)) {
            return false;
        }
        products.add(waitingProduct);
        return true;
    }

    public int getNumberOfExpired() {
        int count = 0;
        for (Product p : products) {
            if (p.isExpired()) {
                count++;
            }
        }
        return count;
    }
}



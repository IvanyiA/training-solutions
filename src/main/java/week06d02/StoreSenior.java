package week06d02;

import week05d04.ProductSenior;

import java.util.List;

public class StoreSenior {

    private final List<Product> products;


    public StoreSenior(List<Product> products) {
        this.products = products;
    }

    public String getProductsByCategory() {
        int frozen = 0;
        int dairy = 0;
        int bakedgoods = 0;
        int other = 0;
        for (Product item : products) {
            if (item.getCategory() == Category.FROZEN) {
                frozen++;
            } else if (item.getCategory().equals(Category.DAIRY)) {
                dairy++;
            } else if (item.getCategory() == Category.BAKEDGOODS) {
                bakedgoods++;
            } else if (item.getCategory().equals(Category.OTHER)) {
                other++;
            }
        }
        ProductSeniorResult productSeniorResult =
                new ProductSeniorResult(frozen, dairy, bakedgoods, other);

        return productSeniorResult.toString();
    }
}

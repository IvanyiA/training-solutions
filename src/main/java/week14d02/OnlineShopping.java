package week14d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class OnlineShopping {

    private Map<String, List<String>> shoppingList = new LinkedHashMap<>();

    public void readFile(Path path) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(path))
//        (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(week14d02.OnlineShopping.class.getResourceAsStream("orderedItems.txt"))
        { String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(" ");
                String[] products = parts[1].split(",");
                List<String> productsValue = new ArrayList<>();
//                for (String product : products) {
//                    productsValue.add(product);
                productsValue.addAll(Arrays.asList(products));
                shoppingList.put(parts[0], productsValue);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file.", e);
        }
    }

    public List<String> getProductsById(String id) {
        List<String> productsValue = new ArrayList<>(shoppingList.get(id));
        Collections.sort(productsValue);
        return productsValue;
    }

    public List<String> getProductsReversedById(String id) {
        List<String> productsValue = getProductsById(id);
        Collections.reverse(productsValue);
        return productsValue;
    }

    public int getNUmberOfProductSold(String product) {
        int count = 0;
        Collection<List<String>> values = shoppingList.values();
        for (List<String> value : values) {
            for (String soldProduct : value) {
                if (soldProduct.equals(product)) {
                    count++;
                }
            }
        }
        return count;
    }

    public int getNumberOfProductsById(String id) {
        return shoppingList.get(id).size();
    }

    public Map<String, Integer> shoppingListStatistics() {
        Map<String, Integer> result = new HashMap<>();
        for (List<String> valuesCollection : shoppingList.values()) {
            for (String product : valuesCollection) {
                int count = getNUmberOfProductSold(product);
                result.put(product, count);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        OnlineShopping onlineShopping = new OnlineShopping();
        onlineShopping.readFile(Path.of("src/main/resources/orderedItems.txt"));

        List<String> result = onlineShopping.getProductsById("A312");
        System.out.println(result);

        List<String> resultReverse = onlineShopping.getProductsReversedById("A312");
        System.out.println(resultReverse);

        int resultCount = onlineShopping.getNUmberOfProductSold("tomato");
        System.out.println(resultCount);

        int sizeList = onlineShopping.getNumberOfProductsById("A312");
        System.out.println(sizeList);

        Map<String, Integer> resultMap = onlineShopping.shoppingListStatistics();
        System.out.println(resultMap);

    }

}


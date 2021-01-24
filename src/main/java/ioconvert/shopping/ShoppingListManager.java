package ioconvert.shopping;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingListManager {


    public void saveShoppingList(OutputStream os, List<String> shoppingList) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os))) {
            for (String product : shoppingList) {
                bufferedWriter.write(product);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write file.", e);
        }
    }


    public List<String> loadShoppingList(InputStream is) {
        List<String> shoppingList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                shoppingList.add(line);
            }
            return shoppingList;
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file.", e);
        }
    }
}



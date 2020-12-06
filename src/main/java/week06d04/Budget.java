package week06d04;

import java.util.ArrayList;
import java.util.List;

public class Budget {

    private List<Item> items;

    public Budget(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItemsByMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month.");
        }
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getDate().getMonthValue() == month) {
                result.add(item);
            }
        }
        return result;
    }
}

package week06d04;

import java.time.LocalDate;

public class Item {

    private int price;
    private LocalDate date;
    private String name;
    private int month;

    public Item(int price, int year, int month, int day, String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0.");
        }
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month.");
        }

        this.price = price;
        this.name = name;
        date = LocalDate.of(year, month, day);
    }

    public Item(int price, LocalDate date, String name){
        this.price=price;
        this.date=date;
        this.name=name;
    }


    public Item(int price, String name, int month) {
        this.price = price;
        this.name = name;
        this.month = month;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getPrice() {
        return price;
    }

    public int getMonth() {
        return month;
    }


}

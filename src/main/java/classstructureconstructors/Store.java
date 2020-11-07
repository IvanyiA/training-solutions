package classstructureconstructors;

public class Store {

    private String product;

    private int stock;

    public Store(String termek) {
        this.product = termek;
        stock = 0;
    }

    public void raktarbaBe(int darab) {
        stock = stock + darab;
    }

    public void raktarbolEl(int darab) {
        stock = stock - darab;
    }

    public String getProduct() {
        return product;
    }

    public int getStock() {
        return stock;
    }
}

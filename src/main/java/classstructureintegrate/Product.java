package classstructureintegrate;

public class Product {

    String name;

    int price;

    public Product(String nev, int ar) {
        this.name = nev;
        this.price = ar;
    }

    public void arNovekedes(int ft){
        price = price + ft;
    }

    public void arCsokkenes(int ft){
        price = price - ft;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

}

package classstructureconstructors;

public class StoreMain {
    public static void main(String[] args) {
        Store lampaRaktar = new Store("lámpa");
        lampaRaktar.raktarbaBe(10);
        System.out.println(lampaRaktar.getProduct() + ": " + lampaRaktar.getStock());

        Store szappanRaktar = new Store("Szappan");
        szappanRaktar.raktarbaBe(7);
        System.out.println(szappanRaktar.getProduct() + ": " + szappanRaktar.getStock());

        lampaRaktar.raktarbaBe(22);
        szappanRaktar.raktarbolEl(7);

        System.out.println(lampaRaktar.getProduct() + ": " + lampaRaktar.getStock());
        System.out.println(szappanRaktar.getProduct() + ": " + szappanRaktar.getStock());
    }
}


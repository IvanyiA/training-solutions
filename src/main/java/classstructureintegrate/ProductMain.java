package classstructureintegrate;

import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {
        Scanner szkenner = new Scanner(System.in);
        System.out.println("Mi a termék neve?");
        String termekNev = szkenner.nextLine();

        System.out.println("Mennyibe kerül?");
        int mennyibeKerul = szkenner.nextInt();

        Product termek = new Product(termekNev, mennyibeKerul);
        System.out.println(termek.getName() + ": " + termek.getPrice());

        termek.arNovekedes(18);
        System.out.println(termek.getName() + ": " + termek.getPrice());
        termek.arCsokkenes(1);
        System.out.println(termek.getName() + ": " + termek.getPrice());


    }
}

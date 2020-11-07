package classstructureattributes;

import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        Scanner szkenner = new Scanner(System.in);
        Client ugyfelszolgalat = new Client();

        System.out.println("Név: ");
        ugyfelszolgalat.name = szkenner.nextLine();

        System.out.println("Születési év: ");
        ugyfelszolgalat.year = szkenner.nextInt();
        ugyfelszolgalat.address = szkenner.nextLine();

        System.out.println("cím: ");
        ugyfelszolgalat.address = szkenner.nextLine();

        System.out.println("Név: " + ugyfelszolgalat.name);
        System.out.println("Születési év: " + ugyfelszolgalat.year);
        System.out.println("cím: " + ugyfelszolgalat.address);
    }
}

package classstructureattributes;

import java.util.Scanner;

public class Music {
    public static void main(String[] args) {
        Scanner szkenner = new Scanner(System.in);
        Song dal = new Song();
        System.out.println("Kedvenc előadó: ");
        dal.band = szkenner.nextLine();
        System.out.println("Kedvenc dalod címe: ");
        dal.title = szkenner.nextLine();
        System.out.println("Dal hossza percben: ");
        dal.length = szkenner.nextInt();

        System.out.println(dal.band + " - " + dal.title + " (" + dal.length + ") perc");


    }
}

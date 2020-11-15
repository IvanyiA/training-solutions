package numbers;

import java.util.Scanner;
import java.util.concurrent.Callable;

public class CircleMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Első kör átmérője: ");
        int átmérő1 = scanner.nextInt();
        Circle kör1 = new Circle(átmérő1);

        System.out.println("Második kör átmérője: ");
        int átmérő2 = scanner.nextInt();
        Circle kör2 = new Circle(átmérő2);

        System.out.println("1. kör kerülete: " + kör1.kerületKör());
        System.out.println("1. kör területe: " + kör1.területKör());
        System.out.println("2. kör kerülete: " + kör2.kerületKör());
        System.out.println("2. kör területe: " + kör2.területKör());
    }


}

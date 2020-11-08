package statements;

import java.util.Scanner;

public class TimeMain {
    public static void main(String[] args) {
        Scanner szkenner = new Scanner(System.in);
        System.out.println("1.időpont, óra: ");
        int ora1 = szkenner.nextInt();
        System.out.println("1.időpont, perc: ");
        int perc1 = szkenner.nextInt();
        System.out.println("1.időpont, másodperc: ");
        int masodperc1 = szkenner.nextInt();

        System.out.println("2.időpont, óra: ");
        int ora2 = szkenner.nextInt();
        System.out.println("2.időpont, perc: ");
        int perc2 = szkenner.nextInt();
        System.out.println("2.időpont, másodperc: ");
        int masodperc2 = szkenner.nextInt();

        Time idopont1 = new Time(ora1, perc1, masodperc1);
        Time idopont2 = new Time(ora2, perc2, masodperc2);

        System.out.println("Az első időpont " + idopont1.toString() + " = " + idopont1.getInMinutes() + " perc");
        System.out.println("A második időpont " + idopont2.toString() + " = " + idopont2.getInMinutes() + " másodperc");
        System.out.println("Az első korábbi, mint a második: " + idopont1.earlierThan(idopont2) );

    }
}

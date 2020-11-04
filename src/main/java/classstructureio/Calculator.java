package classstructureio;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner szkenner = new Scanner(System.in);
        System.out.println("Egymás alatt adj meg két egész számot!");
        int szam1 = szkenner.nextInt();
        int szam2 = szkenner.nextInt();
        System.out.println(szam1 + "+" + szam2);
        System.out.println(szam1 + szam2);
    }
}


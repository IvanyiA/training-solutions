package statements;

import java.util.Scanner;

public class DivByThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kérem adjon meg egy egész számot: ");
        int szam = scanner.nextInt();

        System.out.println(szam % 3 == 0 ? "osztható hárommal" : "nem osztató hárommal");
    }
}

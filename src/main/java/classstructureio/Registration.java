package classstructureio;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner regisztracio = new Scanner(System.in);
        System.out.println("Kérem adja meg a nevét!");
        String name = regisztracio.nextLine();
        System.out.println("Kérem adja meg az email címét!");
        String email = regisztracio.nextLine();
        System.out.println("Regisztrációs adatok: " + name + ", " + email);
    }
}

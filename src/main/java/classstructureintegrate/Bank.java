package classstructureintegrate;

import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        Scanner szkenner = new Scanner(System.in);
        System.out.println("Mi az első bankszámla száma?");
        String bankszamlaSzam1 = szkenner.nextLine();
        System.out.println("Ki az első számla tulajdonosa?");
        String tulajdonosNeve1 = szkenner.nextLine();
        System.out.println("Mennyi pénz van az első számlán?");
        int nyitoEgyenleg1 = szkenner.nextInt();
        szkenner.nextLine();
        BankAccount account1 = new BankAccount(bankszamlaSzam1, tulajdonosNeve1, nyitoEgyenleg1);

        System.out.println("Mi a második bankszámla száma?");
        String bankszamlaSzam2 = szkenner.nextLine();
        System.out.println("Ki a második bankszámla tulajdonosa?");
        String tulajdonosNeve2 = szkenner.nextLine();
        System.out.println("Mennyi pénz van a második számlán?");
        int nyitoEgyenleg2 = szkenner.nextInt();
        BankAccount account2 = new BankAccount(bankszamlaSzam2, tulajdonosNeve2, nyitoEgyenleg2);

        System.out.println(account1.getInfo());
        System.out.println(account2.getInfo());

        System.out.println("Mennyit szeretne rárakni az első számlára?");
        int befizetniFt = szkenner.nextInt();
        account1.deposit(befizetniFt);
        System.out.println(account1.getInfo());

        System.out.println("Mennyit szeretne levenni az második számláról?");
        int levenniFt = szkenner.nextInt();
        account2.deposit(levenniFt);
        System.out.println(account2.getInfo());

        System.out.println("Mennyit szeretne az első számláról a másodikra utalni?");
        int atutalniFt = szkenner.nextInt();
        account1.transfer(account2, atutalniFt);

        System.out.println(account1.getInfo());
        System.out.println(account2.getInfo());

    }
}

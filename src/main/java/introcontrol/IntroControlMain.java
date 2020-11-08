package introcontrol;

import jdk.swing.interop.SwingInterOpUtils;

public class IntroControlMain {
    public static void main(String[] args) {
        IntroControl introControl = new IntroControl();
        System.out.println(introControl.substractTenIfGreaterThanTen(11));
        System.out.println(introControl.substractTenIfGreaterThanTen(9));
        System.out.println(introControl.substractTenIfGreaterThanTen(10));

        System.out.println(introControl.describeNumber(10));
        System.out.println(introControl.describeNumber(0));

        System.out.println(introControl.greetingToJoe("Joe"));
        System.out.println(introControl.greetingToJoe("Jane"));

        System.out.println("jutalék:");
        System.out.println(introControl.calculateBonus(10));
        System.out.println(introControl.calculateBonus(5000000));

        System.out.println("Mérőállás különbség: ");
        System.out.println(introControl.calculateConsumption(9000, 400));
        System.out.println(introControl.calculateConsumption(200, 600));

        System.out.println("print numbers until");
        introControl.printNumbers(5);
        introControl.printNumbers(3);

        System.out.println("print numbers between");
        introControl.printNumbersBetween(5,8);
        introControl.printNumbersBetween(2,6);

        System.out.println("print numbers between with direction");
        introControl.printNumbersBetweenAnyDirection(1,10);
        introControl.printNumbersBetweenAnyDirection(7,0);

        System.out.println("print odds numbers");
        introControl.printOddNumbers(8);
        introControl.printOddNumbers(5);


    }

}



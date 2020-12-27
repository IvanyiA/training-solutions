package week02;

import java.util.Scanner;

public class Controller {

    private Office office = new Office();

    public void readOffice() {
        System.out.println("Hány darab tárgyalót szeretne rögzíteni?");
        Scanner scanner = new Scanner(System.in);
        int numberOfMeetingrooms = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfMeetingrooms; i++) {
            System.out.println("Tárgyaló helyiség neve?");
            String name = scanner.nextLine();

            System.out.println("Tárgyaló szélessége méterben?");
            int width = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Tárgyaló hosszúsága méterben?");
            int lenght = scanner.nextInt();
            scanner.nextLine();

            MeetingRoom meetingRoom = new MeetingRoom(name, width, lenght);
            office.addMeetingRoom(meetingRoom);
        }
        printMenu();
    }

    public void printMenu() {
        System.out.println("1. Tárgyalók sorrendben\n" +
                "2. Tárgyalók visszafele sorrendben\n" +
                "3. Minden második tárgyaló\n" +
                "4. Területek\n" +
                "5. Keresés pontos név alapján\n" +
                "6. Keresés névtöredék alapján\n" +
                "7. Keresés terület alapján\n"
        );
    }

    public void runMenu() {
        System.out.println("Melyik menüpontot választod?");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            office.printNames();
        }
        if (choice == 2) {
            office.printNamesReverse();
        }
        if (choice == 3) {
            office.printEvenNames();
        }
        if (choice == 4) {
            office.printAreas();
        }
        if (choice == 5) {
            System.out.println("Tárgyaló neve?");
            String name = scanner.nextLine();
            office.printMeetingRoomsWithName(name);
        }
        if (choice == 6) {
            System.out.println("Névrészlet? ");
            String part = scanner.nextLine();

            office.printMeetingRoomsContains(part);
        }
        if (choice == 7) {
            System.out.println("Tárgyaló terülte minimum (m2)?");
            int area = scanner.nextInt();
            scanner.nextLine();
            office.printAreasLargerThan(area);
        }
    }

    public static void main(String[] args) {
        Controller controller = new Controller();

        controller.readOffice();
        controller.runMenu();


    }


}

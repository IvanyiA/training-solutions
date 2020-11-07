package classstructuremethods;

public class ClientMain {
    public static void main(String[] args) {
        Client ugyfel = new Client();
        ugyfel.setName("Tóth Aladár");
        ugyfel.setYear(1980);
        ugyfel.setAddress("Debrecen");

        System.out.println("Név: " + ugyfel.getName());
        System.out.println("Születési év: " + ugyfel.getYear());
        System.out.println("cím: " + ugyfel.getAddress());

        ugyfel.migrate("Budapest");

        System.out.println("új cím: " + ugyfel.getAddress());
    }
}

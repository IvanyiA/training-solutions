package classstructuremethods;

public class NoteMain {
    public static void main(String[] args) {
        Note jegyzet = new Note();
        jegyzet.setName("Tóth Aladár");
        jegyzet.setTopic("ökológia");
        jegyzet.setText("Az ausztráliai repülő mókusok valójában 4 fajt alkotnak.");

        System.out.println(jegyzet.getNevTemaSzoveg());
    }
}

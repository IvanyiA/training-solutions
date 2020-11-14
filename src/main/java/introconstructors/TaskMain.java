package introconstructors;

public class TaskMain {

    public static void main(String[] args) {
        Task task = new Task("Konstruktorok létrehozása", "gépelés");
        System.out.println("Cím: " + task.getTitle());

        task.start();
        task.setDuration(60);

        System.out.println("Kezdte: "
                + task.getStartDateTime()
                + "Ennyi percet vett igénybe: "
                + task.getDuration());
    }
}

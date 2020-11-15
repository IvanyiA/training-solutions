package intromethods.todo;

import java.util.Arrays;

public class TodoListMain {
    public static void main(String[] args) {
        TodoList tennivalókListája = new TodoList();

        tennivalókListája.adjlistahozTennivalokat("befizetni a számlákat");
        tennivalókListája.adjlistahozTennivalokat("találkozni Edittel");
        tennivalókListája.adjlistahozTennivalokat("tollat venni");
        tennivalókListája.adjlistahozTennivalokat("olvasni");
        tennivalókListája.adjlistahozTennivalokat("takarítani");

        System.out.println(tennivalókListája);

        tennivalókListája.befejezettTennivalók("olvasni");

        System.out.println(tennivalókListája);

        tennivalókListája.többTennivalóBefejezve(Arrays.asList("tollat venni", "olvasni"));

        System.out.println(tennivalókListája.befejezendőTennivalók());
        System.out.println(tennivalókListája.befejezettTennivalókSzáma());

    }
}

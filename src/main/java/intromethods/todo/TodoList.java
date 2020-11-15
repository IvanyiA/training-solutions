package intromethods.todo;

import java.util.ArrayList;
import java.util.List;

public class TodoList {

    private List<Todo> tennivalók = new ArrayList<>();

    public void adjlistahozTennivalokat(String caption) {
        Todo tennivaló = new Todo(caption);
        tennivalók.add(tennivaló);
    }

    public void befejezettTennivalók(String caption) {
        for (Todo tennivaló : tennivalók) {
            if (tennivaló.getCaption().equals(caption)) {
                tennivaló.elvégzett();
            }
        }
    }

    public void többTennivalóBefejezve(List<String> befejezendőTennivalók) {
        for (String befejezendőTennivaló : befejezendőTennivalók) {
            befejezettTennivalók(befejezendőTennivaló);
        }
    }

    public List<String> befejezendőTennivalók() {
        List<String> befejezendőTennivalók = new ArrayList<>();
        for (Todo tennivaló : tennivalók) {
            if (!tennivaló.isFinished()) {
                befejezendőTennivalók.add(tennivaló.getCaption());
            }
        }
        return befejezendőTennivalók;
    }

    public int befejezettTennivalókSzáma() {
        int sum = 0;
        for (Todo tennivaló : tennivalók) {
            if (tennivaló.isFinished()) {
                sum++;
            }
        }
        return sum;
    }

    @Override
    public String toString() {
        return tennivalók.toString();
    }

}

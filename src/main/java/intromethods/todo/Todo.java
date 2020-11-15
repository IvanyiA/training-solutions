package intromethods.todo;

public class Todo {

    private String caption;
    private boolean elvégzett;

    public Todo(String caption) {
        this.caption = caption;
    }

    public String getCaption() {
        return caption;
    }

    public boolean isFinished() {
        return elvégzett;
    }

    public void elvégzett() {
        elvégzett = true;
    }

    @Override
    public String toString() {
        return caption + " (" + (elvégzett ? "kész" : "nincs kész") + ") ";
    }
}

package exam03retake02;

import java.util.*;

public class TodoList {

    List<Todo> todos = new ArrayList<>();

    public void addTodo(Todo todo) {
        todos.add(todo);
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public int getNumberOfItemsLeft() {
        List<Todo> notCompletedTodos = new ArrayList<>();
        for (Todo todo : todos) {
            if (todo.getState().equals(State.NON_COMPLETED)) {
                notCompletedTodos.add(todo);
            }
        }
        return notCompletedTodos.size();
    }

    public List<String> getMostImportantTodosText() {
        List<String> mostImportantTodos = new ArrayList<>();
        todos.sort((o1, o2) -> o1.getPriority() - o2.getPriority());
        Todo minimum = todos.get(0);
        for (Todo todo : todos) {
            if (todo.getPriority() == minimum.getPriority()) {
                mostImportantTodos.add(todo.getText());
            }
        }
        return mostImportantTodos;
    }

    public List<String> getMostImportantTodosText2() {
        int maxPriority = 5;
        List<String> texts = new ArrayList<>();
        for (Todo todo : todos) {
            if (maxPriority > todo.getPriority()) {
                maxPriority = todo.getPriority();
                texts.clear();
                texts.add(todo.getText());
            } else if (maxPriority == todo.getPriority()) {
                texts.add(todo.getText());
            }
        }
        return texts;
    }

    public void deleteCompleted() {
        Iterator<Todo> todoIterator = todos.iterator();
        while (todoIterator.hasNext()) {
            Todo todo = todoIterator.next();
            if (todo.getState().equals(State.COMPLETED)) {
                todoIterator.remove();
            }
        }
    }

    public void deleteCompleted2() {
        List<Todo> toRemove = new ArrayList<>();
        for (Todo todo : todos) {
            if (todo.getState() == State.COMPLETED) {
                toRemove.add(todo);
            }
        }
        todos.removeAll(toRemove);
    }

    public void deleteCompleted3() {
        todos.removeIf(t -> t.getState() == State.COMPLETED);
    }

}

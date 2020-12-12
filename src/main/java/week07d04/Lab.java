package week07d04;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Lab {

    private String title;
    private boolean completed;
    private LocalDate completedAt;

    public Lab(String title) {
        this.title = title;
    }

    public Lab(String title, LocalDate completedAt) {
        this.title = title;
        completed = true;
        this.completedAt = completedAt;

    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public LocalDate getCompletedAt() {
        return completedAt;
    }

    public void complete(LocalDate completedAt) {
        completed = true;
        this.completedAt = completedAt;

    }

    public void complete() {
        completed = true;
        completedAt = LocalDate.now();
    }

    public boolean isTitleLongerThanTwoCharacter() {
        return title != null && title.length() > 2;
    }

    public String titleAndCompleted(String signIfCompleted, String signIfNotCompleted) {
        return title + " " + (completed ? signIfCompleted : signIfNotCompleted);
    }

    @Override
    public String toString() {
        return title +
                ", completed=" + completed +
                ", completedAt=" + completedAt;
    }
}

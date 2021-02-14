package week15d03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PostFinder {


    public List<Post> posts;

    public PostFinder(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> getPosts() {
        return new ArrayList<>(posts);
    }

    public List<Post> findPostFor(String user) {
        Objects.requireNonNull(user,"User is null");
        List<Post> result = new ArrayList<>();
        for (Post post : posts) {
            if (isDateCorrect(post.getPublishedAt())
                    && isNotBlank(post.getTitle())
                    && isNotBlank(post.getContent())
                    && post.getOwner().equals(user)) {
                result.add(post);
            }
        }
        return result;
    }

    private boolean isNotBlank(String str) {
        return str != null && !str.isBlank();
    }

    private boolean isDateCorrect(LocalDate publishedAt) {
        return publishedAt.isBefore(LocalDate.now());
    }

}

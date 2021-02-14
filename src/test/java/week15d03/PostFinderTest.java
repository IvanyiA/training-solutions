package week15d03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostFinderTest {

    @Test
    void testAddCorrectData() {
        Post p1 = new Post("névnap1", LocalDate.of(2020, 1, 21), "Boldog névnapot", "Judit");
        Post p2 = new Post("névnap2", LocalDate.of(2020, 6, 13), "Boldog névnapot", "Emike");
        Post p3 = new Post("névnap3", LocalDate.of(2021, 1, 21), "Boldog névnapot", "Judit");

        List<Post> posts = new ArrayList<>();
        posts.add(p1);
        posts.add(p2);
        posts.add(p3);

        PostFinder postFinder = new PostFinder(posts);

        List<Post> result = postFinder.findPostFor("Judit");
        assertEquals(2, result.size());

    }

    @Test
    void testUserIsNull() {
        Post p1 = new Post("névnap1", LocalDate.of(2020, 1, 21), "Boldog névnapot", "Judit");
        Post p2 = new Post("névnap2", LocalDate.of(2020, 6, 13), "Boldog névnapot", "Emike");
        Post p3 = new Post("névnap3", LocalDate.of(2021, 1, 21), "Boldog névnapot", "Judit");

        List<Post> posts = new ArrayList<>();
        posts.add(p1);
        posts.add(p2);
        posts.add(p3);

        PostFinder postFinder = new PostFinder(posts);

        NullPointerException ex = assertThrows(NullPointerException.class, () -> postFinder.findPostFor(null));
        assertEquals("User is null", ex.getMessage());
    }

}
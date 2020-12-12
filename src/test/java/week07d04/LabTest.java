package week07d04;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class LabTest {

    @Test
    public void testConstructorOverload() {
        Lab lab = new Lab("Konstruktor túlterhelés");

        assertEquals("Konstruktor túlterhelés", lab.getTitle());
        assertFalse(lab.isCompleted());
        assertEquals(null, lab.getCompletedAt());
    }

    @Test
    public void testConstructorOverloadWithTwoParam() {
        Lab lab = new Lab("Konstruktor túlterhelés", LocalDate.of(2020, 12, 11));

        assertEquals("Konstruktor túlterhelés", lab.getTitle());
        assertTrue(lab.isCompleted());
        assertEquals(LocalDate.of(2020, 12, 11), lab.getCompletedAt());
    }

    @Test
    public void testCompleteWithParam() {
        Lab lab = new Lab("Metódus túlterhelés");

        lab.complete(LocalDate.of(2020, 12, 12));
        assertTrue(lab.isCompleted());
        assertEquals(LocalDate.of(2020, 12, 12), lab.getCompletedAt());
    }

    @Test
    public void testComplete() {
        Lab lab = new Lab("Metódus túlterhelés");

        lab.complete();
        assertTrue(lab.isCompleted());
        assertEquals(LocalDate.now(), lab.getCompletedAt());
    }

    @Test
    public void testisTitleLongerThanTwoCharacter() {
        Lab lab = new Lab("Bemeneti érték ellenőrzése");

        boolean result = lab.isTitleLongerThanTwoCharacter();

        assertTrue(result);
    }

    @Test
    public void testisTitleShorterThanThreeCharacter() {
        Lab lab = new Lab("Be");

//        boolean result = lab.isTitleLongerThanTwoCharacter();

        assertFalse(lab.isTitleLongerThanTwoCharacter());
    }

    @Test
    public void testTitleAndCompleted() {
        Lab lab = new Lab("Be");
        String sign = "x-";
        String result = lab.titleAndCompleted(Character.toString(sign.charAt(0)),Character.toString(sign.charAt(1)));
        assertEquals("Be -", result);


    }
}
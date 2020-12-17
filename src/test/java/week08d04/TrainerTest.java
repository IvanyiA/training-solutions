package week08d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainerTest {

    @Test
    public void giveMark() {
        Trainer trainer =new Trainer(new BadMood());

        assertEquals(3, trainer.giveMark());

    }
}
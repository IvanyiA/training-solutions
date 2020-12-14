package week08d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {

    @Test
    public void TestMoveRobot() {
        Robot robot = new Robot();
        robot.move("FFF");

        assertEquals(0, robot.getPosition().getX());
        assertEquals(3, robot.getPosition().getY());
    }

    @Test
    public void TestWrongMove() {
        Robot robot = new Robot();
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            robot.move("D");
        });

        assertEquals("Invalid movement!", ex.getMessage());

    }
}
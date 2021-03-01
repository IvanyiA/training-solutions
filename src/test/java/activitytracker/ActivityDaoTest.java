package activitytracker;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActivityDaoTest {

    ActivityDao activityDao;

    @BeforeEach
    public void init() {
        MariaDbDataSource dataSource;

        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?userUnicode=true");
            dataSource.setUser("activitytracker");
            dataSource.setPassword("activitytracker");

        } catch (SQLException se) {
            throw new IllegalStateException("Cannot connect", se);
        }

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        activityDao = new ActivityDao(dataSource);
    }

    @Test
    public void selectByIdTest() {

        Activity activity = activityDao.findById(1L);

        assertEquals(ActivityType.BIKING, activity.getType());

    }

    @Test
    public void insertactivityTest() {

        Activity activity = new Activity(0L, LocalDateTime.now(), "Activity", ActivityType.HIKING);
        System.out.println(activity);

        Activity result = activityDao.insertactivity(activity);

        assertEquals(activity.getDesc(), activityDao.findById(result.getId()).getDesc());

    }

    @Test
    public void beforedateTest() {
        assertEquals(2, activityDao.activitiesBeforeDate(LocalDate.of(2021, 2, 12)).size());

    }

    @Test
    public void insertactivitiesTest() {
        activityDao.insertactivities(List.of(
                new Activity(0L, LocalDateTime.now(), "Activity", ActivityType.HIKING),
                new Activity(0L, LocalDateTime.now(), "Activity", ActivityType.BIKING)
        ));

        System.out.println(activityDao.selectAllActivities());

    }


}
package activitytracker;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityTrackerMain {

    public void insertactivity(DataSource dataSource, Activity activity) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement("insert into activities(start_time, activity_desc, activity_type) values(?,?,?)")
        ) {
            statement.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            statement.setString(2, activity.getDesc());
            statement.setString(3, activity.getType().toString());
            statement.executeUpdate();

        } catch (SQLException se) {
            throw new IllegalArgumentException("Cannot insert", se);
        }
    }


    public Activity findById(DataSource dataSource, long id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement("select * from activities where id = ?")
        ) {
            statement.setLong(1, id);

            List<Activity> result = selectActivityByPreparedStatement(statement);
            if (result.size() == 1) {
                return result.get(0);
            }
            throw new IllegalArgumentException("Not found");

        } catch (SQLException se) {
            throw new IllegalArgumentException("Cannot connect", se);
        }
    }

    private List<Activity> selectActivityByPreparedStatement(PreparedStatement statement) {
        List<Activity> result = new ArrayList<>();
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Activity activity = new Activity(
                        resultSet.getLong("id"),
                        resultSet.getTimestamp("start_time").toLocalDateTime(),
                        resultSet.getString("activity_desc"),
                        ActivityType.valueOf(resultSet.getString("activity_type")));
                result.add(activity);
            }
            return result;

        } catch (SQLException se) {
            throw new IllegalArgumentException("Execute failed", se);
        }
    }

    public List<Activity> selectAllActivities(DataSource dataSource) {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("select * from activities")
        ) {
            return selectActivityByPreparedStatement(statement);

        } catch (SQLException se) {
            throw new IllegalStateException("Cannot connect", se);
        }
    }

    public static void main(String[] args) {
        MariaDbDataSource dataSource;

        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?userUnicode=true");
            dataSource.setUser("activitytracker");
            dataSource.setPassword("activitytracker");

        } catch (SQLException se) {
            throw new IllegalStateException("Cannot connect", se);
        }

        Activity activity1 = new Activity(LocalDateTime.of(2021, 2, 23, 10, 20), "Biking in Matra", ActivityType.BIKING);
        Activity activity2 = new Activity(LocalDateTime.of(2021, 2, 23, 11, 20), "Running in Matra", ActivityType.RUNNING);
        Activity activity3 = new Activity(LocalDateTime.of(2021, 2, 23, 12, 20), "Hiking in Matra", ActivityType.HIKING);

        ActivityTrackerMain activityTrackerMain = new ActivityTrackerMain();
//        activityTrackerMain.insertactivity(dataSource, activity1);
//        activityTrackerMain.insertactivity(dataSource, activity2);
//        activityTrackerMain.insertactivity(dataSource, activity3);

        System.out.println(activityTrackerMain.findById(dataSource, 1));
        System.out.println(activityTrackerMain.selectAllActivities(dataSource));

    }
}

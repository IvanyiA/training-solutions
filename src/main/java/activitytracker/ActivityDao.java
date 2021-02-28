package activitytracker;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao {

    private DataSource dataSource;

    public ActivityDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Activity insertactivity(Activity activity) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement("insert into activities(start_time, activity_desc, activity_type) values(?,?,?)",
                             Statement.RETURN_GENERATED_KEYS)
        ) {
            statement.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            statement.setString(2, activity.getDesc());
            statement.setString(3, activity.getType().toString());
            statement.executeUpdate();
            long id = executeAndGetGeneratedKey(statement);
            return new Activity(
                    id, activity.getStartTime(), activity.getDesc(), activity.getType());

        } catch (SQLException se) {
            throw new IllegalArgumentException("Cannot insert", se);
        }
    }

    public List<Activity> activitiesBeforeDate(LocalDate date) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "select * from activities where start_time < ?")
        ) {
            LocalDateTime actualDate = date.atTime(0, 0);   //LocalDate-ből LocalDateTime-ot csinálunk
            statement.setTimestamp(1, Timestamp.valueOf(actualDate));
            return selectActivityByPreparedStatement(statement);

        } catch (SQLException se) {
            throw new IllegalStateException("Cannot connect", se);
        }
    }

//    public List<Activity> insertactivity(List<Activity> activities) {
//        List<Activity> result = new ArrayList<>();
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(
//                     "INSERT INTO activities(start_time,activity_desc, activity_type) VALUES" + "(?,?,?),".repeat(activities.size())) //a végéről sajnos leh kell törölni az utolsó vesszőt, és emiatt nem működik
//        ) {
//            int i = 1;
//            for (Activity activity : activities) {
//                preparedStatement.setTimestamp(i++, Timestamp.valueOf(activity.getStartTime()));
//                preparedStatement.setString(i++, activity.getDesc());
//                preparedStatement.setString(i++, activity.getType().toString());
//            }
//            preparedStatement.executeUpdate();
//            List<Long> ids = getIdsByPreparedStatement(preparedStatement);
//            for (int j = 0; j < activities.size(); j++) {
//                Activity activity =activities.get(j);
//                result.add(new Activity(ids.get(j), activity.getStartTime(), activity.getDesc(), activity.getType()));
//            }
//        } catch (SQLException se) {
//            throw new IllegalArgumentException("Cannot insert", se);
//        }
//        return result;
//    }
//
//    private List<Long> getIdsByPreparedStatement(PreparedStatement preparedStatement) {
//        List<Long> result = new ArrayList<>();
//        try (ResultSet resultSet=preparedStatement.getGeneratedKeys()) {
//            while (resultSet.next()){
//                result.add(resultSet.getLong("id"));
//            }
//            return result;
//        } catch (SQLException se){
//            throw new IllegalArgumentException("Insertion failed", se);
//        }
//    }

    public String createStatementForMoreInsert(int numberOfElements) {
        StringBuilder stringBuilder = new StringBuilder("insert into activities(start_time,activity_desc, activity_type) values ");
        for (int i = 0; i < numberOfElements; i++) {
            stringBuilder.append("(?,?,?");
        }
        return stringBuilder.toString();
    }

    private long executeAndGetGeneratedKey(PreparedStatement statement) {
        try (
                ResultSet resultSet = statement.getGeneratedKeys()
        ) {
//            while (resultSet.next()){
//                new Activity(resultSet.getLong(1), resultSet.getString(2),...)
//            }

            if (resultSet.next()) {
                return resultSet.getLong(1);
            } else {
                throw new SQLException("No key was generated");
            }
        } catch (SQLException se) {
            throw new IllegalArgumentException("Insertion failed", se);
        }
    }


    public Activity findById(long id) {
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

    public List<Activity> selectAllActivities() {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("select * from activities")
        ) {
            return selectActivityByPreparedStatement(statement);

        } catch (SQLException se) {
            throw new IllegalStateException("Cannot connect", se);
        }
    }

    public List<Activity> selectByType(ActivityType type) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("select * from activities where activity_type =?")
        ) {
            statement.setString(1, type.toString());
            return selectActivityByPreparedStatement(statement);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot connect", se);
        }
    }


}

package activity;

import java.util.ArrayList;
import java.util.List;

public class Activities {

    private final List<Activity> activities;

    public Activities(List<Activity> activities) {
        this.activities = activities;
    }

    public int numberOfTrackActivities() {
        int counter = 0;
        for (Activity activity : activities) {
            if (activity.getClass() == ActivityWithTrack.class) {
                counter++;
            }
        }

        return counter;
    }

    public int numberOfWithoutTrackActivities() {
        int counter = 0;
        for (Activity activity : activities) {
            if (activity.getClass() == ActivityWithoutTrack.class) {
                counter++;
            }
        }

        return counter;
    }


    public List<Report> distancesByTypes() {
        List<Report> reports = new ArrayList<>();
        for (int i = 0; i < ActivityType.values().length; i++) {
            ActivityType activityType = ActivityType.values()[i];

            double distance = 0;
            for (Activity activity : activities) {
                if (activity.getType().equals(ActivityType.values()[i])) {
                    distance += activity.getDistance();
                }
            }
            reports.add(new Report(activityType, distance));

        }
        return reports;
    }
}

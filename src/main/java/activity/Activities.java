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
//            if (activity.getClass() == ActivityWithTrack.class) {
//            if (activity instanceOf ActivityWithTrack) {
            if (activity.getType().hasTrack()) {
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

//    public List<Report> distancesByTypes() {
//        List<Report> reports = new ArrayList<>();
//        int[] sum = new int[ActivityType.values().length];
//        for (Activity activity : activities) {
//            sum[activity.getType().ordinal()] += activity.getDistance();
//        }
//
//        for (ActivityType activityType : ActivityType.values()) {
//            reports.add(new Report(activityType, sum[activityType.ordinal()]));
//        }
//        return reports;
//    }

}

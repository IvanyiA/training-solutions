package activity;

import java.util.ArrayList;
import java.util.List;

public class Track {

    private final List<TrackPoint> trackPoints = new ArrayList<>();


    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }

    public void addTrackPoint(TrackPoint originalTrackpoint) {
        trackPoints.add(originalTrackpoint);
    }

    public double getFullElevation() {
        double sum = 0;
        for (int i = 0; i < trackPoints.size() - 1; i++) {
            if (trackPoints.get(i).getElevation() < trackPoints.get(i + 1).getElevation()) {
                sum += trackPoints.get(i + 1).getElevation() - trackPoints.get(i).getElevation();
            }
        }
        return sum;
    }

    public double getFullDecrease() {
        double sum = 0;
        for (int i = 0; i < trackPoints.size() - 1; i++) {
            if (trackPoints.get(i).getElevation() > trackPoints.get(i + 1).getElevation()) {
                sum += trackPoints.get(i).getElevation() - trackPoints.get(i + 1).getElevation();
            }
        }
        return sum;
    }

    public double getDistance() {
        double sum = 0;
        for (int i = 1; i < trackPoints.size(); i++) {
            sum += trackPoints.get(i - 1).getDistanceFrom(trackPoints.get(i));
        }
        return sum;
    }

    public Coordinate findMinimumCoordinate() {
        double minLat = trackPoints.get(0).getCoordinate().getLatitude();
        double minLong = trackPoints.get(0).getCoordinate().getLongitude();
        for (TrackPoint trackPoint : trackPoints) {
            if (trackPoint.getCoordinate().getLatitude() < minLat) {
                minLat = trackPoint.getCoordinate().getLatitude();
            }
            if (trackPoint.getCoordinate().getLongitude() < minLong) {
                minLong = trackPoint.getCoordinate().getLongitude();
            }
        }
        return new Coordinate(minLat, minLong);
    }

    public Coordinate findMaximumCoordinate() {
        double maxLat = trackPoints.get(0).getCoordinate().getLatitude();
        double maxLong = trackPoints.get(0).getCoordinate().getLongitude();
        for (TrackPoint trackPoint : trackPoints) {
            if (trackPoint.getCoordinate().getLatitude() > maxLat) {
                maxLat = trackPoint.getCoordinate().getLatitude();
            }
            if (trackPoint.getCoordinate().getLongitude() > maxLong) {
                maxLong = trackPoint.getCoordinate().getLongitude();
            }
        }
        return new Coordinate(maxLat, maxLong);
    }


    public double getRectangleArea() {

        return (findMaximumCoordinate().getLatitude() - findMinimumCoordinate().getLatitude())
                * (findMaximumCoordinate().getLongitude() - findMinimumCoordinate().getLongitude());
    }
}
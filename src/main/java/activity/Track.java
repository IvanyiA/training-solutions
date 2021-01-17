package activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

    public void loadFromGpx(InputStream inputStream) {
        try (BufferedReader bufferedReader = new BufferedReader
                (new InputStreamReader(inputStream))) {
            String line;
            Coordinate coordinate = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains("<trkpt")) {
                    double lat = Double.parseDouble(line.substring(15, 25));
                    double lon = Double.parseDouble(line.substring(32, 42));
                    coordinate = new Coordinate(lat, lon);
                }
                if (line.contains("<ele")) {
                    double ele = Double.parseDouble(line.substring(9, 14));
                    TrackPoint trackPoint = new TrackPoint(coordinate, ele);
                    trackPoints.add(trackPoint);
                }
            }
        } catch (IOException ioe) {
           throw new IllegalStateException("Cannot read file.", ioe);
        }
        System.out.println(trackPoints);
    }

}
package localvariables;

public class DistanceMain {
    public static void main(String[] args) {
        Distance tavolsag = new Distance (13.8, false);
        System.out.println(tavolsag.getDistanceKm() + " " + tavolsag.isExact());
        int egeszResz = (int) tavolsag.distanceKm;
        System.out.println(egeszResz);
    }
}

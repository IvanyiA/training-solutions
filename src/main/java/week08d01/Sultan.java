package week08d01;

import java.util.ArrayList;
import java.util.List;

public class Sultan {

    private final int numberOfDoors;
    private boolean[] doors;    //The default value for a boolean (primitive) is false

    public Sultan(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
        this.doors = new boolean[numberOfDoors];
    }

    public List<Integer> openDoors(int numberOfDays) {
        for (int day = 1; day <= numberOfDays; day++) {
            openDoorsOneDay(day);

        }
        return getOpenedDoors();
    }

    public void openDoorsOneDay(int day) {
        for (int i = 0; i < numberOfDoors; i++) {
            if ((i + 1) % day == 0) {
                doors[i] = !doors[i];
            }
        }
    }

    private List<Integer> getOpenedDoors() {
        List<Integer> openedDoors = new ArrayList<>();
        for (int i = 0; i < numberOfDoors; i++) {
            if (doors[i]) {
                openedDoors.add(i + 1);
            }
        }
        return openedDoors;
    }

//    public boolean[] getOpenDoors() {
//        boolean[] result = new boolean[100];
//        for (int i = 0; i < 100; i++) {
//            for (int j = 1; j <= 100; j++) {
//                if ((i + 1) % j == 0) {         // i+1, az a nap sorszámát mutatja
//                    result[i] = !result[i];
//                }
//            }
//        }
//        return result;
//    }
//
//    public static void main(String[] args) {
//        Sultan sultan = new Sultan();
//        for (int i = 0; i < sultan.getOpenDoors().length; i++) {
//            if (sultan.getOpenDoors()[i]){
//                System.out.println(i + 1);          //négyzetszámoknak van egyedül páratlan számú osztója
//            }
//        }
//    }

    public static void main(String[] args) {
        Sultan sultan = new Sultan(100);
        List<Integer> openedDoorsAtAGivenDay = sultan.openDoors(100);
        System.out.println(openedDoorsAtAGivenDay);
    }

}



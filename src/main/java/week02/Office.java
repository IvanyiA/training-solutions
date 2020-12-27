package week02;

import java.util.ArrayList;
import java.util.List;


public class Office {

    private List<MeetingRoom> meetingRooms = new ArrayList<>();


    public List<MeetingRoom> getMeetingRooms() {
        return meetingRooms;
    }

    public void setMeetingRooms(List<MeetingRoom> meetingRooms) {
        this.meetingRooms = meetingRooms;
    }


    public void addMeetingRoom(MeetingRoom meetingRoom) {
        meetingRooms.add(meetingRoom);
    }

    public void printNames() {
        for (MeetingRoom meetingRoom : meetingRooms) {
            System.out.println(meetingRoom.getName());
        }
    }

    public void printNamesReverse() {
        for (int i = meetingRooms.size() - 1; i >= 0; i--) {
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printEvenNames() {
        for (int i = 1; i < meetingRooms.size(); i = i + 2) {
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printAreas() {
        for (MeetingRoom meetingRoom : meetingRooms) {
            System.out.println("A tárgyaló neve: " + meetingRoom.getName()
            + ", Szélesség: " + meetingRoom.getWidth() + "m"
            + ", Hosszúság: " + meetingRoom.getLenght() + " m"
            + ", Terület: " + meetingRoom.getArea() + "m2");
        }
    }

    public void printMeetingRoomsWithName(String name) {
        for (MeetingRoom meetingRoom : meetingRooms) {
            if (meetingRoom.getName().equals(name)) {
                System.out.println("A tárgyaló szélessége: " + meetingRoom.getWidth() + " m"
                + ", A tárgyaló hosszúsága: " + meetingRoom.getLenght() + " m"
                + ", A tárgyaló területe: " + meetingRoom.getArea() + " m2");
            }
        }
    }

    public void printMeetingRoomsContains(String part) {
        for (MeetingRoom meetingRoom : meetingRooms) {
            if (meetingRoom.getName().toUpperCase().contains(part.toUpperCase())) {
                System.out.println("A tárgyaló neve: " + meetingRoom.getName()
                        + ", Szélesség: " + meetingRoom.getWidth() + "m"
                        + ", Hosszúság: " + meetingRoom.getLenght() + " m"
                        + ", Terület: " + meetingRoom.getArea() + "m2");
            }
        }

    }

    public void printAreasLargerThan(int area) {
        for (MeetingRoom meetingRoom : meetingRooms) {
            if (meetingRoom.getArea() > area) {
                System.out.println("A tárgyaló neve: " + meetingRoom.getName()
                        + ", Szélesség: " + meetingRoom.getWidth() + "m"
                        + ", Hosszúság: " + meetingRoom.getLenght() + " m"
                        + ", Terület: " + meetingRoom.getArea() + "m2");
            }
        }
    }

}

import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        ArrayList<Room> rooms = new ArrayList<>();

        rooms.add(new SingleRoom(101, 15000, true));
        rooms.add(new DoubleRoom(102, 25000, false));
        rooms.add(new SingleRoom(103, 14000, true));

        System.out.println("=== ALL ROOMS ===");
        for (Room room : rooms) {
            System.out.println(room);
        }

        System.out.println("\n=== AVAILABLE ROOMS (FILTER) ===");
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println(room);
            }
        }

        System.out.println("\n=== SEARCH ROOM 102 ===");
        for (Room room : rooms) {
            if (room.getRoomNumber() == 102) {
                System.out.println("Found: " + room);
            }
        }

        System.out.println("\n=== SORT BY PRICE ===");
        rooms.sort(Comparator.comparingDouble(Room::getPricePerNight));
        for (Room room : rooms) {
            System.out.println(room);
        }
    }
}
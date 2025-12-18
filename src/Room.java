public class Room {


    private int roomNumber;
    private String roomType;
    private double pricePerNight;
    private boolean available;


    public Room() {
    }

    public Room(int roomNumber, String roomType, double pricePerNight, boolean available) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.available = available;
    }


    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void printInfo() {
        System.out.println(
                "Room " + roomNumber +
                        " | Type: " + roomType +
                        " | Price: " + pricePerNight +
                        " | Available: " + available
        );
    }
}


import java.util.Objects;

public abstract class Room {

    private int roomNumber;
    private double pricePerNight;
    private boolean available;

    public Room(int roomNumber, double pricePerNight, boolean available) {
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
        this.available = available;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public abstract String getRoomType();

    @Override
    public String toString() {
        return "Room{" +
                "number=" + roomNumber +
                ", type=" + getRoomType() +
                ", price=" + pricePerNight +
                ", available=" + available +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return roomNumber == room.roomNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber);
    }
}

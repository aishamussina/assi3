import java.sql.Connection;
import java.sql.PreparedStatement;

public class RoomDAO {

    public void addRoom(Room room) {

        String sql = "INSERT INTO rooms(room_number, room_type, price_per_night, available) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, room.getRoomNumber());
            ps.setString(2, room.getRoomType());
            ps.setDouble(3, room.getPricePerNight());
            ps.setBoolean(4, room.isAvailable());

            ps.executeUpdate();

            System.out.println("Room added");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RoomDAO {

    public void addRoom(Room room) {

        String sql =
                "INSERT INTO rooms(room_number, room_type, price_per_night, available) " +
                        "VALUES (?, ?, ?, ?) " +
                        "ON CONFLICT (room_number) DO NOTHING";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, room.getRoomNumber());
            ps.setString(2, room.getRoomType());
            ps.setDouble(3, room.getPricePerNight());
            ps.setBoolean(4, room.isAvailable());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Room added: " + room.getRoomNumber());
            } else {
                System.out.println("Room already exists: " + room.getRoomNumber());
            }

        } catch (SQLException e) {
            System.out.println("Room insert error: " + e.getMessage());
        }
    }
}

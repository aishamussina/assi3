import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    // READ (all)
    public void getAllRooms() {
        String sql = "SELECT room_number, room_type, price_per_night, available FROM rooms ORDER BY room_number";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("room_number") + " | " +
                                rs.getString("room_type") + " | " +
                                rs.getBigDecimal("price_per_night") + " | " +
                                rs.getBoolean("available")
                );
            }

        } catch (SQLException e) {
            System.out.println("Read rooms error: " + e.getMessage());
        }
    }

    // SEARCH by number
    public void findRoomByNumber(int roomNumber) {
        String sql = "SELECT room_number, room_type, price_per_night, available FROM rooms WHERE room_number = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, roomNumber);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Found room: " +
                            rs.getInt("room_number") + " | " +
                            rs.getString("room_type") + " | " +
                            rs.getBigDecimal("price_per_night") + " | " +
                            rs.getBoolean("available")
                    );
                } else {
                    System.out.println("Room not found: " + roomNumber);
                }
            }

        } catch (SQLException e) {
            System.out.println("Find room error: " + e.getMessage());
        }
    }

    // UPDATE (availability)
    public void updateRoomAvailability(int roomNumber, boolean available) {
        String sql = "UPDATE rooms SET available = ? WHERE room_number = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setBoolean(1, available);
            ps.setInt(2, roomNumber);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Room updated: " + roomNumber);
            } else {
                System.out.println("No room found with number: " + roomNumber);
            }

        } catch (SQLException e) {
            System.out.println("Update room error: " + e.getMessage());
        }
    }

    // DELETE
    public void deleteRoom(int roomNumber) {
        String sql = "DELETE FROM rooms WHERE room_number = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, roomNumber);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Room deleted: " + roomNumber);
            } else {
                System.out.println("No room found with number: " + roomNumber);
            }

        } catch (SQLException e) {
            System.out.println("Delete room error: " + e.getMessage());
        }
    }
}

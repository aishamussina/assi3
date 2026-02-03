import java.sql.*;

public class GuestDAO {

    public int addGuest(Guest guest) {

        String sql = "INSERT INTO guests(name, age, phone) VALUES (?, ?, ?) RETURNING id";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, guest.getName());
            ps.setInt(2, guest.getAge());
            ps.setString(3, guest.getPhone());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    System.out.println("Guest added. id = " + id);
                    return id;
                }
            }

        } catch (SQLException e) {
            System.out.println("Add guest error (maybe duplicate phone): " + e.getMessage());
        }

        return -1;
    }

    public void getAllGuests() {

        String sql = "SELECT id, name, age, phone FROM guests ORDER BY id";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getInt("age") + " | " +
                                rs.getString("phone")
                );
            }

        } catch (SQLException e) {
            System.out.println("Read error: " + e.getMessage());
        }
    }

    public void updateGuestPhone(int id, String phone) {

        String sql = "UPDATE guests SET phone = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, phone);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Guest updated (id = " + id + ")");
            } else {
                System.out.println("No guest found with id = " + id);
            }

        } catch (SQLException e) {
            System.out.println("Update error: " + e.getMessage());
        }
    }

    public void deleteGuest(int id) {

        String sql = "DELETE FROM guests WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Guest deleted (id = " + id + ")");
            } else {
                System.out.println("No guest found with id = " + id);
            }

        } catch (SQLException e) {
            System.out.println("Delete error: " + e.getMessage());
        }
    }
}

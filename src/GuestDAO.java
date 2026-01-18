import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class GuestDAO {

    public void addGuest(Guest guest) {
        String sql = "INSERT INTO guests(name, age, phone) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, guest.getName());
            ps.setInt(2, guest.getAge());
            ps.setString(3, guest.getPhone());
            ps.executeUpdate();

            System.out.println("Guest added");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAllGuests() {
        String sql = "SELECT * FROM guests";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getInt("age") + " | " +
                                rs.getString("phone")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateGuestPhone(int id, String phone) {
        String sql = "UPDATE guests SET phone=? WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, phone);
            ps.setInt(2, id);
            ps.executeUpdate();

            System.out.println("Guest updated");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteGuest(int id) {
        String sql = "DELETE FROM guests WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Guest deleted");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
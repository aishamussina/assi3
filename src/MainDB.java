public class MainDB {

    public static void main(String[] args) {

        GuestDAO guestDAO = new GuestDAO();
        RoomDAO roomDAO = new RoomDAO();

        guestDAO.addGuest(new Guest("Aisha", 18, "87001234567"));
        guestDAO.getAllGuests();
        guestDAO.updateGuestPhone(1, "87009999999");
        guestDAO.deleteGuest(1);

        roomDAO.addRoom(new SingleRoom(401, 22000, true));
        roomDAO.addRoom(new DoubleRoom(402, 35000, false));
    }
}
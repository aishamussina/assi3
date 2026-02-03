public class MainDB {

    public static void main(String[] args) {

        GuestDAO guestDAO = new GuestDAO();
        RoomDAO roomDAO = new RoomDAO();

        int id1 = guestDAO.addGuest(new Guest("Aisha", 18, "87001230001"));
        int id2 = guestDAO.addGuest(new Guest("Aruzhan", 19, "87001230002"));

        System.out.println("\n--- ALL GUESTS ---");
        guestDAO.getAllGuests();

        if (id1 != -1) {
            guestDAO.updateGuestPhone(id1, "87005555555");
        }

        System.out.println("\n--- AFTER UPDATE ---");
        guestDAO.getAllGuests();

        roomDAO.addRoom(new SingleRoom(401, 22000, true));
        roomDAO.addRoom(new DoubleRoom(402, 35000, false));
    }
}

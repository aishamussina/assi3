public class MainDB {

    public static void main(String[] args) {

        GuestDAO guestDAO = new GuestDAO();
        RoomDAO roomDAO = new RoomDAO();

        System.out.println("===== GUEST CRUD =====");

        // CREATE guests (unique phones to avoid conflicts)
        int id1 = guestDAO.addGuest(new Guest("Aisha", 18, "87009990001"));
        int id2 = guestDAO.addGuest(new Guest("Aruzhan", 19, "87009990002"));

        System.out.println("\n--- READ ALL GUESTS ---");
        guestDAO.getAllGuests();

        // UPDATE
        if (id1 != -1) {
            System.out.println("\n--- UPDATE GUEST PHONE ---");
            guestDAO.updateGuestPhone(id1, "87009991111");
        }

        System.out.println("\n--- AFTER UPDATE ---");
        guestDAO.getAllGuests();

        // DELETE (delete both guests to show DELETE clearly)
        System.out.println("\n--- DELETE GUESTS ---");
        if (id2 != -1) guestDAO.deleteGuest(id2);
        if (id1 != -1) guestDAO.deleteGuest(id1);

        System.out.println("\n--- AFTER DELETE ---");
        guestDAO.getAllGuests();


        System.out.println("\n\n===== ROOM CRUD =====");

        // CREATE rooms
        roomDAO.addRoom(new SingleRoom(401, 22000, true));
        roomDAO.addRoom(new DoubleRoom(402, 35000, false));

        System.out.println("\n--- READ ALL ROOMS ---");
        roomDAO.getAllRooms();

        // SEARCH
        System.out.println("\n--- SEARCH ROOM 401 ---");
        roomDAO.findRoomByNumber(401);

        // UPDATE
        System.out.println("\n--- UPDATE ROOM 401 AVAILABLE=false ---");
        roomDAO.updateRoomAvailability(401, false);

        System.out.println("\n--- AFTER UPDATE ---");
        roomDAO.getAllRooms();

        // DELETE
        System.out.println("\n--- DELETE ROOM 402 ---");
        roomDAO.deleteRoom(402);

        System.out.println("\n--- AFTER DELETE ---");
        roomDAO.getAllRooms();

        System.out.println("\n===== END =====");
    }
}

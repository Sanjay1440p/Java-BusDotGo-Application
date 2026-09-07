
import java.util.Scanner;
import java.util.ArrayList;

public class Admin {

    private final Scanner scanner;
    private final ArrayList<Bus> buses;
    private final ArrayList<Booking> bookings;

    private String userName = "Admin";
    private String password = "6769";

    public Admin(Scanner scanner, ArrayList<Bus> buses, ArrayList<Booking> bookings) {
        this.scanner = scanner;
        this.buses = buses;
        this.bookings = bookings;
    }

    public boolean login(String usr, String pas) {
        if (!userName.equals(usr)) {
            System.out.println("Incorrect User Name!");
            return false;
        }
        if (!password.equals(pas)) {
            System.out.println("Incorrect Password!");
            return false;
        }

        System.out.println("Access Gained. Welcome " + usr);
        return true;
    }

    public void mutateBuses(){
        boolean adminFlag = true;
        while (adminFlag) {
            System.out.println("\n***********************************************************");
            System.out.println("1. SEE AVAILABLE BUSES\n2. ADD BUS\n3. SELECT BUS\n4. REMOVE BUS");
            System.out.println("5. SEE BOOKING LOGS\n6. REMOVE BOOKING\n7. EXIT");
            System.out.print("\nEnter Option: ");
            int adminOption = readInt("Enter Option: ");

            switch (adminOption) {
                case 1:
                    if (buses.isEmpty()) {
                        System.out.println("No buses available.");
                    } else {
                        for (Bus bus : buses) {
                            bus.displayBus();
                        }
                    }
                    break;

                case 2:
                    addBus();
                    break;

                case 3:
                    Bus selectedBus = findBus(readBusNumber("Enter bus number: "));
                    if (selectedBus == null) {
                        System.out.println("Bus not found.");
                    } else {
                        selectedBus.displayBus();
                    }
                    break;

                case 4:
                    Bus busToRemove = findBus(readBusNumber("Enter bus number to remove: "));
                    if (busToRemove == null) {
                        System.out.println("Bus not found.");
                    } else {
                        buses.remove(busToRemove);
                        System.out.println("Bus removed successfully.");
                    }
                    break;

                case 5:
                    if (bookings.isEmpty()) {
                        System.out.println("No bookings available.");
                    } else {
                        for (Booking booking : bookings) {
                            booking.displayBookings();
                        }
                    }
                    break;

                case 6:
                    removeBooking();
                    break;

                case 7:
                    adminFlag = false;
                    break;

                default:
                    System.out.println("Invalid option. Please enter a valid one.");
                    break;
            }
        }
    }

    private void addBus() {
        Bus bus = new Bus(0, "", "", 0, 0, "", "");
        bus.SetBusNo(readInt("Enter bus number: "));
        bus.SetStartPoint(readText("Enter starting point: "));
        bus.SetDestination(readText("Enter destination: "));
        bus.SetCapacity(readInt("Enter capacity: "));
        bus.SetAvailableSeats(bus.getCapacity());
        bus.SetDriverName(readText("Enter driver name: "));
        bus.SetDriverPhone(readText("Enter driver phone: "));
        buses.add(bus);
        System.out.println("Bus added successfully.");
    }

    private void removeBooking() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings available.");
            return;
        }
        long bookingId = readLong("Enter booking ID to remove: ");
        boolean removed = bookings.removeIf(booking -> booking.getBookingId() == bookingId);
        System.out.println(removed ? "Booking removed successfully." : "Booking not found.");
    }

    private Bus findBus(int busNumber) {
        for (Bus bus : buses) {
            if (bus.getBusNo() == busNumber) {
                return bus;
            }
        }
        return null;
    }

    private int readBusNumber(String prompt) {
        return readInt(prompt);
    }

    private int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a number.");
            scanner.nextLine();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    private long readLong(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextLong()) {
            System.out.println("Please enter a number.");
            scanner.nextLine();
        }
        long value = scanner.nextLong();
        scanner.nextLine();
        return value;
    }

    private String readText(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

}

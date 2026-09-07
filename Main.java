/* USER_NAME: Admin
PASSWORD: 6769 */
//Note user, the password is string so u cand change it as whatever u want  :)

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Bus> buses = new ArrayList<>();
        ArrayList<Booking> bookings = new ArrayList<>();
        Admin admin = new Admin(scanner, buses, bookings);

        buses.add(new Bus(101, "Chennai", "Coiambatore", 55, 45,
            "SiranJeevi", "9876543210"));
        buses.add(new Bus(102, "Coiambatore", "Bangalore", 60, 30,
            "Abilash", "9876543211"));

        System.out.print("--------Welcome to BusDotGo Services--------\n");

        boolean choice = true;

        while (true) {
            
            if(choice == true){

            System.out.println("1.Booking.\n2.Avilable Buses.\n3.Booking Status.\n4.Admin Login.\n5.Exit");
            System.out.print("Enter Your Option:");
            int usrOption = readInt(scanner);
                
                switch (usrOption) {
                case 1:
                    boolean bookAgain = true;
                    while (bookAgain == true) {

                        Booking inputBooking = new Booking("", 0, "", 0, 0, "", null);
                        Booking booking = inputBooking.readBookingData(scanner, buses);

                        if (booking != null) {
                            bookings.add(booking);
                            System.out.println("Booking created successfully.");
                        }

                        //System.out.println("\nBooking working...\n");
                        System.out.println("\nDo You want to book AGAIN?");
                        System.out.println("Y/N");
                        char exitOption = scanner.next().charAt(0);

            if(exitOption == 'Y' || exitOption == 'y'){
                //var booking is already true
                
            }
            else if(exitOption == 'N' || exitOption == 'n'){
                bookAgain = false;
            }
            else{
                System.out.println("Invalid Option Please Enter Valild one!");
            }
        }
                    break;
                    
                case 2:
                    System.out.println("\nAvailable Buses:\n");
                    for (Bus bus : buses) {
                        bus.displayBus();
                    }
                    break; 

                case 3:
                    if(bookings.isEmpty()){
                        System.out.println("No Bookings  Avilable :(");
                    }
                    else{
                        for(Booking b : bookings){
                            b.displayBookings();
                        }
                        
                    }
                    
                    //System.out.println("\nBooking Details working....\n");
                    
                    break;

                case 4:
                        System.out.println();

                        System.out.println("********_Admin Login_********");
                        System.out.print("\nEnter Admin USER NAME:");
                        String adminName = scanner.nextLine();
                        System.out.print("\nEnter Admin PASSWORD:");
                        String pass = scanner.nextLine();

                        if (admin.login(adminName, pass)) {
                            admin.mutateBuses();
                        }

                        break;

                case 5:
                    System.out.println("\nThank you for visting BusDotGo.\nHave a Great Day :)\n");
                    choice = false;
                    bookAgain = false;
                    break;

                default:
                    System.out.println("\nInvallid Option.\nPlease Enter Correct Option\n");
                    break;
            }
            
    }
            else{
                scanner.close();
                return;
            }
            
           
        }
        
    }

    private static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a number.");
            scanner.nextLine();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }
}
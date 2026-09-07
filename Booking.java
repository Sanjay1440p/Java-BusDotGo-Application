import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Booking {

    private long bookingId = 100000000L;
    private String name;
    private int age;
    private String phone;
    private int seatNo;
    private int busNo;
    private String seatType;

    private static Random random = new Random();
    private LocalDate travelDate;
    

    public Booking(String name, int age, String phone, int seatNo, int busNo,
                        String seatType, LocalDate travelDate){

        this.bookingId = 1000000000L + random.nextLong(9000000000L);

        this.name = name;
        this.age = age;
        this.phone = phone;
        this.seatNo = seatNo;
        this.busNo = busNo;
        this.seatType = seatType;
        this.travelDate = travelDate;

        
    }


    public long getBookingId(){
        return bookingId;
    }

    public void setBookingId(long bookingId){
        this.bookingId = bookingId;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public int getSeatNo(){
        return seatNo;
    }

    public void setSeatNo(int seatNo){
        this.seatNo = seatNo;
    }

    public int getBusNo(){
        return busNo;
    }
    public void setBusNo(int busNo){
        this.busNo = busNo;
    }

    public String getSeatType(){
        return seatType;
    }
    public void setSeatType(String seatType){
        this.seatType = seatType;
    }
    public LocalDate getTravelDate(){
        return travelDate;
    }

    public Booking readBookingData(Scanner scanner, ArrayList<Bus> buses){
        System.out.print("\nEnter Passenger Name: ");
        name = scanner.nextLine();
        
        System.out.print("\nEnter Passenger Age: ");
        age = readInt(scanner);

        System.out.print("\nEnter Passenger's Phone Number: ");
        phone = scanner.nextLine();

        System.out.print("\nEnter Bus Number: ");
        busNo = readInt(scanner);
        Bus selectedBus = findBus(buses, busNo);
        if (selectedBus == null) {
            System.out.println("Bus not found. Booking canceled.");
            return null;
        }

        System.out.print("\nEnter Seat Number: ");
        seatNo = readInt(scanner);
        if (seatNo < 1 || seatNo > selectedBus.getCapacity()) {
            System.out.println("Invalid seat number. Booking canceled.");
            return null;
        }
        if (!selectedBus.reserveSeat()) {
            System.out.println("This bus is full. Booking canceled.");
            return null;
        }

        System.out.print("\nEnter Seat Type(Adult/Child): ");
        seatType = scanner.nextLine();

        if(seatType.equalsIgnoreCase("adult")){
            
        }
        else if(seatType.equalsIgnoreCase("child")){
            if(age < 18){
                System.out.println("Seat type cannot be accepted due to the age gap.");
                return null;
            }
        }
        else{
            try{
            System.out.println("Wrong Seat Type");
            System.out.println("Your Booking is being Canceled...");
            Thread.sleep(3000);
            System.out.println("Canceled");
                return null;
            }catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                e.printStackTrace();
                    return null;
            }
            
        }
        System.out.print("\nEnter Date in Format of (dd-MM-yyyy): ");
                    String dtd = scanner.nextLine();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    this.travelDate = LocalDate.parse(dtd , formatter);

                    bookingId++;

                    System.out.println("---------------------------------------------------------");
                    System.out.println("Your Booking ID is " + getBookingId());
                    System.out.println("Booking Conformed :)");
                    System.out.println("---------------------------------------------------------");

                    return new Booking(name, age, phone, seatNo, busNo, seatType, travelDate);
       
    }

    private int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a number.");
            scanner.nextLine();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    private Bus findBus(ArrayList<Bus> buses, int busNumber) {
        for (Bus bus : buses) {
            if (bus.getBusNo() == busNumber) {
                return bus;
            }
        }
        return null;
    }

    public  void displayBookings(){
        
        System.out.println("----------------Booking Details----------------");
        System.out.println("Booking ID: " + getBookingId());
        System.out.println("Passenger Name: " + getName());
        System.out.println("Passenger Age: " + getAge());
        System.out.println("Phone Number: " + getPhone());
        System.out.println("Seat Number: " + getSeatNo());
        System.out.println("Seat Type: " + getSeatType());
        System.out.println("Date: " + travelDate);
        System.out.println("------------------------------------------------");
    }

}


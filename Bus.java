public class Bus {

    private int busNo;
    private String startPoint;
    private String destination;
    private int capacity;
    private int availableSeats;

    private String driverName;
    private String driverPhone;

    public Bus(int busNo, String startPoint, String destination, int capacity,
               int availableSeats, String driverName, String driverPhone) {

        this.busNo = busNo;
        this.startPoint = startPoint;
        this.destination = destination;
        this.capacity = capacity;
        this.availableSeats = availableSeats;

        this.driverName = driverName;
        this.driverPhone = driverPhone;
    }

    //Accessors Section
    public int getBusNo() {
        return busNo;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public String getDestination() {
        return destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public boolean reserveSeat() {
        if (availableSeats == 0) {
            return false;
        }
        availableSeats--;
        return true;
    }

    //Mutators Section
    public void SetBusNo(int busNo){
        this.busNo = busNo;
    }

    public  void SetStartPoint(String startPoint){
        this.startPoint = startPoint;
    }

    public void SetDestination(String destination){
        this.destination = destination;
    }

    public void SetCapacity(int capacity){
        this.capacity = capacity;
    }

    public void SetAvailableSeats(int availableSeats){
        this.availableSeats = availableSeats;
    }

    public void SetDriverName(String driverName){
        this.driverName = driverName;
    }

    public void SetDriverPhone(String driverPhone){
        this.driverPhone = driverPhone;
    }

    public void displayBus() {
        System.out.println("Bus Number: " + busNo);
        System.out.println("Route: " + startPoint + " -> " + destination);
        System.out.println("Capacity: " + capacity);
        System.out.println("Available Seats: " + availableSeats);
        System.out.println("Driver: " + driverName);
        System.out.println("Driver Phone: " + driverPhone);
        System.out.println("------------------------------------------------");

    }
}
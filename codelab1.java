public class codelab1<T> {
    private T bookingCode;
    private String passengerName;

    public codelab1(T bookingCode, String passengerName) {
        this.bookingCode = bookingCode;
        this.passengerName = passengerName;
    }

    public T getBookingCode() {
        return bookingCode;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void displayTicket(){
        System.out.println("\n=== Railway Ticket Information ===");
        System.out.println("Booking Code      : "+bookingCode);
        System.out.println("Passengger Name   : "+passengerName);
        System.out.println("Booking Code Type : "+bookingCode.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        codelab1<String> ticket1 = new codelab1<>("KA-001","Andi");
        codelab1<Integer> ticket2 = new codelab1<>(1002,"Budi");

        ticket1.displayTicket();
        ticket2.displayTicket();
    }
}


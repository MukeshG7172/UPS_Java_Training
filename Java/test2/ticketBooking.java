class TicketCounter {
    private int tickets;

    TicketCounter(int cnt) {
        tickets = cnt;
    }

    public synchronized void book(String customer, int count) {
        if(count <= tickets) {
            tickets -= count;
            System.out.println(customer + " booked " + count + " tickets");
        }
        else {
            System.out.println(customer + " - Booking failed!!");
        }
        System.out.println("Remaining tickets : " + tickets);
    }
}

class TicketBooking {
   public static void main(String[] args) {
        TicketCounter obj = new TicketCounter(10);

        Thread t1 = new Thread(() -> {
            obj.book("Customer 1", 5);
        });
        Thread t2 = new Thread(() -> {
            obj.book("Customer 2", 3);
        });
        Thread t3 = new Thread(() -> {
            obj.book("Customer 3", 6);
        });

        t1.start();
        t2.start();
        t3.start();
    } 
}

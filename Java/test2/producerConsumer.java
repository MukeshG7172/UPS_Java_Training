class Buffer {
    int curVal;
    boolean available = false;
    boolean finished = false;

    synchronized void produce (int n) throws InterruptedException {
        while(available) {
            wait();
        }

        curVal = n;
        available = true;
        System.out.println("Produced : " + curVal);
        notify();
    }

    synchronized boolean consume() throws InterruptedException {
        while(!available && !finished) {
            wait();
        }

        if(available){
            System.out.println("Consumed : " + curVal);
            available = false;
            notify();
            return true;
        }

        return false;
    }

    synchronized void finish() {
        finished = true;
        notifyAll();
    }
}

class Main {
    public static void main(String[] args) {
        Buffer b = new Buffer();

        Thread producer = new Thread(() -> {
            try {
                for(int i=1;i<=5;i++){
                    b.produce(i);         
                }
                b.finish();
            } catch (Exception e) {
                System.out.println(e);
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                while(b.consume()){}
            } catch (Exception e) {
                System.out.println(e);
            }
        });

        producer.start();
        consumer.start();
    }
}

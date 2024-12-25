
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class BarberShop {

    private static final int N = 10; // So ghe cho toi da
    private static final int TOTAL_CUSTOMERS = 20; // Tong so khach hang
    private static int waitingCustomers = 0;
    private static Semaphore mutex = new Semaphore(1);
    private static Semaphore haircut = new Semaphore(0); // Cho tin hieu tu tho cat toc
    private static Semaphore customers = new Semaphore(0); // So khach dang doi
    private static Random random = new Random();
    private static Queue<Customer> waitingQueue = new LinkedList<>();

    static class Customer implements Runnable {

        private int id;

        public Customer(int id) {
            this.id = id;
        }

        public void run() {
            try {
                // Khach den sau mot khoang thoi gian ngau nhien
                Thread.sleep(random.nextInt(5000));

                mutex.acquire();
                System.out.printf("Khach id %d vao cua hang, ", id);

                if (waitingCustomers >= N) {
                    System.out.printf("thay kin cho va roi di\n");
                    mutex.release();
                    return;
                }

                waitingCustomers++;
                waitingQueue.offer(this);
                System.out.printf("ngoi cho (Co tong cong %d khach dang cho)\n", waitingCustomers);
                mutex.release();

                customers.release(); // Bao hieu cho tho cat toc
                haircut.acquire(); // Cho tin hieu hoan thanh cat toc

                // Xong
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Barber implements Runnable {

        public void run() {
            while (true) {
                try {
                    System.out.println("Tho cat toc dang cho khach tiep theo");
                    customers.acquire(); // Doi khach hang
                    mutex.acquire();

                    Customer servingCustomer = waitingQueue.poll();
                    waitingCustomers--; // Giam so khach dang cho
                    System.out.printf("Tho bat dau phuc vu khach id %d (%d khach con lai dang cho)\n", servingCustomer.id, waitingCustomers);

                    mutex.release();

                    // Toi gian cat toc
                    Thread.sleep(random.nextInt(3000) + 2000);

                    System.out.printf("Tho hoan thanh cat toc cho khach id %d!\n", servingCustomer.id);
                    haircut.release(); // Thong bao khach hang da xong

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread barberThread = new Thread(new Barber());
        barberThread.start();

        // Tao nhieu luong khach hang
        Thread[] customerThreads = new Thread[TOTAL_CUSTOMERS];
        for (int i = 0; i < TOTAL_CUSTOMERS; i++) {
            customerThreads[i] = new Thread(new Customer(i));
            customerThreads[i].start();
        }

        // Doi tat ca khach hang hoan thanh
        try {
            for (Thread customer : customerThreads) {
                customer.join();
            }
            // Ket thuc chuong trinh sau khi hoan thanh phuc vu tat ca cac khach
            System.out.println("\nHet khach, cua hang dong cua!");
            System.exit(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package Question3;

public class Question3_B {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                System.out.println("Active Thread class ");
                Thread.sleep(5000);
                System.out.println("Thread1 active  after sleep");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Active Thread class 2 ");
            for (int i = 0; i < 5; i++) {
                System.out.println(i + "  " + Thread.currentThread().getName());
            }
        });

        Thread t3 = new Thread(() -> {
            System.out.println("Active Thread class 3 ");
            for (int i = 0; i < 5; i++) {
                System.out.println(i + "  " + Thread.currentThread().getName());
            }
        });

        t1.start();
        try {
            t1.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        t3.start();


    }
}

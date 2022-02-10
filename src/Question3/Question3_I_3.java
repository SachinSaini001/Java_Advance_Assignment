package Question3;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class Question3_I_3 extends Thread {

    public Question3_I_3() {
    }

    public void run() {

        for (int i = 5; i >= 0; i--) {

            System.out.println(Thread.currentThread().getName() + "==running with fixed delay");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);

        Question3_I_3 clock1 = new Question3_I_3();
        Question3_I_3 clock2 = new Question3_I_3();
        Question3_I_3 clock3 = new Question3_I_3();

        scheduler.scheduleWithFixedDelay(clock1, 3, 10, TimeUnit.SECONDS);
        scheduler.scheduleWithFixedDelay(clock2, 3, 15, TimeUnit.SECONDS);
        scheduler.scheduleWithFixedDelay(clock3, 3, 20, TimeUnit.SECONDS);

    }
}
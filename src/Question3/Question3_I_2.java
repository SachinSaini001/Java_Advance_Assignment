package Question3;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Question3_I_2 implements Runnable {

    public void run() {
        System.out.println("Scheduler run after fixed rate");
    }

    public static void main(String[] args) {
        ScheduledExecutorService scheduler
                = Executors.newSingleThreadScheduledExecutor();


        Runnable task = new Question3_I_2();
        int initialDelay = 4;
        int periodicDelay = 2;

        scheduler.scheduleAtFixedRate(task, initialDelay, periodicDelay,
                TimeUnit.SECONDS);
    }
}


package Question3;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Question3_J extends Thread {
    private final String clockName;

    public Question3_J(String clockName) {
        this.clockName = clockName;
    }

    public void run() {
        for (int i = 5; i >= 0; i--) {
            System.out.println(Thread.currentThread().getName() + "->" + clockName + ":" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //ExecutorService pool = Executors.newCachedThreadPool();                        //used for cached threadPool
        ExecutorService pool = Executors.newFixedThreadPool(2);                       //used for Fixed threadPool
        pool.execute(new Question3_J("A"));
        pool.execute(new Question3_J("B"));
        pool.execute(new Question3_J("C"));
        pool.execute(new Question3_J("D"));
        pool.shutdown();
    }
}
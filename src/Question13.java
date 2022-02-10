import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class Cube implements Runnable {

    int x;

    public Cube(int x) {
        this.x = x;
    }

    @Override
    public void run() {
        System.out.println("Cube of the number = " + x * x * x);
    }
}

class Square implements Runnable {
    int x;

    public Square(int x) {
        this.x = x;
    }

    @Override
    public void run() {
        System.out.println("Square of the number = " + x * x);

    }
}

class Question13 {
    public static void main(String[] args) {
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        exec.scheduleAtFixedRate(() -> {
            Random random = new Random();
            int num = random.nextInt(1000);
            System.out.println("Random Integer = " + num);
            if (num % 2 == 0) {
                Square obj = new Square(num);
                obj.run();
            } else {
                Cube obj = new Cube(num);
                obj.run();
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

}
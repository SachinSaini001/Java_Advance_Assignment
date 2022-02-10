package Question3;

public class Question3_K {
    private int n = 10;

    private synchronized void increment() {
        this.n++;
    }

    private synchronized void decrement() {
        this.n--;
    }

    public static void main(String[] args) throws InterruptedException {
        Question3_K sync = new Question3_K();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 800; i++) {
                sync.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 800; i++) {
                sync.decrement();
            }
        });
        t1.start();
        t2.start();
        System.out.println(sync.n);
    }
}
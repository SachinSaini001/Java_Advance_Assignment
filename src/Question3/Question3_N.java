package Question3;


public class Question3_N {
    private final Object lock = new Object();

    public static void main(String[] args) {
        Question3_N thread = new Question3_N();
        new Thread(() -> {
            try {
                synchronized (thread.lock) {
                    System.out.println("thread 1");
                    Thread.sleep(500);
                    thread.lock.wait();
                    System.out.println("back to thread 1  after completion thread 2");

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                synchronized (thread.lock) {
                    System.out.println("thread 2");
                    Thread.sleep(500);
                    thread.lock.notify();
                    System.out.println("thread 2 still active after notify call because first it complete the remaining execution");
                    System.out.println("thread 2 active");
                    System.out.println("thread 2 active");
                    System.out.println("thread 2 active");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
package Question3;

public class Question3_A {
    public static void main(String[] args) {
        new ThreadClass().start();
        new Thread(new ThreadClass2()).start();
    }
}

class ThreadClass extends Thread {
    public void run() {
        System.out.println("active_Thread class ");
    }
}

class ThreadClass2 implements Runnable {
    public void run() {
        System.out.println("active_runnable interface");
    }
}
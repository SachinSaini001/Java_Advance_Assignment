package Question3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Question3_F {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> future = executorService.submit(() -> {
            Thread.sleep(1000);
            return "return value successfully";
        });
        System.out.println("Main Thread Running");
        executorService.shutdown();
        System.out.println("future is cancelled : " + future.isCancelled());

        while (!future.isDone()) {
            System.out.println("Main Thread waiting for the response");
            Thread.sleep(1000);
        }

        System.out.println("Main Thread got the response");
        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}

package Question3;

import java.util.concurrent.*;
        import java.util.*;
public class Question3_G{

    public Question3_G(){
        class MyCallable implements Callable<Integer>{
            final Integer id;
            public MyCallable(Integer val){
                this.id = val;
            }
            public Integer call(){
                return id;
            }
        }
        System.out.println("creating List");
        ExecutorService service = Executors.newFixedThreadPool(3);

        List<MyCallable> futureList = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            MyCallable myCallable = new MyCallable(i);
            futureList.add(myCallable);
        }
        System.out.println("Processing Start");
        try{
            List<Future<Integer>> futures = service.invokeAll(futureList);
        } catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Processing Completed");
        service.shutdown();
    }

    public static void main(String []args){
    new  Question3_G();
    }
}

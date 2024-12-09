package ThreadScheduling;

import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        //Schedule a Callable task
        Callable<String> task = () -> {
            return "Task completed after delay!";
        };

        ScheduledFuture<String> result = scheduler.schedule(task, 3, TimeUnit.SECONDS);

        try {
            //Get the result after the delay
            System.out.println("Waiting for task to complete...");
            System.out.println(result.get()); //This blocks until the result is available
        }
        catch (InterruptedException | ExecutionException e){
            System.out.println("Error occurred while executing task.");
            e.printStackTrace();
        }

        //Shutdown the scheduler
        scheduler.shutdown();
    }
}

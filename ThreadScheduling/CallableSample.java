package ThreadScheduling;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.*;

public class CallableSample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        //What does this look like without the lambda expression
        Callable<String> callabletask = () -> {
            String threadName = Thread.currentThread().getName();
            String formattedTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            return "Hello from " + threadName + " at " + formattedTime;
        };

        System.out.println("Scheduling Callable...");
        Future<String> futureResult = scheduler.schedule(callabletask,3, TimeUnit.SECONDS);

        try {
            //Retrieve the result of the Callable after it executes
            String result = futureResult.get(); //Blocks until the Callable finishes
            System.out.println("Result from Callable: " + result);
        }
        catch (InterruptedException | ExecutionException e){
            System.out.println("Error occurred: " + e.getMessage());
        }
        finally {
            //Shutdown the scheduler
            scheduler.shutdown();
        }
    }
}

package ThreadScheduling;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        //Schedule a task to run after 5-second delay
        scheduler.schedule(() -> {
            System.out.println("task executed after 5 seconds!");
        }, 5, TimeUnit.SECONDS);

        //Shutdown the scheduler (with a delay to allow the task to complete)
        scheduler.schedule(() -> {
            System.out.println("Scheduler shutting down...");
            scheduler.shutdown();
        }, 6, TimeUnit.SECONDS);
    }
}

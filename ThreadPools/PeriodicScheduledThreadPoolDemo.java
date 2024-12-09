package ThreadPools;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PeriodicScheduledThreadPoolDemo {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        scheduler.scheduleAtFixedRate(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Periodic task executed by " + threadName);
        }, 2, 3, TimeUnit.SECONDS); //Starts after 2 seconds, repeats every 3 seconds

        scheduler.schedule(() -> {
            System.out.println("Shutting down scheduler...");
            scheduler.shutdown();
        }, 15, TimeUnit.SECONDS);
    }
}

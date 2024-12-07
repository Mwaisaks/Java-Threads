package ThreadScheduling;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FixedDelayExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        //Schedule a task to run with a fixed delay
        scheduler.scheduleWithFixedDelay(() -> {
            System.out.println("Task running with fixed delay: " + //System.currentTimeMillis());
                    new SimpleDateFormat(("HH:mm:ss").format(String.valueOf(new Date())));
        }, 2, 3, TimeUnit.SECONDS);

        //Stop the scheduler after 15 seconds
        scheduler.schedule(() -> {
            System.out.println("Scheduler shutting down...");
            scheduler.shutdown();
        }, 15, TimeUnit.SECONDS);
    }
}

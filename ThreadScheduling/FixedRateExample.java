package ThreadScheduling;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FixedRateExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        //Schedule a task torun at a fixed rate
        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Task running at fixed rate: " + //System.currentTimeMillis());
                    new SimpleDateFormat("HH:mm:ss").format(new Date()));
        }, 2, 3, TimeUnit.SECONDS);

        //Stop the scheduler after 10 seconds
        scheduler.schedule(() -> {
            System.out.println("Scheduler shutting down...");
            scheduler.shutdown();
        }, 10, TimeUnit.SECONDS);
    }
}

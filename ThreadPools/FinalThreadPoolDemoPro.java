package ThreadPools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FinalThreadPoolDemoPro {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        ThreadPoolExecutor pool = (ThreadPoolExecutor) executor; //For monitoring

        System.out.println("Before Task Execution:");
        printThreadPoolStats(pool);

        //Submit tasks
        for (int i = 1; i <= 5; i++){
            final int taskId = i;
            executor.submit(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.println("Task " + taskId + " executed by " + threadName);
                try{
                    Thread.sleep((long) (Math.random() * 3000)); //Why not just assign the time normally, explain this line of code
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            });
        }

        System.out.println("After task submission: ");
        printThreadPoolStats(pool);

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS); //Wait upto 10 seconds
        System.out.println("All tasks completed.");
    }

    private static void printThreadPoolStats(ThreadPoolExecutor pool){
        System.out.println("Core threads: " + pool.getCorePoolSize());
        System.out.println("Largest pool size: " + pool.getLargestPoolSize());
        System.out.println("Currently active threads: " + pool.getActiveCount());
        System.out.println("Total tasks submitted: " + pool.getTaskCount());
    }
}

/*
The code above is a improvised code for the code below

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThread {

   public static void main(final String[] arguments) throws InterruptedException {
      ExecutorService executor = Executors.newFixedThreadPool(2);

      // Cast the object to its class type
      ThreadPoolExecutor pool = (ThreadPoolExecutor) executor;

      //Stats before tasks execution
      System.out.println("Largest executions: "
         + pool.getLargestPoolSize());
      System.out.println("Maximum allowed threads: "
         + pool.getMaximumPoolSize());
      System.out.println("Current threads in pool: "
         + pool.getPoolSize());
      System.out.println("Currently executing threads: "
         + pool.getActiveCount());
      System.out.println("Total number of threads(ever scheduled): "
         + pool.getTaskCount());

      executor.submit(new Task());
      executor.submit(new Task());
	  executor.submit(new Task());
      executor.submit(new Task());

      //Stats after tasks execution
      System.out.println("Core threads: " + pool.getCorePoolSize());
      System.out.println("Largest executions: "
         + pool.getLargestPoolSize());
      System.out.println("Maximum allowed threads: "
         + pool.getMaximumPoolSize());
      System.out.println("Current threads in pool: "
         + pool.getPoolSize());
      System.out.println("Currently executing threads: "
         + pool.getActiveCount());
      System.out.println("Total number of threads(ever scheduled): "
         + pool.getTaskCount());

      executor.shutdown();
   }

   static class Task implements Runnable {

      public void run() {

         try {
            Long duration = (long) (Math.random() * 5);
            System.out.println("Running Task! Thread Name: " +
               Thread.currentThread().getName());
               TimeUnit.SECONDS.sleep(duration);

            System.out.println("Task Completed! Thread Name: " +
               Thread.currentThread().getName());
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
}
 */

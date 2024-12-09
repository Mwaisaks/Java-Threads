package ThreadPools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        //Submit tasks to the thread pool
        for (int i = 1; i <= 5; i++){
            int taskNumber = i;
            threadPool.submit(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.println("Task " + taskNumber + " executed by " + threadName);
                try{
                    Thread.sleep(2000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            });
        }

        threadPool.shutdown();
    }
}

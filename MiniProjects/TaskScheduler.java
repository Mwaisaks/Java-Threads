package MiniProjects;

import java.util.Random;

public class TaskScheduler {
    public static void main(String[] args) {
        int numberOfTasks = 5;
        Thread[] threads = new Thread[numberOfTasks];
        Random random = new Random();

        for (int i = 0; i < numberOfTasks; i++){
            //Create a task
            Runnable task = () -> {
                Thread currentThread = Thread.currentThread();
                int randomPriority = random.nextInt(10) + 1;
                currentThread.setPriority(randomPriority);

                System.out.println("Thread ID: " + currentThread.getId() +
                        ", Priority: " + currentThread.getPriority() +
                        " is starting...");

                try{
                    int sleepTime = random.nextInt(3) + 1;
                    Thread.sleep(sleepTime * 1000);
                } catch (InterruptedException e) {
                    System.out.println("Thread ID: " + currentThread.getId() +
                            " was interrupted.");
                }
                System.out.println("Thread ID: " + currentThread.getId() +
                        " completed execution.");
            };

            //Create thread and add to the array
            threads[i] = new Thread(task);
        }

        //start all threads
        for (Thread thread : threads){
            thread.start();
        }

        //wait for all threads to finish
        for (Thread thread : threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted.");
            }
        }

        System.out.println("\nAll tasks have completed execution.");
    }
}

class Task implements Runnable{
    String taskName;

    Task(String threadName){
        this.taskName = threadName;
    }

    @Override
    public void run(){
        for (int i = 1; i <= 5; i++){
            System.out.println(taskName + " - Count: " + i );
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                System.out.println(taskName + " interrupted!");
            }
        }
        System.out.println(taskName + " completed.");
    }
}

public class Demo1 {
    public static void main(String[] args) {
        System.out.println("Main Thread starting.");

        //Create Runnable tasks
        Task task1 = new Task("Task 1");
        Task task2 = new Task("Task 2");

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();
    }
}

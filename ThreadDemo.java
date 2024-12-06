//Create a MyThread class extends Thread
//variables, constructor and override the run method
class MyThread extends Thread{
    String threadName ;

    MyThread(String threadName){
        this.threadName = threadName;
    }

    @Override
    public void run(){
        for (int i = 1; i <= 5; i++){
            System.out.println(threadName + " - Count: " + i);
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e){
                System.out.println(threadName + " interrupted!");
            }
        }
        System.out.println(threadName + " completed.");
    }
}

//instances of MyThread, start()
public class ThreadDemo {
    public static void main(String[] args) {
        System.out.println("Main thread starting.");

        MyThread thread1 = new MyThread("Thread 1");
        MyThread thread2 = new MyThread("Thread 2");

        thread1.start();
        thread2.start();

        for (int i = 1; i <= 5; i++){
            System.out.println("Main thread - Count: " + i);
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                System.out.println("Main thread interrupted!");
            }
        }

        System.out.println("Main thread complete!");
    }

}

/*
Comparison with Runnable

When to use Runnable:
If your class already extends another class, as Java doesn’t support multiple inheritance.
To separate the thread logic (Runnable) from the thread behavior (Thread).

When to extend Thread:
If you don't need to extend any other class and want to directly define thread behavior.
Using Runnable is generally preferred for better design and flexibility.
 */
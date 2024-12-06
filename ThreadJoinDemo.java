class MyThread2 extends Thread{
    private String threadName;

    public MyThread2(String threadName){
        this.threadName = threadName;
    }

    @Override
    public void run(){
        System.out.println(threadName + " starting.");
        try {
            for (int i = 1; i <= 3; i++){
                System.out.println(threadName + " - Count: " + i);
                Thread.sleep(1500);
            }
        }
        catch (InterruptedException e){
            System.out.println(threadName + " interrupted!");
        }
        System.out.println(threadName + " completed.");
    }
}

public class ThreadJoinDemo {
    public static void main(String[] args) {
        MyThread2 thread1 = new MyThread2("Thread 1");
        MyThread2 thread2 = new MyThread2("Thread 2");

        thread1.start();
        thread2.start();

        try {
            System.out.println("Main thread waiting for Thread 1 to finish.");
            thread1.join();
            System.out.println("Thread has finished. Main thread waiting for Thread 2.");
            thread2.join();
        }
        catch (InterruptedException e){
            System.out.println("Main thread interrupted!");
        }

        System.out.println("Main thread completed.");
    }
}

/*
join()

 */

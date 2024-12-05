//Create a MyThread class extends Thread
//variables, constructor and override the run method

//instances of MyThread, start()
public class ThreadDemo {
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
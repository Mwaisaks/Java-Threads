Java Threads

Thread Scheduling
SchedulerExecutorService - a sub-interface of ExecutorServoce in the java.util.concurrent package provides methods which allow scheduling of tasks to run after a delay or periodically.

Keys Methods
1. schedule(Runnable command, long delay, TimeUnit unit)
   -executes a task after a specified delay
   command: the task to execute(must implement Runnable or Callable)
   delay: delay before the task starts
   unit: time unit for the delas(TimeUnit.SECONDS)
   -Returns :A ScheduledFuture<?> object representing the pending result of the task.

Sample;
scheduler.schedule(() -> System.out.println("Task executed after delay"), 5, TimeUnit.SECONDS);

2. schedule(Callable<V> callable, long delay, TimeUnit unit)
   -executes a Callable task once after a specified delay, allowing it to return a result.
   callable: The task to execute.
   delay: Delay before the task starts.
   unit: Time unit for the delay.
   Returns: A ScheduledFuture<V> representing the result of the task.
   
Sample;
ScheduledFuture<Integer> result = scheduler.schedule(() -> 42, 3, TimeUnit.SECONDS);
System.out.println("Result: " + result.get());

3.scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit)
-executes a task repeatedly at a fixed rate
    command: The task to execute.
    initialDelay: Delay before the first execution.
    period: Time between consecutive executions.
    unit: Time unit for the delay and period.
-Tasks are scheduled at a fixed interval, regardless of their execution time
Returns: A ScheduledFuture<?>

Sample:
scheduler.scheduleAtFixedRate(() -> System.out.println("Task running at fixed rate"), 1, 2, TimeUnit.SECONDS);

4.scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit)
-Executes a task repeatedly with a fixed delay between the end of one execution and the start of the next week
    command: The task to execute.
    initialDelay: Delay before the first execution.
    delay: Delay between consecutive executions.
    unit: Time unit for the delay.
-Ensures a consistent delay between task completions and the start of the next execution

Common TimeUnit Constants
TimeUnit.MILLISECONDS: Milliseconds.
TimeUnit.SECONDS: Seconds.
TimeUnit.MINUTES: Minutes.
TimeUnit.HOURS: Hours.

Best Practices
Shutdown Scheduler: Always call shutdown() to release resources after tasks are completed.
Exception Handling: Wrap tasks in try-catch blocks to avoid exceptions crashing the scheduler.
Thread Pool Size: Use an appropriate pool size based on the workload to avoid overloading or under-utilizing threads.
Periodic Task Timing: Choose between scheduleAtFixedRate and scheduleWithFixedDelay based on whether you want fixed intervals or delays

Thread Pools
-A collection of pre-initialised threads
How it works - a variety of threads are formed and placed in apool where they sit and wait for work. Once a server receives a call for participation, it awakens a thread (if one's available) and passes it the request for service. When the thread serves it's purpose , it's returned to the pool to await for another task. If the pool contains no accessible threads , the server waits until one becomes free.

Why Use Thread Pools?
~saves time; no need to create new thread.
It is utilised in Servlet and JSP wherever instrunmentality creates a thread pool to method the request.

To create Thread Pools in Java use methods from the java.util.concurrent.Executors class

this repository was created to review Threads in Java in preparation of our Saturday Session at Kenya JUG

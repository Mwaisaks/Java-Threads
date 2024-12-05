Java multithreading
def
life cycle of a thread
Thread Priorities ~helps determine the order
MIN_PRIORITY (a constant of 1)
MAX_PRIORITY (a constant of 10)
NORM_PRIORITY (constant of 5)

-cannot guarantee the order, platform dependent

Create A thread using Runnable interface
If your class is intended to be executed as a thread then you can achieve this by implementing a Runnable interface.

The join() method

Points To Note
the start() extends a call to the run() method
Understanding synchronized in Java
The synchronized keyword is used in Java to control access to a shared resource by multiple threads. 
It ensures mutual exclusion, meaning only one thread can access the synchronized block or method at a time.

Uses of synchronized:
Synchronized Methods:
Entire methods can be synchronized. Only one thread can execute the method on a specific object at a time.
Example:

public synchronized void methodName() {
// Critical section
}

Synchronized Blocks:
Synchronize only a specific block of code rather than the whole method, offering finer control.
Example:

public void methodName() {
synchronized (this) {
// Critical section
}
}
Static Synchronization:

Used to lock a class-level resource, ensuring only one thread can access it, regardless of the object instance.
Example:

public static synchronized void methodName() {
// Critical section
}

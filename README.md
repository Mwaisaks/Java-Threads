Java Threads

Thread Pools
-A collection of pre-initialised threads
How it works - a variety of threads are formed and placed in apool where they sit and wait for work. Once a server receives a call for participation, it awakens a thread (if one's available) and passes it the request for service. When the thread serves it's purpose , it's returned to the pool to await for another task. If the pool contains no accessible threads , the server waits until one becomes free.

Why Use Thread Pools?
~saves time; no need to create new thread.
It is utilised in Servlet and JSP wherever instrunmentality creates a thread pool to method the request.

To create Thread Pools in Java use methods from the java.util.concurrent.Executors class

this repository was created to review Threads in Java in preparation of our Saturday Session at Kenya JUG

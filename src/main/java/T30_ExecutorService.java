import java.util.concurrent.*;

public class T30_ExecutorService<K,V> {

    public  static void main(String[] args){
        /**
         * 10 thread instance created and executing task.
         */
//        for (int i = 0; i < 10; i++) {
//            Thread t = new Thread(new Task1());
//            t.start();
//        }
        /**
         * Create fixed no of threads and submit/execute tasks! -- Best way!
         * Executor- interface , Executors - class
         */

        // Ideal size of threads == No of cores in CPU --> Bcz the number of cores in the CPU. if the tasks perform with the help of CPU,
        // if there are so many threads,CPU will jump into "Time scheduling" for each task!
//        ExecutorService es = Executors.newFixedThreadPool(10);
        int coreCount = Runtime.getRuntime().availableProcessors();
//        ExecutorService es = Executors.newFixedThreadPool(coreCount);
//        ExecutorService es = Executors.newCachedThreadPool();
        /**
         * Scheduled task
         */
        ScheduledExecutorService es = Executors.newScheduledThreadPool(10);

        // Schedule a task to run after 10 seconds delay. This only runs once.
//        es.schedule(new Task1(),10, TimeUnit.SECONDS);
//        //Initial delay is 15, then run the tasks repeatedly 10 seconds after the previous task.
//        es.scheduleAtFixedRate(new Task1(),15,10,TimeUnit.SECONDS);
//        // task period does not matter. initially wait 15 min,after completing task delays 10 seconds and start next task.
//        es.scheduleWithFixedDelay(new Task1(),15,10,TimeUnit.SECONDS);

        // submitting tasks
        Future<Integer> ii = es.submit(new Task1());
        System.out.println("Main name: "+ Thread.currentThread().getName());
    }

}

class Task1 implements Callable<Integer>{

//    @Override
//    public void run() {
//        System.out.println("T name: "+ Thread.currentThread().getName());
//    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(3000);
        return 3;
    }
}

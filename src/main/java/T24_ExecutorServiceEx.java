import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class T24_ExecutorServiceEx {

    private int sheepCount = 0;
    private  Integer lock = new Integer(6);
    private void incrementAndReport() {
        synchronized (T24_ExecutorServiceEx.class){ // or use this
//            lock++; // Although we didn’t need to make the lock variable final, doing so ensures that it is not
//reassigned after threads start using it.
            System.out.print((sheepCount++)+" ");
        }
    }


    static String sLock = "testLock";
    public static void printDaysWork(){
        synchronized (T24_ExecutorServiceEx.class){
            System.out.println("Finished work!");
        }
    }
    // both are same!
//    public static synchronized void printDaysWork() {
//        System.out.print("Finished work");
//    }
//
    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            /**
             *     This method won't work!
             *     for(int i=0; i<10; i++)
             *                 synchronized (new T24_ExecutorServiceEx()){
             *                     service.submit(() -> manager.incrementAndReport()); // submit() / execute()
             *
             *     }}
             *
             *     Future<?> submit(Runnable task);
             */
            service = Executors.newFixedThreadPool(20);
            T24_ExecutorServiceEx manager = new T24_ExecutorServiceEx();
            for(int i=0; i<10; i++){
                        service.submit(() -> manager.incrementAndReport()); // submit() / execute()
            }
        } finally {
            if(service != null) service.shutdown();
        }
    }

}

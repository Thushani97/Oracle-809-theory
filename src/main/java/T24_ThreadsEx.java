import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Threader extends Thread {
    public void run()     {
        System.out.println("In Threader");
    }
}
class Pooler extends Thread {
    public Pooler(){ }
    public Pooler(Runnable r)     {
        super(r);  //1
    }
    public void run()     {
        System.out.println("In Pooler");
    }
}

public class T24_ThreadsEx implements Runnable{
    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println("begin");
            service.execute(() -> System.out.println("Printing zoo inventory"));
            service.execute(() -> {for(int i=0; i<3; i++)
                System.out.println("Printing record: "+i);}
            );
            service.execute(() -> System.out.println("Printing zoo inventory"));
            System.out.println("end"); // Since main method also a thread, we can not grant the order of the output!
        } finally {
            if(service != null) service.shutdownNow();
        }
        /**
         * OUTPUT-->
         * begin
         * Printing zoo inventory
         * Printing record: 0
         * Printing record: 1
         * Printing record: 2
         * end
         * Printing zoo inventory
         */
//    volatile int x ;
//    public static void main(String[] args) {
//        T24_ThreadsEx t1 = new T24_ThreadsEx();
//        t1.x=10;
//
////        (new Thread(new T24_ThreadsEx())).start();
//        (new Thread(t1)).start();  // we have 2 threads running, the main thread and the one we just started!!
//        System.out.println(t1.x);

     }

    @Override
    public void run() {
//        x=5;
//        for (int i = 0; i < 3; i++) {
//            System.out.println("hi"+i);
//        }
    }
}

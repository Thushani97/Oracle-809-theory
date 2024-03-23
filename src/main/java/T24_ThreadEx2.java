/**
 * DeadLock example, since obj1, obj2 not synchronized in proper order!!
 */

//public class T24_ThreadEx2 extends Thread{
//    static Object obj1 = new Object();
//    static Object obj2 = new Object();
//    public void m1() {
//        synchronized(obj1)    {
//            System.out.print("1 ");
//            synchronized(obj2)      {
//                System.out.println("2");
//            }
//        }
//    }
//
//    public void m2() {
//        synchronized(obj1)    {
//            System.out.print("2 ");
//            synchronized(obj2)      {
//                System.out.println("1");
//            }
//        }
//    }
//    public void run() {
//        m1();
//        m2();
//    }
//    public static void main(String[] args) {
//        new T24_ThreadEx2().start(); // thread 2
//        new T24_ThreadEx2().start();
//     }
//
//}

/**
 * Use synchronized with run() --> output can not be determined although they are static/ volatile / instance variables
 */

//public class T24_ThreadEx2 extends Thread {
//    volatile static int x, y;
//    public synchronized void run(){
//        for(;;){ x++; y++;
//            System.out.println(x+" "+y);
//        }
//    }
//    public static void main(String[] args) {
//        new T24_ThreadEx2().start();
//        new T24_ThreadEx2().start();
//    }
//}

//public class T24_ThreadEx2 extends Thread {
//     Object obj = new Object(); // can use static object or non-static object
//     int x, y; public void run() {
//        synchronized(obj)    {
//            for(;;)      {
//                x++; y++;
//                System.out.println(x+" "+y);
//            }
//        }
//    }
//    public static void main(String[] args) {
//        new T24_ThreadEx2().start();
//        new T24_ThreadEx2().start();
//
//    }
//}

/**
 * The final value of threadcounter just before the program terminates may be less than 10.
 * Total of 10 numbers will be printed
 */
//public class T24_ThreadEx2 extends Thread {
//    private static int threadcounter = 0;
//    public void run()    {
//        threadcounter++;
//        System.out.println(threadcounter);
//    }
//    public static void main(String[] args) throws Exception    {
//        for(int i=0; i<10; i++)       {
//            synchronized(T24_ThreadEx2.class)          {
//                new T24_ThreadEx2().start();
//            }
//        }
//    }
//}

/**
 * does not terminate unless setDoemon(ture). But this not grant that the thread definetly terminate.
 */
//public class T24_ThreadEx2 extends Thread {
//    public void run()    {
//        for(;;);
//    }
//    public static void main(String args[])    {
//        System.out.println("Starting Main");
////        new T24_ThreadEx2().start(); // then this will
//        T24_ThreadEx2 t1 = new T24_ThreadEx2();
//        t1.setDaemon(true);
//        t1.start();
//        System.out.println("Main returns");
//    }
//}

/**
 * the scheduling of thread using priorities which is a bad idea. Simply because operating systems behave differently about priorities
 */
//class T24_ThreadEx2 extends Thread {
//    String id = "";
//    public T24_ThreadEx2(String s){
//        this.id = s;
//    }
//    public void run()    {
//        System.out.println(id+" End");
//    }
//    public static void main(String args [])    {
//        Thread t1 = new T24_ThreadEx2("AAA");
//        t1.setPriority(Thread.MIN_PRIORITY);
//        Thread t2 = new T24_ThreadEx2("BBB");
//        t2.setPriority(Thread.MAX_PRIORITY);
//        t1.start(); t2.start();
//    }
//}

class MyRunnable extends Thread {
    MyRunnable(String name)    {
        new Thread(this, name).start();    }
    public void run()    {
        System.out.println("Starting current thread..");
        System.out.println(Thread.currentThread().getName());    } }
public class T24_ThreadEx2 {
    public static void main(String[] args)    {
        Thread.currentThread().setName("MainThread");
        MyRunnable mr = new MyRunnable("MyRunnable");
        Thread t = new Thread(mr);
        mr.run();
        new Thread(mr).start();
    } }


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

class T27_AutoCloseable implements AutoCloseable{
    public void close() throws IllegalStateException {
        throw new IllegalStateException("Cage door does not close");
    }
    public static void main(String args [])    {


        try (T27_AutoCloseable t = new T27_AutoCloseable()) {
            System.out.println("put turkeys in");
        } catch (IllegalStateException e) {
            System.out.println("caught: " + e.getMessage());
        }
    }


}

class A {
    private int i;
    public void modifyOther(A a1)   {
        int x = new A().i;
        new A().i=34;
        i=45;
        a1.i = 20;     }
         }
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

import java.io.*;

class T25_FileHandling extends Thread {

    public static void main(String args []) throws IOException {
        File file1 = new File("C:\\Users\\THUSHANI\\Desktop\\Thushani\\CV\\Asitha\\Asitha_Indrajith_New.pdf");
        File parent = new File("C:\\Users\\THUSHANI\\Desktop");
        File child = new File(parent,"Thushani\\CV\\Asitha\\Asitha_Indrajith_New.pdf");
        File path1 = new File(parent,"Thushani\\CV\\Asitha\\NewCV\\test.txt");
        System.out.println(child.exists());// return type - boolean -->ture
        System.out.println(path1.mkdir());//mkdir() can only create the last component of a path. It cannot create a directory structure. For that you must use mkdirs(
        System.out.println(path1.mkdirs());// Creates the directory named by this path including any nonexistent parent directories.
        System.out.println(child.getName());// return name of the file --> Asitha_Indrajith_New.pdf
        System.out.println(child.getAbsolutePath());// return file path --> C:\Users\THUSHANI\Desktop\Thushani\CV\Asitha\Asitha_Indrajith_New.pdf
        System.out.println(child.isDirectory());// return true if the file denoted by this path is a directory
        System.out.println(child.length());//Returns the number of bytes in the file. For performance reasons, the file system may allocate more bytes on disk than the file actually uses
        System.out.println(child.lastModified());// Returns the number of milliseconds since the epoch when the file was last modified.
        System.out.println(child.getParent());// Returns path to parent --> C:\Users\THUSHANI\Desktop\Thushani\CV\Asitha
        System.out.println(child.renameTo(new File("C:\\Users\\THUSHANI\\Desktop\\Thushani\\CV\\Asitha\\Asitha_new.pdf")));// Returns the number of milliseconds since the epoch when the file was last modified.

        /**
         * BufferedReader is a high level stream. Buffered classes read or write data in groups, rather than a single byte or character at a time.
         *
         * FileReader is a low level stream.
         */
        BufferedReader br1 = new BufferedReader(new FileReader("C:\\Users\\THUSHANI\\Desktop\\Thushani\\CV\\Asitha\\test.txt"));
        System.out.println(br1.readLine());

//        new BufferedInputStream(new FileInputStream("fkldf")); // new FileReader("");
//        new BufferedWriter(new FileWriter("er"));

        FileWriter fw = new FileWriter("java_test.txt");
        BufferedWriter bfw = new BufferedWriter(fw);
//        bfw.writeUTF("hello");  //1
        bfw.newLine();  //2
         bfw.write("world");  //3
        fw.write("12345678");
        System.out.println();
        fw.close();


        try(FileInputStream fis = new FileInputStream("java_test.txt");
            InputStreamReader isr = new InputStreamReader(fis)){

            while(isr.ready()){
                isr.skip(1);
                int i = isr.read();
                System.out.println(i);
                char c = (char) i;
                System.out.println(c );
            }
        }

    }
}
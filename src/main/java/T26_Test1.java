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
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

class T26_Test1 extends Thread {
    public void m1(List<? super Number> list)     {
        Objects n = (Objects) list.get(0);
        list.add(34.43);
        list.add(34);
        list.add(34L);
//        Number i = list.get(0);
    }
    public static void main(String args []) throws IOException {



        List<Integer> ls = Arrays.asList(1, 2, 3);
        ls.stream()
                .map(MyProcessor::new)//  .map(p-> new MyProcessor(p))
                .forEach(MyProcessor::process);//     .forEach(item-> item.process());


        String[] p = {"1", "2", "3" };
        List<?> list2 = new ArrayList<>(Arrays.asList(p));
        list2.add(null);
        //list2 is a list of any thing. You cannot add any thing to it and you can only retrieve Objects from it:
//        list2.add(new Object());
//        list2.add("34");
        System.out.println(list2);

        List<Movie> movies = Arrays.asList(
                new Movie("Titanic", Movie.Genre.DRAMA, 'U'),
                new Movie("Psycho", Movie.Genre.THRILLER, 'U'),
                new Movie("Oldboy", Movie.Genre.THRILLER, 'R'),
                new Movie("Shining", Movie.Genre.HORROR, 'U')                 );

        movies.stream()
                .peek(mov->System.out.println(mov.getName()))
                .filter(mov->mov.getRating()=='R')
                .map(Movie::getName)
                .forEach(System.out::println);

        List<Item> l = Arrays.asList(
                new Item(1, "Screw"),
                new Item(2, "Nail"),
                new Item(3, "Bolt")         );
        l.stream()
                .sorted(Comparator.comparing(Item::getName))// i -> i.getName()
                .map(Item::getName)
                .forEach(System.out::println);

        Map hm = new ConcurrentHashMap();
//        hm.put(null, "asdf");  //1

        TreeSet ts1 = new TreeSet();
//        ts1.add(null);

//         hm.put("aaa", null);  //2
         hm = new HashMap();
         hm.put(null, "asdf");  //3
         hm.put("aaa", null);  //4
         List list = new ArrayList();
         list.add(null); //5
         list.add(null); //6
         list = new CopyOnWriteArrayList();
         list.add(null); //7
    }
}
class MyProcessor{
    Integer value;
    public MyProcessor(Integer value){
        this.value = value;     }
    public void process(){
        System.out.println(value+" ");
    }
}

class Item{
    private int id;
    private String name;
    public Item(int id, String name){
        this.id = id;         this.name = name;
    }
    public Integer getId() {
        return id;     }
    public void setId(int id) {
        this.id = id;     }
    public String getName() {
        return name;     }
    public void setName(String name) {
        this.name = name;     }
    public String toString(){
        return name;     }
}


class Movie{
    static enum Genre  {DRAMA, THRILLER, HORROR, ACTION };

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getRating() {
        return rating;
    }

    public void setRating(char rating) {
        this.rating = rating;
    }

    private Genre genre;

    @Override
    public String toString() {
        return "Movie{" +
                "genre=" + genre +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }

    private String name;
    private char rating = 'R';
    Movie(String name, Genre genre, char rating){
        this.name = name;
        this.genre = genre;
        this.rating = rating;
    }
 }
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class T1_StreamAPI {
    public  static void main(String[] args){
        List<String> al = Arrays.asList("aa", "aaa", "b", "cc", "ccc", "ddd", "a");
        al.stream().filter((str)->str.compareTo("c")<0).forEach(x-> System.out.println(x));

        List<String> values = Arrays.asList("Java EE", "C#", "Python");
        values.stream().filter(x->x.contains("E"));
        boolean flag = values.stream().anyMatch(str->{
            System.out.println("Testing: "+str);
            return str.equals("Java");         });
        System.out.println(flag);


        IntStream is = IntStream.rangeClosed(1,4);
        T1_StreamAPI t1 = new T1_StreamAPI();
        t1.createStream();

/**
 * Static method --> Stream.of(T)
 */
//        Stream.of("A","B","C","D")
//                .filter(s->{ // passing a predicate!
//                    System.out.println("Filter: "+s);
//                    return false;
//                })
//                .forEach(s-> System.out.println("Foreach: "+s));

        /**
         * Example -02
         */
//        Stream.of("Alex","David","April","Edward")
//                .map((String s)->{
//                    System.out.println("map: "+s);
//                    return s.toUpperCase();
//                })
//                .anyMatch(s->{ // if there any element that starts with s? if so, terminate the loop and output the answer.
//                    System.out.println("Any match: "+s);
//                    return s.startsWith("A");
//                });
//
        /**
         * Example - 03
         */
        List<String> names = Arrays.asList("Alex","Ben","Charlie","David","Christian","April","Edward");
        Collections.sort(names,String::compareTo);
        names.stream()
                .filter(s-> {
                    System.out.println("Filter 1 : "+s);
                    return s.startsWith("B")||s.startsWith("C");
                })
                .filter(s-> {
                    System.out.println("Filter2 : "+s);
                    return s.length()>4;
                })
//                .limit(1) // Intermediate operation Stream<T> limit (long)
                .forEach(v-> System.out.println(v));
//                .forEach(System.out::println);

        /**
         * Infinite Streams
         * Stream<Y> generate(Supplier<T> s)
         * Supplier is a functional interface--> T get()
         */
        Stream<Integer> infStream = Stream.generate(()->{
            return (int)Math.random();
        });
//        infStream.forEach(System.out::println);

        /**
         * iterate(T seed, UnaryOperator<T> fn)
         * UnaryOperator is-a Function<T,T> --> T apply (T t)
         */

        Stream<Integer> integerStream = Stream.iterate(2,n->n+2);
//        integerStream.forEach(System.out::println);


        Stream<Integer> integerStream1 = Stream.iterate(2,n->n+2);
        integerStream1
                .limit(10)
                .forEach(System.out::println);
    }

    public void createStream(){

        /**
         *  Creation on Stream from an Array
         */
        Double[] lst = {1.1,2.2,3.3};
        Stream<Double> st1 = Arrays.stream(lst);
        long n1 = st1.count();
        System.out.println(n1);

        /**
         * Creation on Stream from Collection
         */
        List<Integer> lst2 = Arrays.asList(23,12,4,234,4);
        Stream<Integer> st2 = lst2.stream();
        System.out.println("Count: "+ st2.count());

        /**
         * Map
         */
        Map<String,Integer> map1 = new HashMap<>();
        map1.put("Mike",23);
        map1.put("Asi",26);
        map1.put("Mike",23);
        System.out.println(map1
                .entrySet()
                .stream()
                .count());

        /**
         * Creating a Stream with Stream.of
         */
        Stream<Double> str3 = Stream.of(23.2,23.5,65d,76.7);
        System.out.println("Double count: "+ str3.count());

        Stream<Dog> str4 = Stream.of(new Dog(),new Dog());
        System.out.println(str4.count());

        Stream<String> str5 = Stream.of("A","B");

        /**
         * Create a stream of a file
         */
//        List<Cat> cats = loadCat("Cats.txt");
//        cats.forEach(System.out::println);

    }

    public static List<Cat> loadCat(String fileName){
        List<Cat> cats = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))){
            stream.forEach(line -> {
                String [] catsArray = line.split("/");
                cats.add(new Cat(catsArray[0],catsArray[1]));
            });
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        return cats;
    }
}

class Dog{}

class Cat{
    private String name,colour;
    public Cat(String name, String colour) {
        this.name = name;
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }
}

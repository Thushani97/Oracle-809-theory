import java.time.MonthDay;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class T1_ParallelStreams {

    public  static void main(String[] args){
        Stream<Character> stream = Stream.of('c', 'b', 'a');       // z1
        stream.sorted().findFirst().ifPresent(System.out::println);
        MonthDay.of(10,28);
        System.out.println("hi");
        Stream<String> animalsStream = Arrays.asList("Dog","pig","cat").parallelStream();
        Stream<String> fruits = Stream.of("mango","apple","orange").parallel();

        int sum = Stream.of(10,20,30,40,50,60).mapToInt(n->n.intValue()).sum();
        System.out.println("Sum== "+sum);

        int tot = Stream.of(10,20,30,40,50,60)
                .parallel()
                .mapToInt(n->n.intValue())
                .sum();

        System.out.println(tot);

        sequentialStream();
        parallelStream();
    }

    public static void sequentialStream(){
        Arrays.asList("a","b","c")
                .stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }

    public static void parallelStream(){
        Arrays.asList("a","b","c")
                .stream()
                .parallel()
                .forEach(System.out::println);
    }

}

// we can not extends enum but can be implemented!!!
enum TestEnum implements Runnable{
    ;

    @Override
    public void run() {

    }
}
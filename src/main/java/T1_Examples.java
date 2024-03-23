import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.*;

public class T1_Examples {

    public  static void main(String[] args){
        List<Integer> ls2 = Arrays.asList(1, 2, 3);
        final int sum1=0 ; // this is not final or effectively final. It should not assign any value anywhere else
        ls2.stream().mapToInt(su->su+sum1).sum();
//        ls2.stream().forEach(a->{ sum=sum+a; });

        List<Integer> ls1 = Arrays.asList(1, 2, 3);
        double sum = ls1.stream().reduce(0, (a, b)->a-b);
        System.out.println(sum);

//        List<Integer> ls = Arrays.asList(1, 2, 3);
//        Function<Integer, Integer> func = a->a*a; //1
//         ls.stream().map(func).peek(System.out::println).forEach(System.out::println); //2
//        ls.stream().peek(x->{
//            sum1 + x
//        }).forEach(y->{});
//        System.out.println("nothing");
        /**
         * Stream<T> to Stream<T>
         */
        Stream.of("asi","sudu","thush","8dkf")
                .mapToDouble(n->n.length())
                .forEach(System.out::println);
        /**
         * Stream<T> to DoubleStream
         */
        DoubleStream dStream = Stream.of("asi","sudu","thush","8dkf")
                .mapToDouble(n->n.length());
        dStream.forEach(System.out::println);

        /**
         * Stream<T> to IntStream
         */
        IntStream iStream = Stream.of("asi","sudu","thush","8dkf")
                .mapToInt(n->n.length());
        iStream.forEach(System.out::println);

        /**
         * Stream<T> to LongStream
         */
        LongStream lStream = Stream.of("asi","sudu","thush","8dkf")
                .mapToLong(n->n.length());
        lStream.forEach(System.out::println);

        /**
         * IntStream to Stream<T>
         */
        Stream<String> streamAges = IntStream.of(1,2,3)
                .mapToObj(n->"No: "+n);
        streamAges.forEach(System.out::println);

        /**
         * IntStream to DoubleStream
         */
        DoubleStream dbstreamAges = IntStream.of(1,2,3)
                .mapToDouble(n->(double) n); //cast not necessary
        dbstreamAges.forEach(System.out::println);

        /**
         * IntStream to IntStream
         */
        IntStream istreamAges = IntStream.of(1,2,3)
                .map(n-> n*2); //cast not necessary
        istreamAges.forEach(System.out::println);

        /**
         * IntStream to LongStream
         */
        LongStream lstreamAges = IntStream.of(1,2,3)
                .mapToLong( n-> n*2); //cast not necessary
        lstreamAges.forEach(System.out::println);
    }

}

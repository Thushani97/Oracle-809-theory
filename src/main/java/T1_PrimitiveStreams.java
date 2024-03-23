import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class T1_PrimitiveStreams {

    public  static void main(String[] args){
        int[] ia ={1,2,3};
        double[] da = {1.1,2.2,3.3};
        long[] la = {1L,2L,3L};

        IntStream iStream = Arrays.stream(ia);
        DoubleStream dStream = Arrays.stream(da);
        LongStream lStream = Arrays.stream(la);

        System.out.println(iStream.count()+","+dStream.count()+","+lStream.count());

        IntStream iStream2= IntStream.of(1,2,3);
        DoubleStream dStream2 = DoubleStream.of(1.1,2.2,3.3);
        LongStream lStream2 =LongStream.of(1L,2L,3L);
        System.out.println(iStream2.count()+","+dStream2.count()+","+lStream2.count());

        /**
         * Using Stream<Integer> and reduce (identity, accumulator)
         */
        Stream<Integer> no1 = Stream.of(1,2,3);
        System.out.println(no1.reduce(0,(n1,n2)->n1+n2));

        IntStream intS = Stream.of(1,2,3).mapToInt(n->n);
        int total = intS.sum();
        System.out.println(total);

        OptionalInt max1 = IntStream.of(23,121,12,121).max();
        max1.ifPresent(System.out::println);

        OptionalDouble min1 = DoubleStream.of(10.1,20.23,3.43).min();
        min1.ifPresent(System.out::println);

        OptionalDouble avg = LongStream.of(10l,20l,30).average();
        avg.ifPresent(System.out::println);
        System.out.println(avg.orElseGet(()->Math.random()));


        stats(IntStream.of(12,3,43,54,3));
        stats(IntStream.empty());
//        2147483647
//        -2147483648
//        0.0
//        0
//        0
    }

    public static void stats(IntStream no){
        IntSummaryStatistics intStat = no.summaryStatistics();// terminal operation
        int min = intStat.getMin();
        System.out.println(min);// 3
        int max = intStat.getMax();
        System.out.println(max);//54
        double avg = intStat.getAverage();
        System.out.println(avg);//23.0
        long count = intStat.getCount();
        System.out.println(count);//5
        long sum = intStat.getSum();
        System.out.println(sum);//115
    }

}

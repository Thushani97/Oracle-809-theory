import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class T1_PrimitiveStreams2 {

    public  static void main(String[] args){

        LongStream is1 = LongStream.range(0,0);
        OptionalDouble x = is1.average();
        System.out.println(x);
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

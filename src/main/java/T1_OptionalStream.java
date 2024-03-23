import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.*;

public class T1_OptionalStream {

    /**
     *Optional class is immutable. If we do some changes we should assign it to a variable.
     *
     */
    public static Optional<String> getGrade(Integer marks){
        Optional<String> g = Optional.empty(); // Declare an empty Optional object
        if (marks>50){
            g=Optional.ofNullable("pass");
        }else{
            g=g.ofNullable("Fail");
        }
        System.out.println(g);//Optional.empty - 50 , Optional[pass] -55
        return g;

    }
    public  static void main(String[] args){

        List<String> l1 = Arrays.asList("a", "b");
        List<String> l2 = Arrays.asList("1", "2");
        Stream.of(l1,l2).forEach(s-> System.out.println(s));
        Stream.of(l1,l2).flatMap(x->Stream.of(x)).forEach(s-> System.out.println(s));

//        Stream.of(l1,l2).
        Optional<String> g1 = getGrade(50);
        Optional<String> g2 = getGrade(55);
        System.out.println(g1.orElse("Unknown"));

        if (g2.isPresent()){
            g2.ifPresent(x-> System.out.println(x));
        }else{
            System.out.println(g2.orElse("Empty"));
        }



        Object v1 = IntStream.rangeClosed(10, 15)
                .boxed()
                .filter(x->x>12)
                .parallel()
                .findAny();//Optional[15]

        Object v2 = IntStream.rangeClosed(10, 15)
//                .boxed() // convert IntStream to Stream<Integer>
                .filter(x->x>12)
                .sequential()
                .findAny(); //OptionalInt[13]

        System.out.println(v1+":"+v2);

        /**
         * A stream cannot be reused once a terminal operation has been invoked on it.
         */
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17); //1
         Stream<Integer> primeStream = primes.stream(); //2
        Predicate<Integer> test2 = k->k>10;
        Predicate<Integer> test3 = k->k<10; // 4 , 3
//        primeStream.collect(Collectors.partitioningBy(test2)).values().forEach(c-> System.out.println(c));
        primeStream.collect(Collectors.partitioningBy(test3,Collectors.counting())).values().forEach(v-> System.out.println(v)); //output when using condition 3: 3 4

//        long c1 = primeStream.filter(test2).count();
//        long c2 = primeStream.filter(test3).count(); // Runtime error!!! IllegalStateException
//        System.out.println(c1+c2);
    }

}

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class T1_groupingBy {

    public  static void main(String[] args){
        Stream<String> names = Stream.of("Joe","Tom","Tom","Alan","Peter");
        /**
         * List
         */
        Map<Integer, List<String>> map1 = names.collect(
                Collectors.groupingBy(String::length)//s->s.length()
        );
        System.out.println(map1);//{3=[Joe, Tom, Tom], 4=[Alan], 5=[Peter]}

        /**
         * Set - Remove duplicates
         */
        Stream<String> names1 = Stream.of("Joe","Tom","Tom","Alan","Peter");
        //Remove duplication of Tom using Set!
        Map<Integer, Set<String>> map2 = names1.collect(
                Collectors.groupingBy(
                        String::length,
                        Collectors.toSet()
                )
        );
        System.out.println(map2);//{3=[Joe, Tom], 4=[Alan], 5=[Peter]}

        /**
         * TreeMap - Sorted output
         */
        Stream<String> names2 = Stream.of("Joe","Tom","Tom","Alan","Peter");

        TreeMap<Integer,List<String>> map3 = names2.collect(
                Collectors.groupingBy(
                        String::length,
                        TreeMap::new,
                        Collectors.toList()
                )
        );
        System.out.println(map3);

        /**
         * Collectors.partitioningBy() --> grouping where there are only two possible groups
         */
        Stream<String> names3 = Stream.of("Thomas","Teresa","Mike","Alan","Peter");
        // Pass in a Predicate
        Map<Boolean,List<String>> map4 = names3.collect(Collectors.partitioningBy(s->s.startsWith("T")));
        System.out.println(map4);//{false=[Mike, Alan, Peter], true=[Thomas, Teresa]}

        Stream<String> names4 = Stream.of("Thomas","Teresa","Mike","Alan","Peter");
        // Pass in a Predicate
        Map<Boolean,List<String>> map5 = names4.collect(Collectors.partitioningBy(s->s.length()>4));
        System.out.println(map5);//{false=[Mike, Alan], true=[Thomas, Teresa, Peter]}


        Stream<String> names5 = Stream.of("Thomas","Teresa","Mike","Alan","Peter");
        // Pass in a Predicate
        Map<Boolean, List<String>> map6 = names5.collect(Collectors.partitioningBy(s->s.length()>14));
        System.out.println(map6);//{false=[Thomas, Teresa, Mike, Alan, Peter], true=[]}

/**
 * Using Set with partitioningBy()
 */
        Stream<String> names6 = Stream.of("Alan","Teresa","Mike","Alan","Peter");
        Map<Boolean,Set<String>> map7 = names6.collect(Collectors.partitioningBy(
                s->s.length()>4, // predicate
                Collectors.toSet()
        ));
        System.out.println(map7);//{false=[Mike, Alan], true=[Teresa, Peter]}

    }

}

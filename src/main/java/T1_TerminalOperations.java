import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class T1_TerminalOperations {

    public  static void main(String[] args){

        /**
         * max(Comparator) / min (comparator) --> Use ifPresent() with this to eliminate Optional
         */
        Optional<String> min = Stream.of("Bld","SFOU","OEWL")
                .min((s1,s2)->s1.length()-s2.length());
        System.out.println(min); // --> Optional[Bld]
        min.ifPresent(System.out::println); // to eliminate Optional we use ifPresent

        Optional<Integer> max = Stream.of(34,2,67,8,32,5)
                .filter(x->x>10)
                .max((i1,i2)->i1-i2);
        max.ifPresent(System.out::println); // method reference

        boolean str = Stream.of("UKH","oieljf","oiejfs")
                .allMatch(s->s.length()>3);
        System.out.println(str);

        /**
         * anyMatch(Predicate ), allMatch(Predicate),noneMatch(Predicate),
         */
        List<String> lst = Arrays.asList("ojidsf","xjcv","orie","gjfvb");
        Predicate<String> p = n->n.startsWith("o");
        System.out.println(lst.stream().anyMatch(p)); // true
        System.out.println(lst.stream().allMatch(p)); // false
        System.out.println(lst.stream().noneMatch(p));// false

        /**
         * reduce()--> T reduce(T identity, BinaryOperator<T> accumulator)
         * BinaryOperator<T> functional method : T apply (T, T)identity - initial value
         */

        String name= Stream.of("A","S","I")
                .reduce("",(a,b)->a+b);
        System.out.println(name);


        String name1= Stream.of("A","S","I")
                .filter(s-> s.length()>2)
                .reduce("nothing",(a,b)->a+b);
        System.out.println(name1);

        Integer int1 = Stream.of(1,3,4,2)
                .reduce(0,(a,b)->a+b);
        System.out.println(int1);

        BinaryOperator<Integer> op = (a,b)-> a+b;
        Stream<Integer> st1 = Stream.empty();
        Stream<Integer> st2 = Stream.of(4);
        Stream<Integer> st3 = Stream.of(4,34,23,1);

        st1.reduce(op).ifPresent(System.out::println );

        /**
         * <U> U reduce (U identity, BiFunction accumulator, BinaryOperator combiner)
         */
        Stream<String> stream = Stream.of("car","bus","Lorry","train");

        int length = stream.reduce(0,
                (n,strg)-> n+ strg.length(),
                (n1,n2)->n1+n2);

        System.out.println(length);

        /**
         * collect(Collector)
         */

        String s = Stream.of("AB","sa","q4rD")
                .collect(Collectors.joining());
        System.out.println(s);

        String s1 = Stream.of("AB","sa","q4rD")
                .collect(Collectors.joining(",,"));
        System.out.println(s1);

        Double avg = Stream.of("AB","SDF","reg")
                .collect(Collectors.averagingInt(ss->ss.length()));
        System.out.println(avg);

        /**
         * Collectors.toMap( )
         */
        Map<String,Integer> map = Stream.of("A","B","AA")
                .collect(
                        Collectors.toMap(ss1->ss1, // function for key
                                ss1-> ss1.length())); // function for value
        System.out.println(map);

        Map<Integer,String> map1 = Stream.of("cake","faslsa","aflkspw","cake")
                .collect(Collectors.toMap(ss3 ->ss3.length(),
                        ss3->ss3,
                        (sa1,sa2)-> sa1+ "-" + sa2)); // Merge function when keys are same
        System.out.println(map1); // {4=cake-cake, 6=faslsa, 7=aflkspw}

        /**
         * TreeMap
         */
        TreeMap<String,Integer> map2 = Stream.of("cake","faslsa","aflkspw","cake")
                .collect(Collectors.toMap(
                        k->k,
                        k->k.length(),
                        (ll1,ll2)-> ll1+ll2,
                        ()->new TreeMap<>()
                ));

        System.out.println(map2);//{aflkspw=7, cake=8, faslsa=6}
        System.out.println(map2.getClass());//class java.util.TreeMap
    }

}

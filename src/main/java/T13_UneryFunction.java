import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class T13_UneryFunction {
    public static int operate(IntUnaryOperator iuo){
        return iuo.applyAsInt(5);
    }
    public  static void main(String[] args){

        /**
         * .boxed() converts the IntStream to a Stream<Integer>.
         * Object obj == Map<Boolean,List<Integer>>
         *     rangeClosed (10,15) , 15 is included.
         *     range(10,15) , 15 is excluded!
         */
        Stream<Integer> values = IntStream.range(10,15).boxed();
        Object obj = values.collect(Collectors.partitioningBy(x->x%2==0));
//        Map<Boolean,List<Integer>> obj = values.collect(Collectors.partitioningBy(x->x%2==0));
        System.out.println(obj);//{false=[11, 13], true=[10, 12, 14]}

        IntFunction<IntUnaryOperator> uo = a->b->a-b;

        int x1 = operate(uo.apply(20));
        System.out.println(x1);

        /**
         * Here we are creating predicates, consumers , functions for stream's intermediate operations!!
         */
        List<String> strList = Arrays.asList("a", "aa", "aaa");
        Function<String, Integer> f = x->x.length();
        Consumer<Integer> c = x->System.out.println("Len:"+x+" ");
        strList.stream().map(f).forEach(c);


        /**
         *  Uses reduce to concatenate all the elements with the initial value "Hello : " using the bo operator.
         */
//        BinaryOperator<StringBuilder> bo1 = (s1, s2) -> s1.append(s2);
        BinaryOperator<StringBuilder> bo = StringBuilder::append;
        List<StringBuilder> names  = new ArrayList<>();
        names.add(new StringBuilder("Bill"));
        names.add(new StringBuilder("George"));
        names.add(new StringBuilder("Obama"));

        // Uses reduce to concatenate all the elements with the initial value "Hello : " using the bo operator.
        StringBuilder finalvalue = names.stream()
                .map(s->s.append("hi "))
//                .limit(2) // if you do not limit all the element will change
                .reduce(new StringBuilder("hello"), bo);

        System.out.println(finalvalue);//helloBillhi Georgehi Obamahi
        System.out.println(names.get(2)); // obama did not change. stream gets the elements one by one.
    }

}

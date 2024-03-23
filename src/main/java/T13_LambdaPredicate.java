import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

interface Evaluate<T>{
    boolean isNegative(T t);
}

public class T13_LambdaPredicate {

    public void consumer(){
        Consumer<String> c1 = (String s)-> System.out.println("Hi "+ s);
//        c1.accept(5);

        List<String > lst = new ArrayList<>();
        lst.add("Asithaya");
        lst.add("Sudu");
        lst.forEach(c1); // foreach accept the consumer!

        Map<Integer,String> mapCapitals = new HashMap<Integer,String>();
        BiConsumer<Integer,String> biC1 = (x,y)->mapCapitals.put(x,y);
        biC1.accept(4,"B");
        biC1.accept(14,"CCB");

        BiConsumer<Integer,String> biC2 = (x,y)-> System.out.println(x+y);

        mapCapitals.forEach(biC2);
    }

    public void supplier(){
        Supplier<Double> d1 = ()->Math.random();
        System.out.println(d1.get());

        Supplier<LocalTime> s1 = () -> LocalTime.now();
        System.out.println(s1.get());

        Supplier<StringBuilder> sb1 = ()-> new StringBuilder();
        System.out.println(sb1.get());
        System.out.println(sb1.get().append("ABC "));
    }
    public  static void main(String[] args){
//        Predicate even = ( i)-> i%2==0;  //3
        Predicate even = ( i)-> (Integer) i%2==0;  //3

        T13_LambdaPredicate t13= new T13_LambdaPredicate();
        t13.supplier();
        t13.consumer();

//        Evaluate<Integer> e = (int i)->i%2==0; // can not pass int i
        Evaluate<Integer> e = u->u%2==0;
        Evaluate<String> s4 = (d) -> d.startsWith("T") ;
        String m = "THush";
        Evaluate<String> s3 = s-> m.startsWith("T") ; // can not use m , behalf of s , since m is already defined in the scope!
        Evaluate<String> s2 = (String d) -> d.startsWith("T") ;
//        Evaluate<String> s6 = String d -> d.startsWith("T") ; // Can not use data type without ( )
        Evaluate<String> s1 = (String d) ->{return d.startsWith("T"); };
//        Evaluate<String> s7 = (String d) ->{ d.startsWith("T") } ; // Can not use { } without return and ;
        System.out.println(s4.isNegative(m));


        int i =6;
        Predicate<Integer> p1 = ii-> i %2==0;
        System.out.println(p1.test(5));

        /**
         * BiPredicate <T,U>
         */
        BiPredicate<String ,Integer> bp1 = (String t,Integer u) -> t.length()==u;
        System.out.println(bp1.test("asiii",5));


    }
}

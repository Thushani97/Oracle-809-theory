import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class T14_Function {

    String s = "Asangi";
    public void function(){
        /**
         * Function<T,R> is a functional interface.
         * R apply(T t)
         */
        Function<String ,Integer> f1 = s-> s.length();
        System.out.println(f1.apply("Asangani"));

/**
 * Local variables using inside lambdas - We can not change it. It should be final or effectively final
 */
        int x = 12;
//        x++;
        Predicate<String> lambda = s->{
            new T14_Function().s="Asi"; // use instance variable s
            System.out.println("X == "+x);
            return s.isEmpty() && x%2==0;
        };
        /**
         * BiFunction <T,U,R> is a functional Interface
         * R apply (T t , U u)
         * Use unbound method reference
         */

        BiFunction<String ,String,Integer> f2 = (s1,s2)-> s1.length()+s2.length();
        System.out.println(f2.apply("Asi","Thushi"));

        BiFunction<String,String,String> f3 = (s1,s2)->s2.concat(s1); // this can not be replaced with method reference!!
        BiFunction<String,String,String> f5 = (s1,s2)->s1.concat(s2); // this can be bound!!
        // First argument uses to call the concat instance method in String class! --> "Asi".concat("Thaya")
        BiFunction<String,String,String> f4 = String::concat; // Unbound method!
        System.out.println(f3.apply("Asi ","Thaya"));
    }




    public  static void main(String[] args){
       T14_Function f = new T14_Function();
       f.function();
    }

}

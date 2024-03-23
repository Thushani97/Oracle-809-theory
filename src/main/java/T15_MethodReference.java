import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class T15_MethodReference {

    public void methodReferences(){
        List<String> lst = Arrays.asList("Thushi","Asi","Sean");
        lst.forEach(n-> System.out.println(n));
        System.out.println();
        lst.forEach(System.out::println);

        /**
         * Bound method reference --> nn , (one argument)
         */

        String nn = "Mr Asitha Divi";
        Supplier<String > s1 = () -> "Asi".concat("ANC").toLowerCase();
        String s2 = s1.get();
        Supplier<String> s3 = nn::toUpperCase;
        Supplier<String> s4 = ()-> nn.toLowerCase();
        System.out.println(s3.get());
        System.out.println(s4.get());

        /**
         * Unbound mothod reference -> More than one argument
         */
        BiFunction<String,String,String> f3 = (ss1, ss2)->ss2.concat(ss1); // this can not be replaced with method reference!!
        BiFunction<String,String,String> f5 = (ss1,ss2)->ss1.concat(ss2); // this can be bound!!
        // First argument uses to call the concat instance method in String class! --> "Asi".concat("Thaya")
        BiFunction<String,String,String> f4 = String::concat; // Unbound method!
        System.out.println(f3.apply("Asi ","Thaya"));

        /**
         * Static method references are considered as UNBOUND.
         */

        Consumer<List<Integer>> sl1 = list-> Collections.sort(list);
        Consumer<List<Integer>> sl2 = Collections::sort;

        List<Integer> lst3 = Arrays.asList(12,2,43,4,53);
        sl1.accept(lst3);
        System.out.println(lst3);

        /**
         * Constructor Method reference
         */

        Supplier<StringBuilder> sb1 = ()-> new StringBuilder();
        Supplier<StringBuilder> sb2 = StringBuilder::new;

        StringBuilder sbb1 = sb1.get();
        StringBuilder sbb2 = sb2.get();

        sbb1.append("Lambda version");
        System.out.println(sbb1);

        sbb2.append("Method reference");
        System.out.println(sbb2);

        Function<Integer,List<String>> al1 = ArrayList::new;
        List<String> ls1 = al1.apply(10); // size 10
        System.out.println(ls1.size());
        ls1.add("21");

        /**
         * Method Reference and Context
         */

        Supplier<Integer> lam11 =()->Person.howMany();
        Supplier<Integer> lam1 =Person::howMany;
        System.out.println(lam1.get());

        Function<Person,Integer> lam22 = person -> Person.howMany(person);
        Function<Person,Integer> lam2 = Person::howMany;
        System.out.println(lam2.apply(new Person()));

        BiFunction<Person,Person,Integer> lam33 = (person1, person2) ->Person.howMany(person1,person2);
        BiFunction<Person,Person,Integer> lam3 = Person::howMany;
        System.out.println(lam3.apply(new Person(),new Person()));


    }


    public  static void main(String[] args){
       T15_MethodReference t = new T15_MethodReference();
       t.methodReferences();
    }

}

class Person{
    public static Integer howMany(Person... person){
        return person.length;
    }
}
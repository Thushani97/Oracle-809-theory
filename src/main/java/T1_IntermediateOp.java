import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class T1_IntermediateOp {

    public  static void main(String[] args){

        /**
         * Stream<T> filter(Predicate)
         */
        Stream.of("galway","mayo","ros")
                .filter(c->c.length()>2)
                .forEach(System.out::println);

        /**
         * distinct () - return a stream with duplicate values removed.Stateful intermediate operation
         * .equals() is used i.e: case sensitive.
         */

        Stream.of("eagle","eagle","Eagle")
                .peek(s-> System.out.println("1 "+s))
                .distinct()
                .forEach(s-> System.out.println("2 "+s));
//        1 eagle
//        2 eagle
//        1 eagle
//        1 Eagle
//        2 Eagle

        /**
         * limit() - use for lazy evaluation
         * A short circuit stateful
         */
        Stream.of(11,22,33,44,55,66,77,88,99)
                .peek(n-> System.out.println("A-"+n))
                .filter(n->n>40)
                .peek(n-> System.out.println("B-"+n))
                .limit(2)
                .forEach(n-> System.out.println("C-"+ n));

        /**
         * map() --> Used to transform data
         */
        Stream.of("book","pen","ruler")
                .map(s->s.length())
                .forEach(System.out::println);

        /**
         * flatMap() -> Takes each element in the stream
         * flatMap(Function(T,R))  In-T , Out - R
         * Stream <List<String>> and makes any elements it contains top-level elements in a single stream.
         */

        List<String> l1 = Arrays.asList("thush", "Chandra");
        List<String > l2 = Arrays.asList("asan","thush");
        Stream<List<String>> st1 = Stream.of(l1,l2);

        st1.flatMap(l->l.stream())
                .forEach(System.out::println);
//
//        thush
//        Chandra
//        asan
//        thush

        Employee john = new Employee("John", 54);
        Employee mary = new Employee("Mary", 41);
        Stream.of(mary,john)
                .sorted(Comparator.comparing(p->p.getAge()))
                .forEach(System.out::println);

        Stream.of("Tim","Jim","Peter","Ann","Mary")
                .peek(n-> System.out.println("0"+n)) // Tim , Jim , Peter , Ann , Mary
                .filter(n->n.length()==3)
                .peek(n-> System.out.println("1 "+n)) // Tim , Jim , Ann
                .sorted()                             //  Tim , Jim , Ann (sorted) --> Ann, Jim , Tim
                .peek(n-> System.out.println("2 "+n)) // Ann, Jim
                .limit(2)
                .forEach(n-> System.out.println("3 "+n)); // Ann , Jim

    }

}

class  Employee{
    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    private String name;
    private int age;

    public int getAge() {
        return this.age;
    }
}
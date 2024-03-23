
import java.util.ArrayList;
import java.util.List;

class Pair<T,E>{
    private final T firstName;
    private final E age;

    @Override
    public String toString() {
        return "Pair{" +
                "firstName='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }

    public Pair(T firstName, E age) {
        this.firstName = firstName;
        this.age = age;
    }
    public T getFirstName() {
        return firstName;
    }

    public E getAge() {
        return age;
    }


}
public class T11_Generics {

    public  static void main(String[] args){

        List<String> list = new ArrayList<>();
        list.add("SD"); // [SD]
        list.add(0, "NY"); // [NY,SD]
        list.set(1, "FL"); // [NY,FL] // Remove the element in index 1
        list.remove("NY"); // [FL]
        list.remove(0); // []

        Pair<String, Integer> strPair = new Pair<>("thush",23);
        Pair<String, Integer> strPair2 = new Pair("thush","ere"); // Consider as raw type
        Pair<Double, Integer> strPair1 = new Pair<>(23d,45);
        strPair.getAge();
        System.out.println(strPair1);
//        Pair<int>  // Should ot be primitives.

        List<Pair<String,Integer>> pair = new ArrayList<>();
        pair.add(new Pair<String,Integer>("A",1));

        System.out.println(pair.isEmpty());
        System.out.println(pair.contains("A"));;
        pair.add(new Pair<String,Integer>("B",11));
        String s1 = String.valueOf(pair.get(1));
        System.out.println(pair);


//        List str = new ArrayList();
//        str.add("A");
//        str.add("B");
//        str.add(String.valueOf(3));
//        str.add(1,"C");
//
//        int ss = (int) str.get(0);
//        System.out.println(ss);
//
//
//        java.util.List<String> lst = new ArrayList<>();
//        lst.add("AA");
//        lst.add("BB");
//        lst.add(1,"CC");
//        System.out.println(lst);
    }
}

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class T12_ArrayListTreeSet {


    public  static void main(String[] args){
        /**
         * Can not store duplicate values
         * Output an ascending ordered set.
         */
        Set<Integer> set = new HashSet<>();
        System.out.println(set.add(45));// true
        System.out.println(set.add(45));// false
        System.out.println(set.add(5));
        System.out.println(set.add(1));
        System.out.println(set.add(10));
        System.out.println(set);

        Set<String > set1 = new HashSet<>();
        set1.add("CA");
        set1.add("DA");
        set1.add("AZ");
        set1.add("B");
        System.out.println(set1);


        Set<String> treeSet1 = new TreeSet<>();
        treeSet1.add("Banana");
        treeSet1.add("Apple");
        treeSet1.add("A");
        treeSet1.add("A");
        System.out.println(treeSet1);
    }

}

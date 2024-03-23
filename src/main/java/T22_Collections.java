import java.util.*;
import java.util.stream.Collectors;


class ArrayListTest{
    public void getList(){
        ArrayList<String> s1 = new ArrayList<>();
        s1.add("45");
        s1.add("AB");
        s1.add("CVA");
        s1.add(new String("zCVA"));
        s1.add("A");
        System.out.println(s1);

//        Iterator<String> i1 = s1.iterator();
//        while (i1.hasNext()){
//            System.out.println(i1.next());
//        }

        System.out.println(s1.get(3));
        Collections.sort(s1);
        Collections.reverse(s1);
        for (String s:s1) {
            System.out.println(s);
        }
    }

}

class VectorTest{
    public void getList(){
        Vector<Double> v1 = new Vector<>();
        v1.add(23d);
        v1.add(23.23d);
        v1.add(3d);

        Collections.sort(v1);
        System.out.println(v1);
        System.out.println(v1.remove(new Double(23))); // true

    }
}



class QueueTest{
    public void getList(){
        /**
         * Allow keeping duplicates.
         */
        Queue<Integer> queue = new LinkedList<>(); // because LinkedList implements Deque(Queue) , List
        /**
         * enqueue elements using add(data) / offer(data)
         */
        System.out.println(queue);
        queue.add(4); // boolean
        queue.offer(5);// boolean
        queue.offer(7);
        queue.offer(9);
        queue.offer(2);


//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.peek());
//        System.out.println(queue.element());
        System.out.println(queue);

//        /**
//         * dequeue elements using remove()/ poll ()
//         */
//        queue.remove(); // integer/ datatype
//        queue.remove(4); // boolean
//        System.out.println(queue);
//
//        /**
//         * retrieve fist element using element() / peek()
//         */
//        boolean t=queue.contains(3);
//        System.out.println(t);
//
//        int x1=queue.peek();
//        System.out.println(x1);
//        Integer x2 = queue.element();
//        System.out.println(x2);
//        System.out.println(queue);

    }
}

class DequeTest{
    public void getList(){
        /**
         * FIFO
         */
        Deque<Integer> d1 = new LinkedList<>();
//        d1.add(5); //5
//        d1.addFirst(3); // 3 5--> add to front
//        d1.offer(45); // 3 5 45--> add to last
//        d1.offerFirst(34); // 34 3 5 45 --> add to front
//        d1.add(1); // 34 3 5 45 1 --> add to last
//        d1.push(23); // 23 34 3 5 45 1 --> add to front
//        d1.push(100); // 23 34 3 5 45 1 --> add to front
//        d1.pop(); // 34 3 5 45 1 --> Remove 1st
//        d1.poll(); // 3 5 45 1--> Remove 1st
//        d1.remove();// 5 45 1 --> Remove 1st
        d1.remove(0);// Remove 1st
//        d1.removeLast(); // [5, 45]
//        System.out.println(d1.peek()); //5 --> Show 1st
//        System.out.println(d1.element()); //5 --> Show 1st
//        d1.offer(null); //--> we can not add null to ArrayDeque
        System.out.println(d1);//[5, 45, null]
    }
}

class StackTest{
    public void getList(){
        Stack<String> v1 = new Stack<>();
        Stack<Integer> s1 = new Stack<>();
        s1.add(45);
        s1.add(5);
        s1.add(67);
        s1.push(3);
        s1.push(76);
        s1.push(27);
        System.out.println(s1);//[45, 5, 67, 3, 76, 27]
        System.out.println("First: "+s1.firstElement());//First: 45
        System.out.println("Last: "+ s1.pop());//Last: 27
        System.out.println(s1);//[45, 5, 67, 3, 76]
        System.out.println(s1.peek());// Last element = 76
        System.out.println(s1.search(4));// If not exist --> -1
        System.out.println(s1.remove(new Integer(45)));
        /**
         * add() == push()
         */
//        v1.pop(); // EmptyStackException
        v1.add("AB");
        v1.push("ASI");
        v1.add("AB");
        v1.add("THUSHI");
        v1.add("NMSD");
        v1.add("AB");

//        Collections.sort(v1);
        System.out.println(v1);
        v1.remove("ASI");
        /**
         * Remove last element from the stack== pop()
         */
        v1.pop();
        System.out.println(v1.pop());
        System.out.println(v1);
    }
}

class LinkedListTest{
    public void getList(){
        /**
         * Working as a List and a Queue
         * Doubly Linked list --> Use nodes in memory to store data.
         */
        LinkedList<String> v1 = new LinkedList<>();
        /**
         * add(), we normally use add()
         * push()
         */
//        v1.pop(); // EmptyStackException
        v1.add("THUSHI");
        v1.add("AB");
        v1.add("NMSD");
        v1.add("AB");
        v1.push("ASITha");
        v1.add("AB");



        /**
         * Iterating through a LinkedList
         */
        v1.stream().forEach(s-> System.out.println(s));
        v1.forEach(System.out::println);


        /**
         * It used to push the element to the 0th index onwards according to ascending order!
         */
        v1.push("ASI");
        v1.push("A");

        System.out.println(v1);
        v1.remove("ASI");
        /**
         * pop() --> use to remove last element that we have already pushed!
         */
        v1.pop();
        System.out.println(v1.pop());
        System.out.println(v1);
        System.out.println(v1.get(1));
    }
}

class PriorityQueueTest{
    public void getList(){
        Queue<Double> v1 = new PriorityQueue<>(Collections.reverseOrder());

        /**
         * add(), we normally use add()
         * Can not use push () / pop() with PriorityQueue
         */
        v1.offer(23.4);
        v1.offer(564.4);
        v1.offer(45.4);
        v1.offer(87.6784);

        System.out.println(v1);//[23.4, 87.6784, 45.4, 564.4]
        ;

    }
}

class SortedSetTreeSet{
    public void getList(){

        Set<Integer> ss =new HashSet<>();
        ss.add(34);
        ss.add(34);
        ss.add(3);
        ss.add(67);


        SortedSet<Integer> s1 = new TreeSet<>();
        s1.add(34);
        s1.add(67);
        s1.add(5);
        s1.add(5);
        s1.add(32);
        s1.add(564);
        System.out.println(s1);//[5, 32, 34, 67, 564]
        /**
         * s1.first() - return the first element of the set
         * s1.last() - return the last element of the set
         * s1.headSet(element) - return all the elements of the set before the specified element
         * s1.tailSrt(element) - return all the elements of the set after the specified element including the specified element
         * s1.subSet(element1,element2) - returns all the elements between the element1 and element2 including element1
         */
//        System.out.println(s1.first()); //5
//        System.out.println(s1.last());//564
//        System.out.println(s1.headSet(34));//[5, 32]
//        System.out.println(s1.tailSet(34));//[34, 67, 564]
//        System.out.println(s1.subSet(32,67));//[32, 34]
//        System.out.println(s1.comparator()); //null


        /**
         * TreeSet()
         */
        TreeSet<String> t1 = new TreeSet<>();
        String s11 = "the quick brown fox jumps over the lazy dog";
        String [] strArr = s11.split(" ");
        t1.addAll(Arrays.asList(strArr));

        /**
         * .ceiling(E e) --> Returns the equal or closest greatest element of the specified element from the set or null there is no such element!
         * .floor(E e) --> Returns the equal or closest the least element of the specified element from the set or null there is no such element!
         * Iterator - descendingIterator() --> Used to iterate the elements in descending order!
         * NavigableSet - descendingSet() --> Returns the elements in reverse order.
         * higher (E e) --> Returns the closet greatest element of the specified element from the set or null there is no such element!
         * lower(E e) --> Returns the closet least element of the specified element from the set or null there is no such element!
         * pollFirst() --> Retrieve and remove the first element
         * pollLast() --> Retrieve and remove the last element
         * first()   --> Retrieve  the first element
         * last()   --> Retrieve  the last element
         */
        System.out.println(t1.ceiling("A")); // brown
        System.out.println(t1.ceiling("z")); // nll
        System.out.println(t1.ceiling("td")); // the
        System.out.println(t1.floor("td")); // quick
        System.out.println(t1.higher("brown")); // dog
        System.out.println(t1.higher("br")); // brown
        NavigableSet<String> ns = t1.descendingSet();
        System.out.println(ns);//[the, quick, over, lazy, jumps, fox, dog, brown]

    }
}
class CollectionTest{
    public void getList(){
        Collection<String> v1 = new ArrayList<>();

        /**
         * add() == push()
         */
//        v1.pop(); // EmptyStackException

        v1.add("AB");

        v1.add("AB");
        v1.add("THUSHI");
        v1.add("NMSD");
        v1.add("AB");
        v1.add(null);
        System.out.println(v1);
        v1.remove("ASI");
        /**
         * Remove last element from the stack== pop()
         */

        System.out.println(v1);
    }
}
class Employer{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Employer(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                '}';
    }

    private String name;
    private int age;
    private String country;
}

class HashSetTest{
    public void getList(){
        Set<Integer> h1 = new HashSet<>();
        h1.add(12);
        h1.add(26);
        h1.add(26);
        h1.add(26);
        h1.add(122);
        h1.add(92);
        h1.add(null);
        System.out.println(h1);
        System.out.println(h1.remove(45));


    }
}

class LinkedHashSetTest{
    public void getList(){
        LinkedHashSet<Integer> lh1 = new LinkedHashSet<>();
        lh1.add(65);
        lh1.add(35);
        lh1.add(345);
        lh1.add(65);
        System.out.println(lh1);
        System.out.println(lh1.remove(32));
    }
}

class MapHashMapTest{
    public void getList(){
//        Map<String,Integer> map1 =new HashMap<>();
        Map<String,Integer> map1 =new Hashtable<>( );
        map1.put("ante",62);
        map1.put("yhea",42);
        map1.put("hea",642);
        map1.put("rta",298);
        map1.put(null,null);

        System.out.println(map1.get("tra"));// null
        System.out.println(map1.entrySet());//[ante=62, yhea=42, hea=642, rta=298]
        System.out.println(map1); //{ante=62, yhea=42, null=null, hea=642, rta=298}
        System.out.println(map1.values());//[62, 42, null, 642, 298]
        System.out.println(map1.keySet());//[ante, yhea, null, hea, rta]
    }
}
public class T22_Collections {

    public  static void main(String[] args){

        List<Employer> lst1 = new ArrayList<>();
        lst1.add(new Employer("ASI",23,"sdF"));
        lst1.add(new Employer("THU",25,"erSF"));
        lst1.add(new Employer("CHa",22,"SperF"));
        lst1.add(new Employer("aSiiI",26,"AzisdSF"));


        Collections.sort(lst1,new MySort());
//        System.out.println(lst1);

        CollectionTest c1 = new CollectionTest();
//        c1.getList();

        int[] arr1 = new int[4];
        List<Integer> arr2 = new ArrayList<>();
        arr2.add(12);
        arr2.add(2);
        arr2.add(1);
        arr2.add(12);
        arr2.add(12);

        ArrayList<Integer> arr5 = new ArrayList<>();
        arr5.add(1);
        arr5.add(2);
        /**
         * removeALl (Collection ) / addALl(Collection)
         */
        arr2.removeAll(arr5);//[12, 12, 12]

//        Collections.sort(arr2);
//        System.out.println(arr2);
//
//        arr5.stream().forEach(System.out::println); // java 8 stream + lambda example
//        arr5.forEach(System.out::println); // java 8  lambda example
//
//
//        ArrayList<Integer> arr3 = new ArrayList(24);
//        List<Integer> arr4 = new ArrayList(arr2); // we have put super class as a parameter here!!!!

//        arr4.addAll(arr3);
        /**
         * Collections - A class
         * Collection- Interface
         */

        ArrayListTest a1 = new ArrayListTest();
//        a1.getList();

        VectorTest v1 = new VectorTest();
//        v1.getList();

        StackTest s1 = new StackTest();
        s1.getList();

        LinkedListTest l1 = new LinkedListTest();
//        l1.getList();

        PriorityQueueTest p1 = new PriorityQueueTest();
//        p1.getList();

        HashSetTest h1 = new HashSetTest();
//        h1.getList();

        QueueTest q1 = new QueueTest();
//        q1.getList();

        DequeTest d1 = new DequeTest();
        d1.getList();

        SortedSetTreeSet st1 = new SortedSetTreeSet();
//        st1.getList();

        LinkedHashSetTest lh1 = new LinkedHashSetTest();
//        lh1.getList();

        MapHashMapTest m1 = new MapHashMapTest();
//        m1.getList();
    }

}

class MySort implements Comparator<Employer>{

    @Override
    public int compare(Employer o1, Employer o2) {
        return o1.getAge()-o2.getAge();
    }
}
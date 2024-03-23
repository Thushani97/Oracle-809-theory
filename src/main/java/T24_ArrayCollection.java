import java.util.*;

//public class T24_ArrayCollection {
//    static String[] sa = { "d", "bbb", "aaaa" };
//    public static void main(String[] args) {
//        System.out.println(Arrays.binarySearch(sa, "ZZZZZ", new MyStringComparator()));;
//     }
//
//}
//class MyStringComparator implements Comparator {
//    public int compare(Object o1, Object o2)     {
//
//        int s1 = ((String) o1).length();
//        int s2 = ((String) o2).length();
//
//        return s1 - s2;     } }

class Address implements Comparable<Address>{
    String street;
    String zip;

    public Address(String street, String zip){
        this.street = street; this.zip = zip;     }

    public int compareTo(Address o) {
//            return -1;
        int x = this.zip.compareTo(o.zip);
        return x == 0? this.street.compareTo(o.street) : x;
    } }



public class T24_ArrayCollection {

    public static void main(String[] args) {

        T24_ArrayCollection t = new T24_ArrayCollection();
//        t.getNavigableMap();

        ArrayList<Address> al = new ArrayList<>();
        al.add(new Address("dupont dr", "28217"));
        al.add(new Address("Sharview cir", "28217"));
        al.add(new Address("yorkmont ridge ln", "71223"));
        al.add(new Address("Tyjrkmont ridge ln", "61223"));
        al.add(new Address("Ayjrkmont ridge", "61223"));
        for(Address a : al)
            System.out.println("Unsorted: "+ a.street+" "+ a.zip);
        Collections.sort(al);
        for(Address a : al)
            System.out.println(a.street+" "+ a.zip);     } }




//    void getNavigableMap(){
//        NavigableMap<String, String> mymap = new TreeMap<String, String>();
//        mymap.put("a", "apple");
//        mymap.put("b", "boy");
////        mymap.put("b", "boysss");
//        mymap.put("c", "cat");
//        mymap.put("aa", "apple1");
//        mymap.put("bb", "boy1");
//        mymap.put("cc", "cat1");
//        System.out.println(mymap.pollLastEntry());;
//        mymap.pollFirstEntry();
//        NavigableMap<String,String> tailmap = mymap.tailMap("bb",true);
//        System.out.println(mymap+" "+mymap.size());
//        System.out.println(tailmap+" "+tailmap.size());
//    }

import java.util.*;
class In1 implements In2, Comparable<In1>{
//class In1<T> implements In2, Comparable<T>{
//    @Override
//    public int compareTo(Object o) {
//        return 0;
//    }

    @Override
    public int compareTo(In1 o) {
        return 0;
    }
}

interface  In2{}


class ComparatorTest implements Comparable<ComparatorTest>{
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ComparatorTest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public ComparatorTest(int id, String name) {
        this.id = id;
        this.name = name;
    }

    int id;
    String name;

    @Override
    public int compareTo(ComparatorTest o1) {
//        return 1;
        if(this.id<o1.id){
//            System.out.println(this.id+" "+o1.id);
            return 1;
        }
        return -1;
    }
}
public class T23_CollectionMore  implements Comparator{


    void  sortAlgo(){
        int[] numbers = {6,9,1,8};
        Arrays.sort(numbers);

//        Arrays.binarySearch()
        System.out.println(Arrays.binarySearch(numbers, 3));

    }
    void getSorted(){
        List<Integer> lst = new ArrayList<>();//[23, 34, 91, 10, 20]
        lst.add(1);
        lst.add(2);
        lst.add(3);
        lst.add(4);
        lst.add(5);
//        System.out.println(lst);
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
//                return 10;
//                if (o1%10 < o2%10)
//                    return  1;
//                else
                    return 1;
            }
        };
        Collections.sort(lst,com);
        System.out.println(lst);
        System.out.println(Integer.compare(4,6));
    }

    @Override
    public int compare(Object o1, Object o2) {

        char c1 =((String)o1).charAt(1);
        char c2 =((String)o2).charAt(1);
        if (c1>c2)
            return 1;
        else if(c1==c2)
            return 0;
        else
            return -1;

    }
    void getCompare(){
        System.out.println("index:" + Arrays.binarySearch(sa,"eeeeeee",new T23_CollectionMore()));;
    }
    static String[] sa = {"da","bbb","acaa","ersfs","rdrrrr","eeeeeee"};

    public static void main(String[] args) {

            T23_CollectionMore t = new T23_CollectionMore();
            t.getCompare();
    }

}

class Booby{}
class Dooby extends Booby{}
class Tooby extends Dooby{}

class TestBooby{
    Booby b = new Booby();
    Tooby t = new Tooby();

    void addData1(List<? super  Dooby> d1){
        d1.add(t);
    }
}
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class T1_StreamsMore {
    void getPartitioned(){
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17);
        Stream<Integer> primeStream = primes.stream();
        Predicate<Integer> test1 = k->k<10;
//        Map<Boolean,List<Integer>> map = primeStream.collect(Collectors.partitioningBy())
        primeStream.collect(Collectors.partitioningBy(test1,Collectors.counting())).values().forEach(x-> System.out.println(x));
//        Predicate<Integer> test2 = k->k>10;
//        long count2 = primeStream.filter(test2).count();
//        Stream<Integer> values = IntStream.rangeClosed(10, 15).boxed();
//        Object obj = values.collect(Collectors.partitioningBy(x->x%2==0));
//        Map<Boolean, List<Integer>> objx = values.collect(Collectors.partitioningBy(x->x%2==0));
//        System.out.println(obj);// {false=[11, 13, 15], true=[10, 12, 14]}
    }

    void getSum(){

        List<Integer> ls = Arrays.asList(1, 2, 3);
        ls.forEach(x-> System.out.println(x));
        ls.stream().mapToInt(x->x).sum();// mapToInt converts Stream<Integer> --> IntStream
        ls.stream().map(x->x+1).forEach(x-> System.out.println(x));
    }


    public  static void main(String[] args){
        T1_StreamsMore t = new T1_StreamsMore();
        t.getPartitioned();
//        t.getSum();

    }
}


class Names{
    private List<String> list;
    public List<String> getList() {
        return list;     }

    public void setList(List<String> list) {
        this.list = list;     }

    public void printNames(){
        System.out.println(getList());     }

    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                "Bob Hope",
                "Bob Dole",
                "Bob Brown"        );
        Names n = new Names();
        n.setList(list.stream().collect(Collectors.toList()));
//        n.getList().forEach(Names::printNames);
        n.getList().forEach(name-> n.printNames());
//        n.getList().forEach(name-> name.printNames());


    }
}
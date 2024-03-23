import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class TT{
    void getName(){

    }
}
public class T1_StreamAPIEx1 extends TT {

    class TT{
        int getName(){
            return 1;
        }
    }

    public TT t = new TT(){
      public void doA(){
          System.out.println("hi");
      }
    };

    public void doA(){
//        t.doA();
    }
    public  static void main(String[] args){

        Object[] sa = { 300, 100, 100 };
        Collections.sort(Arrays.asList(sa), null);
        System.out.println(sa[0]+" "+sa[1]+" "+sa[2] );

        new T1_StreamAPIEx1().new TT();
        List<String> al = Arrays.asList("aa", "aaa", "b", "cc", "ccc", "ddd", "a");

        long count = al.stream().filter((str)->str.compareTo("aaa")<0).sorted().count();
        System.out.println(count);

        AtomicInteger ai = new AtomicInteger();
        Stream<String> stream = Stream.of("old", "king", "cole", "was", "a", "merry", "old", "soul");
        stream.filter(e->{     ai.incrementAndGet();
                    System.out.println(e+" "+ai.incrementAndGet());
            return e.contains("o"); })
                .allMatch(x->x.indexOf("o")>0);
        System.out.println("AI = "+ai);


        Stream<List<String>> s1 = Stream.of(
                Arrays.asList("a", "b"),
                Arrays.asList("a", "c")         );
        Stream<String> news = s1.filter(s->s.contains("c"))
                .map(olds -> olds.stream().collect(Collectors.joining()));//.map(olds -> String.join("", olds));
        news.forEach(System.out::print);

        Stream<Integer> strm1 = Stream.of(2, 3, 5, 7, 11, 13, 17, 19); //1

        Stream<Integer> strm2 = strm1.collect( Collectors.partitioningBy(i->{ return i>5 && i<15; })).get(true).stream();
        strm2.forEach((s)-> System.out.println(s));
        Stream<Integer> values = IntStream.rangeClosed(10, 15).boxed(); //1
         Map<Boolean, List<Integer>> obj = values.collect(Collectors.partitioningBy(x->x%2==0)); //2
//         Object obj1 = values.collect(Collectors.partitioningBy(x->x%2==0)); //2
         System.out.println(obj);



        List<String> names = Arrays.asList("Peter", "Paul", "Pascal");
        Optional<String> ops = names.stream()
                .parallel()
                .filter(name->name.length()>5)
                .findAny();
        System.out.println(ops);
        List<Teacher> ls = Arrays.asList(new Teacher("S1", 20), new Teacher("S2", 30), new Teacher("S3", 20) );

        double sum =ls.stream().filter(m->m.getMarks()>10)
                .mapToInt(Teacher::getMarks).average().getAsDouble();
        Collections.sort(ls,(p1,p2)-> p1.marks);
//        ToDoubleFunction td =
        Map<Integer,List<Teacher>> map1 = ls.stream().collect(Collectors.groupingBy(Teacher::getMarks));
//        Map<Integer,List<Teacher>> map2 = ls.stream().sorted(Collections.sort(););
        System.out.println(map1);//{20=[S1:20, S3:20], 30=[S3:30]}

        Map<String, Integer> bookMap =ls.stream().collect(Collectors.toMap((b->b.getName()),(b->b.getMarks())));
//        Map<String, Integer> bookMap1 =ls.stream().collect(Collectors.);
        System.out.println(bookMap);//{S3=20, S1=20, S2=30}
    }

}

class Teacher {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public String getMethod(int x){
        return "thiu";
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

     String name;
     int marks;

    public Teacher(String name, int marks){
        this.name = name;
        this.marks = marks;
    }

    public String toString(){
        return name+":"+marks;
    }
}
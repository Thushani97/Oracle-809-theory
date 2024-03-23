package streamsapi;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class TestClass{
    public double process(double payment, int rate){
        final double defaultval=0.10;
//        if (rate>10){
//            defaultval=rate;
//        }
             int cc=55656;
        class Implement{
            private int cc=45;
            public int apply(double data){
                int yy= Implement.this.cc;
                int yy2 = cc;
                System.out.println("YY2: "+yy2+"YY1"+yy);
                Function<Integer,Integer> f = x->x+ (int) (x*defaultval);
                Function<Integer,Integer> f2 = x->x+ (int) (x*rate);
                return f.apply((int) data);
            }
        }
        Implement i = new Implement();
        return i.apply(payment);
    }

}
class Items{

    public Items(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return price+" "+category;
    }

    private String category;
    private double price;
}

class Teacher{
    public static enum Grade{A,B,C,D,F}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return name+ ":"+grade;
    }

    public Teacher(String name, Grade grade) {
        this.name = name;
        this.grade = grade;
    }

    private String name;     private Grade grade;
}
public class Q2_Lambda {
    public static class Filter{
        void getM(){}
        static void getT(){}
    }
    public static void main(String[] arg){
        /**
         * Q-08
         */
       List<Teacher> lstTea = Arrays.asList(new Teacher("S1", Teacher.Grade.A),
               new Teacher("S2", Teacher.Grade.B),
               new Teacher("S2", Teacher.Grade.B),
               new Teacher("S2", Teacher.Grade.C),
               new Teacher("S3", Teacher.Grade.A));


//       Map<Teacher.Grade , List<Teacher>> mapTea=lstTea.stream().collect(Collectors.groupingBy(s ->s.getGrade()));

       Map<Teacher.Grade , Set<Teacher>> mapTea=lstTea.stream().collect(Collectors.groupingBy(Teacher::getGrade,Collectors.toSet()));
        System.out.println(mapTea.entrySet());//[C=[S2:C], A=[S1:A, S3:A], B=[S2:B, S2:B]]
        System.out.println(mapTea.keySet());//[C, A, B]
        System.out.println(mapTea.values());//[[S2:C], [S1:A, S3:A], [S2:B, S2:B]]
        System.out.println(mapTea);//{C=[S2:C], A=[S1:A, S3:A], B=[S2:B, S2:B]}
        /**
         * Q-07
         */
        List<Items> items = Arrays.asList(
                new Items("pen", "Stationery", 3.0),
                new Items("Pencil", "Stationery", 2.0),
                new Items("Eraser", "Stationery", 1.0),
                new Items("Milk", "Food", 2.0),
                new Items("Milk", "Fruits", 2.0),
                new Items("Eggs", "Food", 3.0) );

        ToDoubleFunction<Items> priceF = Items::getPrice;//x-> x.getPrice()
//        items.stream().collect(Collectors.groupingBy(x->x.getCategory())).forEach((k1,v1)-> System.out.println(k1));
        items.stream().collect(Collectors.groupingBy(x->x.getCategory())).forEach((k1,v1)-> {
//            v1.stream().sorted(Comparator.comparing(a->a.getName())).map(a->a.getName()).forEach(a-> System.out.println(a));
            v1.stream().map(a->a.getName()).sorted().forEach(a-> System.out.println(a));
        });
//        {
//          double av = v1.stream().collect(Collectors.averagingDouble(priceF));
//            System.out.println(k1+" "+av);
//        });
//        Stationery [Items{name='Pen', category='Stationery', price=3.0}, Items{name='Pencil', category='Stationery', price=2.0}, Items{name='Eraser', category='Stationery', price=1.0}]
//        Food [Items{name='Milk', category='Food', price=2.0}, Items{name='Eggs', category='Food', price=3.0}]
        /**
         * Q-06
         */
        IntStream is1 = IntStream.range(0, 5);
        OptionalDouble xa = is1.average();
        System.out.println(xa);
        /**
         * Q-05
         */
        List<String> vals = Arrays.asList("a", "b");
        String join = vals.stream().parallel()
                .reduce("_",
                        (a, b)->a.concat(b)                 );
        System.out.println(join);
        /**
         * Q-04
         */
        Stream<String> names = Stream.of("Sarah Adams", "Suzy Pinnell", "Paul Basgall");
        names.map(e->e.split(" ")[1]).forEach(x-> System.out.println(x));

        /**
         * Q-3
         */
        List<Books> books = Arrays.asList(new Books("30 Days", "fiction", "K Larsen"),
                new Books("Fast Food Nation", "non-fiction", "Eric Schlosser"),
                new Books("Wired", "fiction", "D Richards"));
        books.stream().collect(Collectors.groupingBy(t->t.getGenre())).forEach((k2,v2)-> {
            long val= v2.stream().filter(n->n.getTitle().startsWith("W")).peek(n-> System.out.println(n)).count();
            System.out.println("count "+val);
        });
//        books.stream().filter(Books.BookFilter::isFiction).forEach(x-> System.out.
//        println(x.getTitle()));
//        books.stream().filter((Books b)-> new Books.BookFilter().getNonStat()).forEach(x-> System.out.println(x.getTitle()));

        /**
         * Q-2
         */
        List<Integer> lls = Arrays.asList(1, 2, 3);
        lls.stream().map(MyProcessor::new).forEach(MyProcessor::process);
        /**
         * Q-1
         */
        List<Item> l = Arrays.asList(
                new Item(1, "Screw"),
                new Item(2, "Nail"),
                new Item(3, "Bolt")         );

//        l.stream().sorted((a,b)->a.getId().compareTo(b.getId())).forEach(x-> System.out.println(x));
        l.stream().sorted(Comparator.comparing(Item::getName)).map(i->i.getName()).forEach(x-> System.out.println(x));

        TestClass t = new TestClass();
        t.process(23,10);
    }
}
class Books {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Books(String title, String genre, String author) {

        this.title = title;
        this.genre = genre;
        this.author = author;
    }

    private int id;

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    private String title; private String genre; private String author;

    public static class BookFilter {
        public static boolean isFiction(Books b){
            return b.getGenre().equals("fiction");         }

        public boolean getNonStat(){
            System.out.println("hi non stat");
            return true;
        }
    }


}


class MyProcessor{     Integer value;
    public MyProcessor(Integer value){
        this.value = value;     }
    public void process(){
        System.out.println(value+" ");     } }

class Item{
    public Integer getId() {
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

    public Item(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    private Integer id;
    private String name;
}
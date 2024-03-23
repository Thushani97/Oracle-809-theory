import java.util.*;
import java.util.function.*;

class Bag{
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    private String title;
    private Double price;
    public Bag(String title, Double price){
        this.title = title;
        this.price = price;
    }     //accessor methods not shown

}


public class T13_LambdaQues {


    public  static void main(String[] args){


        Bag b1 = new Bag("Java in 24 hrs", 30.0);
        Bag b2 = new Bag("Thinking in Java", null);
//        LongSupplier ll1 = b1::getPrice;
        DoubleSupplier s1 = ()->b1.getPrice();
        DoubleSupplier ss1 = b2::getPrice; // null pointer exception
        /**
         * DoubleSupplier is a functional interface with the method --> double getAsDouble()
         * .getAsDouble --> return type is double(primitive)
         */
//        System.out.println(ss1.getAsDouble());
//        Supplier s2 = b2.getPrice();

        /**
         * Example -01
         */
        List<Double> l1 = Arrays.asList(10.0,12.0);
        l1.forEach(x->{x=x+10; }); // Wrapper classes are immutable
        l1.stream().forEach(x-> System.out.println(x));

        List<StringBuilder> l2 = Arrays.asList(new StringBuilder("a"),new StringBuilder("aa"));
        l2.stream().forEach(x->x.append(5));
        l2.stream().forEach(System.out::println); // StringBuilder is mutable.
        // output--> a5 , aa5

        /**
         * Example - 02
         */
        List<Student> slist = Arrays.asList(new Student("S1", 40), new Student("S2", 35), new Student("S3", 30));
        Consumer<Student> incrMarks = s->s.addMarks(10); // call by value, these obj are mutable.
        System.out.println(slist.get(0).getMarks());
        slist.forEach(incrMarks); // call the  method .. then change the values
//        slist.stream().forEach((Student s)->s.debug());
        slist.stream().forEach(Student::debug);

        /**
         * Example -03 --> reduce , max , filter
         */
        List<Integer> ls = Arrays.asList(3,4,6,9,2,5,7);
        System.out.println(ls.stream().max(Integer::compareTo).get());
        System.out.println(ls.stream().max((Integer x,Integer y)-> Integer.compare(x,y)).get());
        System.out.println(ls.stream().max(Comparator.comparingInt((Integer x) -> x)).get());
        System.out.println(ls.stream().max(Integer::compare));

        System.out.println(ls.stream().max((a, b)->a>b?a:b)); //4
        System.out.println(ls.stream().max(Integer::max).get()); // if you want to compare o2 numbers, ok to use Integer::max. otherwise use compare or compareTo , to get the max of the stream!

        System.out.println("Reduceee");
        System.out.println(ls.stream().reduce(10, (a, b)->a>b?a:b)); //identity , BinaryOperator
        System.out.println(ls.stream().reduce( (a, b)->a>b?a:b)); //identity , BinaryOperator

        ls.stream().filter(x->x>5).filter(x->x<9).forEach(System.out::println);

        /**
         * Example - 04
         */
        IntFunction<IntUnaryOperator> fo = a-> b->a-b;  //1
         int x = operate(fo.apply(20)); //2         System.out.println(x);
    }
        public static int operate(IntUnaryOperator iuo){
            return iuo.applyAsInt(5);     }

}

class Student{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    private String name;
    private int marks;

    public void addMarks(int m){
        this.marks += m;
    }
    public void debug(){
        System.out.println(name+":"+marks);
    }
}
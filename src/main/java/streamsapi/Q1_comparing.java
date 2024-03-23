package streamsapi;

import java.util.*;
import java.util.function.*;

class Account{
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                '}';
    }

    private String id;
    public Account(String id){
        this.id = id;
    }
}

class Book{
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

    public Book(String title, Double price) {
        this.title = title;
        this.price = price;
    }

    private String title;
    private Double price;
}
class Movie{
    static enum Genre  {DRAMA, THRILLER, HORROR, ACTION };

    @Override
    public String toString() {
        return "Movie{" +
                "genre=" + genre +
                ", name='" + name + '\'' +
                '}';
    }

    private Genre genre;
    private String name;

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    Movie(String name, Genre genre){

        this.name = name; this.genre = genre;
    }
    }
class Student {
    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    private String name;

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

    private int marks;

    public void addMarks(int m){
        this.marks =m;
    }
    public void debug(){
        System.out.println(name+":"+marks);     }

}
interface AmountValidator{
    int cc= 34;
    public boolean checkAmount(double value);
    default void getDefault(){
        System.out.println("this is default");
    }

    static void getStatic(){
        System.out.println("this is static");
    }
}
interface AA extends AmountValidator{

}
public class Q1_comparing  extends Account implements AmountValidator{

    public void updateBalance(double bal){

        /**
         * Predicate implementation for AmountValidator functional interface!!!
         */
        AmountValidator a =  x->x>0;
        Predicate p = x->a.checkAmount(34);
        a.getDefault();
        AmountValidator.getStatic();
        int staticFinalVar=AmountValidator.cc;


//        boolean isOk=new AmountValidator(){
//            public boolean checkAmount(double value){
//                return value>= 0;
//            }
//        }.checkAmount(45);
    }
    Q1_comparing(String id, double balance){
        super(id);
        this.balance=balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Q1_comparing{" +
                "balance=" + balance +
                '}';
    }

    private double balance;
    public static int operate(IntUnaryOperator iuo){
        return iuo.applyAsInt(55);
    }
    public static void main(String[] args) {
        /**
         * Q-15
         */
        List<Book> bks = Arrays.asList(new Book("Thinking in Java", 30.0),
                new Book("Java in 24 hrs", 20.0),
                new Book("Java Recipies", 10.0));
        double avg = bks.stream().filter(b->b.getPrice()>10).mapToDouble(b-> b.getPrice()).average().getAsDouble();
        System.out.println(avg);

        /**
         * Q-14
         */
        IntFunction<IntUnaryOperator>  fo = a-> (b->a-b);
        int x = operate(fo.apply(20));
        /**
         * Q-13
         */
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(1, "a"); hm.put(2, "b"); hm.put(3, "c");
        hm.put(1, "ab"); hm.put(2, "bb"); hm.put(3, "c");
        System.out.println(hm);
        /**
         * Q-12
         */
        List<Integer> ddList = Arrays.asList(10, 12,32,54,65);
//        int maxVal= ddList.stream().max(Comparator.comparing(a->a)).get();
        int maxVal= ddList.stream().reduce(0,(a, b)->a>b?a:b);
        System.out.println("max value:"+maxVal);
        ddList.stream().forEach(yx-> yx=yx+10); // replacing x
        ddList.stream().forEach(System.out::println);
        /**
         * Q-11
         */
        List<Student> slist = Arrays.asList(new Student("S1", 40), new Student("S2", 35), new Student("S3", 30));
        Consumer<Student> increaseMarks = s->s.addMarks(10);
        slist.forEach(increaseMarks);
        slist.forEach(Student::debug);
        /**
         * Q-10
         */
//        int x =5;
//        double y = x;
//        double y2 = 45.0;
        Book b1 = new Book("Java in 24 hrs", 45.0);
        Book b2 = new Book("Thinking in Java", null);
        DoubleSupplier ss1 = b1::getPrice;// --> getAsDouble() // if the value is null --> Null pointer exception.
        Supplier ss2 = b2::getPrice; // --> .get() // if the value is null --> Null will print. No exceptions.
        System.out.println(b1.getTitle()+" "+ss1.getAsDouble());
        System.out.println(b2.getTitle()+" "+ss2.get());
        /**
         * Q-09
         */
        List<String> names  = new ArrayList<>();
        names.add("Bill"); names.add("George"); names.add("Obama");
        BinaryOperator<String> bo = (s1, s2) -> s1.concat(s2);
        String finalVal = names.stream().reduce("Hello: ",bo);
        System.out.println(finalVal);
        /**
         * Q-08
         */
        List<Movie> movies = Arrays.asList(
                new Movie("On the Waterfront", Movie.Genre.DRAMA),
                new Movie("Psycho", Movie.Genre.THRILLER),
                new Movie("Oldboy", Movie.Genre.THRILLER),
                new Movie("Shining", Movie.Genre.HORROR)                 );
        Predicate<Movie> t1 = m->m.getGenre()== Movie.Genre.THRILLER;
        Predicate<Movie> t2 = m->m.getName().startsWith("O");
        movies.stream().filter(t2).filter(t1).map(xxx->xxx.getName().toUpperCase()).forEach(s-> System.out.println(s));

        /**
         * Q-07
         */
        List<Double> dList = Arrays.asList(10.0, 12.0);
        DoubleFunction df = xx->xx+10;
//        dList.stream().forEach(df);

        /**
         * Q-06
         */
        BiPredicate<String,Integer> bip = (s,i)-> s.length()>i;
        BiFunction<String,Integer,String> biff =(s,i)->{
            if(bip.test(s,i)){
                return s.substring(0,i);
            }else
                return s;
        };
        /**
         * Q-05
         */
        String ss = "Hello world";
        List<List<Book>> books = Arrays.asList(
                Arrays.asList(
                        new Book("Windmills of the Gods", 7.0),
                        new Book("Tell me your dreams",9.0) ),
                Arrays.asList(
                        new Book("There is a hippy on the highway", 5.0),
                        new Book("Easy come easy go", 5.0)) );

        double d = books.stream().flatMap(b->b.stream()).mapToDouble(Book::getPrice).sum();//Collection::stream)
        /**
         * Q-04
         */

        List<Integer> str = Arrays.asList(1,2, 3, 4 );
        str.stream().filter(x1->{
            System.out.print(x1+" -filer ");
            return x1>2; })
                .forEach(System.out::println);


        /**
         * Q-03
         */
        List<Integer> ls = Arrays.asList(2, 4, 6, 9);
        Predicate<Integer> check = (Integer i) -> {
            System.out.println("Checking-Q-03");
            return i == 4; };
        Predicate<Integer> even = (Integer i)->  i%2==0;  //3
        ls.stream().filter(check).findAny();
        System.out.println(ls.stream().reduce(Integer.MIN_VALUE, (a, b)->a>b?a:b));
        System.out.println(ls.stream().max(Integer::max).get());
        System.out.println(ls.stream().max((a, b)->a>b?1:-1)); //4
        /**
         * Q-02
         */
        Book bb1 = new Book("Java in 24 hrs", null);
        DoubleSupplier ds1 = bb1::getPrice;
//        System.out.println(b1.getTitle()+" "+ds1.getAsDouble());

        /**
         * Q-01
         */
        Map<String,Account> myAcc = new HashMap<>();
        myAcc.put("111",new Account("111"));
        myAcc.put("222",new Q1_comparing("111",200));

        BiFunction<String,Account,Account> bif= (a1,a2)->a2 instanceof Q1_comparing?new Q1_comparing(a1,300):new Account("666");
        System.out.println("old: "+myAcc);
        System.out.println(myAcc.computeIfPresent("111",bif));;
        System.out.println("new: "+myAcc);
        Q1_comparing ba = (Q1_comparing) myAcc.get("222");
        System.out.println(ba.getBalance());
    }

    @Override
    public boolean checkAmount(double value) {
        return false;
    }
}

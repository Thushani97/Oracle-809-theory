import java.util.Objects;
class IntPair{
    private int a;
    private int b;

    @Override
    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        T19_hashCode that = (T19_hashCode) o;
//        return a == that.a && b == that.b;

        return (o instanceof IntPair &&
                this.a==( (IntPair)o).a && this.b==( (IntPair)o).b);
    }

    @Override
    public int hashCode() {
        return a*b; // false
//        return a; // true
    }


    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

}
public class T19_hashCode {

    public  static void main(String[] args){
        IntPair one = new IntPair();
        one.setA(5);
        one.setB(10);

        IntPair two = new IntPair();
        two.setA(5);
        two.setB(10);
        System.out.println(one.equals(two));
        System.out.println(one.hashCode()==two.hashCode()
        );

        man m1 = new man();
        m1.setName("Amy");

        man m2 = new man();
        m2.setName("May");

        System.out.println(m1.equals(m2));
        System.out.println(m1.hashCode()==m2.hashCode());
    }

}

class man{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Override
//    public boolean equals(Object o) {
//        return (o instanceof man && this.name == ((man)o).name);
//    }

    @Override
    public int hashCode() {
        return 3;
    }

    private String name;

}
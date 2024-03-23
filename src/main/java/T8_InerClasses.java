import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

//class A{}
public class T8_InerClasses {
    int x = 34;
    static int no = 45;
    static void m1(){
        System.out.println("Hi-static");
    }
        int d= 540;
    public  class A  extends Thread  {
        int d= 54;
        void getNum(){
            m1();
            System.out.println(no);
            System.out.println(x);
            System.out.println(this);
            System.out.println(this.d);
            System.out.println(T8_InerClasses.this.d);
        }
//        static int y=56;
    }
    public static class B    {    }
    public void createMethod(){
        A a2 = new A();
        new B();
        new T8_InerClasses.B();
        new T8_InerClasses().new A();
        new T8_InerClasses.A();
        int x = new T8_InerClasses().x;
    }
    public  static void main(String[] args){
        Map<Integer,String> map = new HashMap<>();

        AtomicInteger ai = new AtomicInteger();
        System.out.println();
        System.out.println(ai.getAndIncrement());

        A aa = new T8_InerClasses().new A();
        new B();
        new T8_InerClasses.B();
//        new T8_InerClasses.A();
    }

}

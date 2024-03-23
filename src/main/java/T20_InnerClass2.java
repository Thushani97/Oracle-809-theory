import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

class Outsider {
    public class Insider{ } }

public class T20_InnerClass2 {

    public  static void main(String[] args) throws IOException {
        Path p1 = Paths.get("c:\\pathtest\\a.java");
        Path p2 = Paths.get("c:\\pathtest\\dir2\\a.java");
        Files.move(p1, p2, StandardCopyOption.ATOMIC_MOVE);
        Files.delete(p1);
        System.out.println(p1.toFile().exists()+" "+ p2.toFile().exists());
//        TestClass.A a = TestClass.A();
        Outsider o = new Outsider();
        Outsider.Insider i = o.new Insider();
    }

}


class TestClass {
    public class A    {    }     // inner class 1 - non static class
    public static class B    {    }    // inner class 2 - static class

    public void useClasses()    { // non-static class
        A a = new A();// non-static class
        B b = new B(); // static class

        B b1 = new TestClass.B();
        A a1 = new TestClass.A();
        A a2 = new TestClass().new A();
        TestClass.A a3 = new A();
        TestClass.A a4 = new TestClass.A();
        TestClass.B b3 = new B();
        TestClass.B b4 = new TestClass.B();
//        B b2 = new TestClass().new B(); // Error!!
    }

    public static void useMethods(){
//        A a1 = new A();// can not use since this is not a static class
        B b1 = new B();
        B b2 = new TestClass.B();
        A a2 = new TestClass().new A();
        TestClass t1 = new TestClass();
        A a3 = t1.new A();
//        TestClass.A a = new TestClass().A();

    }
}
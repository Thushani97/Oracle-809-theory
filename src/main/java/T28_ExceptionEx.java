import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

class MyResource1 implements AutoCloseable {
    public void close() throws IOException {
        System.out.print("1 ");
    }
}
class MyResource2 implements Closeable {
    public void close() throws IOException {
        throw new IOException();
    }
}
public class T28_ExceptionEx {
    public static void main(String[] args) {
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(1, "a");
        hm.put(2, "b");
        hm.put(2, "b");
        hm.put(null, "c");
        hm.forEach((k,v)-> System.out.printf("%d %s",k,v));
        hm.forEach((k,v)-> System.out.println(k));
        hm.forEach((k,v)-> System.out.println(v));


        Queue<String> products = new ArrayDeque<String>();
        products.add("p1");
        products.add("p2");
        products.add("p3");
        System.out.print(products.peek());
        System.out.print(products.poll());
        System.out.println("");
        products.forEach(s -> System.out.print(s));
        try (MyResource1 r1 = new MyResource1();
             MyResource2 r2 = new MyResource2();) {
            throw new IOException();
        } catch (IOException ioe) {
            System.out.print("IOE ");
        } finally {
            System.out.print("F ");
        }
    }
}
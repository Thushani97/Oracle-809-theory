import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import static java.util.Locale.Builder;
import static java.util.Locale.CHINA;

public class T23_Collector {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("charles", "chuk", "cynthia", "cho", "cici");
        long x = names.stream().filter(name->name.length()>4).collect(Collectors.counting()); // .count()
        System.out.println(x);
     }

}
//class TestClasses implements T1, T2{
//    int i=0;
//    public void m1(){
//        while (true)
//            if(i<10)
//    }
//}
//interface T1{
//    int VALUE = 1;
//    void m1();
//}
//interface T2{
//    int VALUE = 2;
//    void m1();
//}
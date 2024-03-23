import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Objects;

public class T16_TryWithResources {

    void assertTest1(int c) {
//        assert c.isEmpty();
        if (c==0){}
        else if (c==1){}
        assert c>5;
        assert c == 0 : "hi";}

    void assertTest2(Object o1, Object o2){
        assert o1 != null && o2 ==null;
    }

    void assertTest3(){
//        assert ; //assert must be followed by at least one operand
    }

    public  static void main(String[] args) throws IOException {

        new T16_TryWithResources().assertTest1(5);
        int num=0;

        try (InputStreamReader in = new InputStreamReader(System.in);
             BufferedReader br=new BufferedReader(in)){

            num= Integer.parseInt(br.readLine());

        // this is a resource. When you open them , you need to close.
//        }finally {
//            assert br != null;
//            /**
//             * We close() database connections, network connections, resources from the finally block.
//             */
//            br.close();
//        }
        }finally {
            System.out.println("hi");
        }

    }
}

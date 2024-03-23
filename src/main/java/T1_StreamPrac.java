import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.*;
import java.util.function.DoubleFunction;
import java.util.function.IntFunction;
import java.util.function.ToDoubleFunction;
import java.util.stream.IntStream;

public class T1_StreamPrac {

    public static void main(String[] args) throws SQLException {
//        Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");
//        Statement stmt = c.createStatement();
//        ResultSet rs = stmt.executeQuery("select * from CUSTOMER_ORDER"); //LINE 10
//         stmt.close(); //LINE 11
//         while(rs.next()){  //LINE 12
//              System.out.println(rs.getString("AMOUNT"));
//                 }
//         c.close();

        List<String> vals = Arrays.asList("a", "b");
        String join = vals.parallelStream()
                .reduce("_",
                        (a, b)->a.concat(b)  );
//        System.out.println(join);

        List<Double> dList = Arrays.asList(10.0, 12.0);
        DoubleFunction df = x->x+10;
//        dList.stream().forEach(df);
        dList.stream().forEach(d->System.out.println(d));

        IntStream is1 = IntStream.range(0, 5);
        OptionalDouble x = is1.average();
        System.out.println(x.getAsDouble());
//        Path p1 = Paths.get("temp\\test.txt");
//        Path p2 = Paths.get("report.pdf");
//        System.out.println(p1.resolve(p2));

     }

}

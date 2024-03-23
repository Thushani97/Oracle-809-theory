import java.io.IOException;
import java.sql.SQLException;

interface I1 {
    void m1() throws java.io.IOException;
}

interface I2 {
    void m1() throws java.sql.SQLException;
}

public class T21_interface implements I1,I2 {
    /**
     * Can not throws any exceptions since they clash each of them.
     */
    @Override
    public void m1() {//  throws java.io.IOException,java.sql.SQLException
        System.out.println("m1 implementation");
    }

    public  static void main(String[] args) throws SQLException, IOException {
        I1 i = new T21_interface();
        i.m1();
    }

}

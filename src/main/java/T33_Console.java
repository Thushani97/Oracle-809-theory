import java.io.Console;
import java.nio.file.Path;
import java.nio.file.Paths;

public class T33_Console {

    public static void main(String[] args) {
        Console c = System.console(); //1
         char[] line = c.readPassword("Please enter your pwd:"); //2
         System.out.println("Pwd is "+new String(line));
     }

}

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

class CannotSwimException extends Exception{
    CannotSwimException(){
        super();
    }
    CannotSwimException(Exception e){
        super(e);
    }

    CannotSwimException(String msg){
        super(msg);
    }
} // Checked exception
class DangerInTheWater extends RuntimeException{} // Unchecked exception
class SharkInTheWaterException extends DangerInTheWater{} // Unchecked exception
public class T16_Exception {


    public  static void main(String[] args) throws CannotSwimException{
        readFile();
        /**
         * The error messages that we’ve been showing are called a stack trace.
         * Java automatically prints the
         * stack trace when the program handles an exception
         */
//        throw new CannotSwimException();
        throw new CannotSwimException("Break!");
    }

    public static void readFile(){
        try {
            Path path = Paths.get("dolphinsBorn.txt");
            String text = new String(Files.readAllBytes(path));
            LocalDate date = LocalDate.parse(text);
            System.out.println(date);
        } catch ( NoSuchFileException |RuntimeException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

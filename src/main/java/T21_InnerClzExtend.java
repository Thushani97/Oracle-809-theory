import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class T21_InnerClzExtend {

    private String data = "skin";
    public int hashCode(){
        return 2;
    }

    private class Layer extends T21_InnerClzExtend {
        String data = "thegoodpart";
        public String getData() {
            return data;         }
    }
    public String getData() {
        return new Layer().getData();
    }
    public static void main(String[] args) {
        T21_InnerClzExtend o = new T21_InnerClzExtend();
        System.out.println(o.getData());
    }

}

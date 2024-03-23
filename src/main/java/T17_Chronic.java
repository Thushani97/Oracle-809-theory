import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class T17_Chronic {

    void withInstant(){
        Instant  now = Instant.now();
        Instant now2 = now.truncatedTo(ChronoUnit.DAYS);
        System.out.println(now2);
    }
    public  static void main(String[] args){
        T17_Chronic c = new T17_Chronic();
        c.withInstant();


//        Duration d2 = Duration.of(10,ChronoUnit.YEARS);
//        System.out.println(d2);
        LocalDate d1 = LocalDate.of(2024,2,3);
//        System.out.println(d1.plus(1,ChronoUnit.WEEKS));
        LocalTime now = LocalTime.of(9,30);
        LocalTime gameStart = LocalTime.of(10, 15);
        long timeConsumed = 0;
        long timeToStart = 0;
        if(now.isAfter(gameStart)){
            timeConsumed = gameStart.until(now, ChronoUnit.HOURS); }
        else{
            timeToStart = now.until(gameStart, ChronoUnit.HALF_DAYS); }
        System.out.println(timeToStart + " " + timeConsumed);
    }

}

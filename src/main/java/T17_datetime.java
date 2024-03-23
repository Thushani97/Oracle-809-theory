import java.time.*;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.time.ZonedDateTime;

public class T17_datetime {

    public  static void main(String[] args){
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());//14:49:03.755
        System.out.println(LocalDateTime.now());//2024-02-22T14:49:03.755
        /**
         * The time zone offset can be listed in different ways: +02:00, GMT+2, and
         * UTC+2 all mean the same thing. You might see any of them on the exam.
         */
        System.out.println(ZonedDateTime.now());//2024-02-22T14:49:03.756+08:00[Asia/Singapore]


        LocalDate date1 = LocalDate.of(2015, Month.JANUARY, 20);
        LocalDate date2 = LocalDate.of(2015, 1, 20);

        System.out.println(date1+" "+date2);
        Month m1 = Month.JANUARY;
//        boolean b1 = m1==1; // Does not compile!
        boolean b2 = m1 == Month.APRIL; // false

        LocalTime time1 = LocalTime.of(6, 15); // hour and minute
        LocalTime time2 = LocalTime.of(6, 15, 30); // + seconds
        LocalTime time3 = LocalTime.of(6, 15, 30, 200); // + nanoseconds

        LocalDateTime dateTime1 = LocalDateTime.of(2015, Month.JANUARY, 20, 6,  30); // year,month,day,hour,minute (+ second + nanos)
        LocalDateTime dateTime2 = LocalDateTime.of(date1, time1);



/**
 * public static ZonedDateTime of(int year, int month,
 * int dayOfMonth, int hour, int minute, int second, int nanos, ZoneId zone)
 * public static ZonedDateTime of(LocalDate date, LocalTime time, ZoneId zone)
 * public static ZonedDateTime of(LocalDateTime dateTime, ZoneId zone)
 */
        ZoneId zone = ZoneId.of("US/Eastern");
        ZonedDateTime zoned1 = ZonedDateTime.of(2015, 1, 20,
                6, 15, 30, 200, zone);
        ZonedDateTime zoned2 = ZonedDateTime.of(date1, time1, zone);
        ZonedDateTime zoned3 = ZonedDateTime.of(dateTime1, zone);
        System.out.println(zone+" "+zoned2);

        LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
        LocalTime time = LocalTime.of(5, 15);
        LocalDateTime dateTime = LocalDateTime.of(date, time)
                .minusDays(1).minusHours(10).minusSeconds(30);
        System.out.println(dateTime);
    }

}

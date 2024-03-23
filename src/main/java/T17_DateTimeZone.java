import java.time.*;
import java.time.temporal.ChronoUnit;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.time.ZonedDateTime;

public class T17_DateTimeZone {

    public  static void main(String[] args){


        /**
         * public static ZonedDateTime of(int year, int month,
         * int dayOfMonth, int hour, int minute, int second, int nanos, ZoneId zone)
         * public static ZonedDateTime of(LocalDate date, LocalTime time, ZoneId zone)
         * public static ZonedDateTime of(LocalDateTime dateTime, ZoneId zone)
         */
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
        System.out.println(ZonedDateTime.now());//2024-03-04T16:04:47.022+08:00[Asia/Singapore]

        /**
         * 2015–06–20T07:50+02:00[Europe/Paris] // GMT 2015–06–20 5:50 - reduce 2 hours
         * 2015–06–20T06:50+05:30[Asia/Kolkata] // GMT 2015–06–20 1:20 - reduce 5.30 hours
         * The time zone offset can be listed in different ways: +02:00, GMT+2, and UTC+2 all mean the same thing.
         *
         * 2015–06–20T07:50 GMT-04:00 // GMT 2015–06–20 11:50
         * 2015–06–20T04:50 GMT-07:00 // GMT 2015–06–20 11:50
         */

        ZoneId z= ZoneId.of("US/Eastern");
        ZonedDateTime zonedDT = ZonedDateTime.of(2013,4,3,06,3,34,45,z);
        System.out.println(zonedDT);

        LocalDate date = LocalDate.of(2014, Month.JANUARY, 20);
        date = date.plusDays(2);
        System.out.println(date);//2014-01-22
        date=date.plusWeeks(1);
        System.out.println(date);// 7 days->2014-01-29
        date=date.plusMonths(1);
        System.out.println(date);//2014-02-28 // not a leap year
        date = date.plusYears(5);
        System.out.println(date);//2019-02-28


        LocalDate da1 = LocalDate.of(2020, Month.JANUARY, 20);
        LocalTime time = LocalTime.of(5, 15);
        LocalDateTime dateTime = LocalDateTime.of(da1, time).minusDays(1).minusDays(2).minusHours(10).minusSeconds(6);
        System.out.println(dateTime);

        dateTime=dateTime.plusDays(35).plusWeeks(1);
        System.out.println(dateTime);

        Period annually = Period.ofYears(1); // every 1 year --> P1Y
        System.out.println(annually);
        Period quarterly = Period.ofMonths(3); // every 3 months --> P3M
        System.out.println(quarterly);
        Period everyThreeWeeks = Period.ofWeeks(3); // every 3 weeks --> P21D
        System.out.println(everyThreeWeeks);
        Period everyOtherDay = Period.ofDays(2); // every 2 days--> P2D
        System.out.println(everyOtherDay);
        Period everyYearAndAWeek = Period.of(1, 60, 7); // every year and 7 days
        System.out.println(everyYearAndAWeek); //P1Y7D
        /**
         * Period wrong = Period.ofYears(1);
         * wrong = Period.ofWeeks(7);
         * wrong = Period.ofDays(3);
         */
        Period wrong = Period.ofYears(1).ofWeeks(7).ofDays(3);// P3D
        System.out.println(wrong);



        Duration daily = Duration.ofDays(40); // PT960H
        System.out.println(daily);
        Duration hourly = Duration.ofHours(1); // PT1H
        System.out.println(hourly);
        Duration everyMinute = Duration.ofMinutes(1); // PT1M
        Duration everyTenSeconds = Duration.ofSeconds(10); // PT10S
        Duration everyMilli = Duration.ofMillis(1); // PT0.001S
        Duration everyNano = Duration.ofNanos(1); // PT0.000000001S
        Duration d2 = Duration.of(40, ChronoUnit.HALF_DAYS);
        System.out.println(d2);

        LocalTime one = LocalTime.of(5,15);
        LocalTime two = LocalTime.of(6,30);
        LocalDate date2 = LocalDate.of(2013,02,3);
        System.out.println(ChronoUnit.HOURS.between(one,two));
        System.out.println(ChronoUnit.MINUTES.between(two,one));// 1h 15 min -> 75 , between two,one --> -75

        Duration d = Duration.ofSeconds((int)1.100); // PT1S
        System.out.println(d);
        d = Duration.ofSeconds(61);
        System.out.println(d);

        /**
         * The Instant class represents a specific moment in time in the GMT time zone.
         */
        Instant now = Instant.now();
        System.out.println(now);
        Instant later = Instant.now();
        Duration diff = Duration.between(now,later);
        System.out.println(diff.toMillis()); // 16 in milli seconds

        /**
         * We use instant time with ZonedDateTIme
         */

        LocalDate date3 = LocalDate.of(2015, 5, 25);
        LocalTime time3 = LocalTime.of(11, 55, 00);
        ZoneId zone3 = ZoneId.of("US/Eastern");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(date3, time3, zone3);
        Instant instant = zonedDateTime.toInstant(); // 2015–05–25T15:55:00Z
        System.out.println(zonedDateTime); // 2015–05–25T11:55–04:00[US/Eastern]
        System.out.println(instant); // 2015–05–25T15:55:00Z

//        instant=Instant.ofEpochSecond(45456);
//        System.out.println(instant);

//        Instant nxtDay = instant.plus(1,ChronoUnit.DAYS);
//        System.out.println(nxtDay);
//        Instant nxthour = instant.plus(1,ChronoUnit.ERAS);//UnsupportedTemporalTypeException
//        System.out.println(nxthour);

        // between includes - if largeDate, smallDate
        Period p = Period.between( LocalDate.of(2015, Month.SEPTEMBER, 1),LocalDate.now());
        System.out.println(p);
        Duration dd = Duration.between(LocalDateTime.now(), LocalDateTime.of(2015, Month.SEPTEMBER, 2, 10, 10));
        System.out.println(dd);

        Duration d22 = Duration.ofMinutes(1100);
        System.out.println(d22);//PT18H20M


        Duration d23 = Duration.ofMillis(1100);
        System.out.println(d23);//PT18H20M



    }

}

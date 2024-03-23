import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.*;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import static java.util.Locale.*;
public class T23_Locale {

    public static void main(String[] args) {
//        Locale.setDefault(new Locale("fr", "CA")); //Set default to French Canada
//         Locale l = new Locale("jp", "JP");
//         ResourceBundle rb = ResourceBundle.getBundle("msg", Locale.CHINA);
//         String msg = rb.getString("greetings");
//         System.out.println(msg);

        List<String> letters = Arrays.asList("j", "a", "v","a");
        UnaryOperator<String > uo = String::toLowerCase;
        System.out.println(letters.stream().collect(Collectors.joining()));
        letters.forEach(x-> System.out.println(x.toUpperCase()));
        letters.replaceAll(uo);
        letters.forEach(System.out::print);
        Locale myloc = new Locale.Builder().setLanguage("es").setRegion("UK").build(); //L1

         ResourceBundle msgs = ResourceBundle.getBundle("msg",new Locale("en","CH"));
         ResourceBundle msgs1 = ResourceBundle.getBundle("msg",Locale.CHINA);
         ResourceBundle msgs2 = ResourceBundle.getBundle("msg",CHINA);
         Enumeration<String> en = msgs.getKeys();

         while(en.hasMoreElements()){
             String key = en.nextElement();
             String val = msgs.getString(key);
             System.out.println(key+" : "+val); }

        Locale l1 = Locale.getDefault();
        System.out.println(l1);//en_US
//        System.out.println(Locale.GERMAN); // de  <--- German language
//        System.out.println(Locale.GERMANY); // de_DE <-- Country

        Locale l2 = new Locale.Builder()
                .setLanguage("En")
                .setRegion("US")
                .setLocale(Locale.forLanguageTag("enn"))
                .build();

        Locale l4 = new Locale("en","US");
//        ResourceBundle rs = ResourceBundle.getBundle("msg",l4);
        System.out.println(l2.getLanguage());

        Locale l3 = new Locale.Builder()
                .setRegion("US")
                .setLanguage("en")
                .build();
        System.out.println(l3);

        System.out.println(Locale.getDefault()); // en_US
        Locale locale = new Locale("fr");
        Locale.setDefault(locale); // change the default
        System.out.println(Locale.getDefault()); // fr
     }

}

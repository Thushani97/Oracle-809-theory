import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class T33_Paths {

    public static void main(String[] args) {
        Path p5 = Paths.get("c:\\a\\b\\c.java");
        System.out.println(p5.compareTo(Paths.get("c:\\finance\\data\\reports\\daily\\pnl.txt")));


        Path p4 = Paths.get("c:\\finance\\data\\reports\\daily\\pnl.txt");
        System.out.println(p4.subpath(4, 5));


        Path p1 = Paths.get("photos\\..\\beaches\\.\\calangute\\a.txt");
        Path path4 = Paths.get("E:\\..\\user\\home");
        System.out.println(path4.normalize());
        System.out.println(p1.getNameCount());
        Path d1 = Paths.get("works");
        Path d2 = Paths.get("ocpjp/code/"); //1
        Path d = d2.resolve(d1); // d2 .resolve(d1)--> \works
        System.out.println(d);//  d1.resolve(d2)--> \works\ocpjp\code
        Path d3=d1.resolve("ocpjp/code/sample");  //2
        Path t=d2.toAbsolutePath(); //3
//        System.out.println(t);
//         System.out.println(d1);
         System.out.println(d2);
         System.out.println(d3);

     }

}


enum Animals{
    DOG("dog"),CAT("c"),RAT("rat");
    String name;
    static final int x = 34;
    Animals(String s){
        this.name=s+x;
    }
    public  void getData(){
        System.out.println("Hi "+name);
        return;}

}

class Singleton{
    private String no = "";
    private int x = 5;
    /**
     1. Creating a private static object
     2. Create a private constructor --> we have implicitly marked the class final.
     3. Create static method to return above created static object.
     */

    private static Singleton ss = new Singleton("23.4",34);
    private Singleton(String no, int x){
        this.no = no;
        this.x= x;
    }
    public static Singleton getInstance(){
        return ss;
    }

    void go(){
       Singleton s1 = new Singleton("th",34);
    }
}
public class T4_SingletonDesign {

    public  static void main(String[] args){
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.toString());
    }

}

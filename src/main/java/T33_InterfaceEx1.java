import java.io.IOException;
import java.sql.SQLException;

interface InM1{
    void m1() throws IOException;
    default void m2(){
        System.out.println("hi m1");
    }
}
interface InM2  {
    interface InnerIn extends Runnable{}
    void m1() throws SQLException;
//    default int m2(){
//        return 5;}
}

class InM3 implements InM1,InM2{
//    public int m2(){
//        return 0;
//    }
    public void m1(){}


}
interface Boiler{
    public abstract void boil();
    public static void shutdown(){
        System.out.println("shutting down");     }
    default  void getMethod(){
        boil();
    }

     static enum TEnum {
        X,T;

         TEnum(){ // Enum constructors are private by default.
             System.out.println("hi");
         }
    }

    interface InnerI{}
    static String getName(){
        return "thush";
    }

}


interface Vaporizer extends Boiler{  //1
    static int getName(){
        return 4; // not inherited!
    }
     public default void vaporize(){
         boil();
         TEnum x = TEnum.X;
         System.out.println("Vaporized! "+x);     } }

public class T33_InterfaceEx1 implements Vaporizer{
    public void boil() {
        System.out.println("Boiling...");     }


    public static void main (String[]args){
        Vaporizer v =  new T33_InterfaceEx1(); //2
         v.vaporize(); //3
//        v.boil();
         Boiler.shutdown(); //4
        v.getMethod();
        TEnum x = TEnum.X;
    }

}

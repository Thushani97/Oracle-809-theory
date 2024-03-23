/**
 * Can not create static method/ variables/ static block inside non-static inner class
 */

public class T20_InnerClass1 {

    public  static void main(String[] args){
        Outer1 outer1 = new Outer1();
        System.out.println(outer1.gerInner().getOi());
//        new Outer1.Inner1();
//        Outer1.Inner1 i1 = new Outer1.Inner1();
    }
}


class Outer1{
    private  int oi=20;
    private static int oi1=200;

      class Inner1{ // Non-static inner class. Therefore, we can access private instances.
         private int oi2=34;
         int getOi(){
            System.out.println(Outer1.this.oi); // we can not access non-static members inside the static class
            System.out.println(oi); // we can not access non-static members inside the static class
            return oi1;
        }
    }

    static class Inner3{
         static void getOi(){
             System.out.println(3444);
         }
    }

    /**
     * access variables and methods inside the inner class
     * Inner class can access private members in the outer class and Outer class can access private variables in the Inner class
      */

    int getOi(){
        Outer1.Inner3.getOi();
        System.out.println(new Inner1().getOi());
        System.out.println(new Inner1().oi2);
        return 4;
    }

     class Inner2 extends Inner1{
         int getOi(int x){
            return 1;
        }
    }

    Inner1 gerInner(){
        int y = oi1;  // access static / non-static instances inside a non-static method!
        return new Inner1();
    }

}

class Outer {

    public Outer(){}
    private void Outer() { }
    protected class Inner    {    } }
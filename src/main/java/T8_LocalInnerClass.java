interface IHello {
    public int hello(int x, int y);
    public long hello(long x, long y); }

abstract class Hello implements IHello{
    public short hello(short a, short b){ return 0;

    }
//    public short hello(int a, int b){ return 0; }
}


public class T8_LocalInnerClass {
    private int length =5;

    public void cal(){
        final int width = 20;
        int length = 30;
        int one = 20; // one is effectively final
        int two = one;
        two++;
        int three;
        if ( one == 4)
            three = 3;
        else
            three = 4; // initializing object inside the else condition.
        int four = 4;
        four=5;
        System.out.println(three);

        /**
         * Local Inner class - inside a non-static method!
         * do not have an access specifier
         *  cannot be declared static and cannot declare static fields or methods.
         */
        class Inner {

            public void multiply(){
                System.out.println(length*width);
            }
        }

        class D extends Inner{} // extending inner class

        Inner i =new Inner();
        i.multiply();
    }
    public  static void main(String[] args){
        T8_LocalInnerClass t = new T8_LocalInnerClass();
        t.cal();
    }

}

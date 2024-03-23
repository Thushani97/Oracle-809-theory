public class T9_AnonymousInnerClass {
    abstract class AbstractClass{
        abstract int getValue();
    }

    interface I1{
        void m();
    }
    public int callAbstract(){

        I1 inter1 = new I1() {
            @Override
            public void m() {
                System.out.println("Hi- from interface");
            }
        };
        /**
         * Anonymous class- A local inner class that does not have a name!
         */
        AbstractClass ab = new AbstractClass(){
            int getValue(){
                return 5;
            }
        }; // ----- semicolon is important
        return 6;
    }
    public  static void main(String[] args){

    }

}

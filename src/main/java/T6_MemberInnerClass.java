public class T6_MemberInnerClass {
    private String greeting ="Hi";

    /**
     * Inner Member class
     * Since member class is not static, it can use the instance variables declared in the outer class.
     */
    protected class Inner{
        public int repeat = 3;
        public void go(){
            for (int i = 0; i < repeat; i++)
                System.out.println(greeting);
        }
    }
    public void callInner(){
        Inner inner = new Inner();
        inner.go();
    }
    public  static void main(String[] args){
        /**
         * There are 3 methods to access inner member class
         */
//        ----- 1 -----
        T6_MemberInnerClass m = new T6_MemberInnerClass();
//        Inner i = new Inner(); // Can not create this.
        Inner inner1 = m.new Inner();
        inner1.go();

//        ----- 2 -----
//        T6_MemberInnerClass member = new T6_MemberInnerClass();
//        member.callInner();
    }

}


class BookStores {
    private static final int taxId = 300000;
    private String name;
    public String searchBook(  String criteria )    {
        int count = 0;
        int sum = 0;
        sum++;
        criteria=criteria.concat("s");
        class Enumerator       {
            String interate( int k)          {
//                sum++;
//                System.out.println(criteria);
                 return "";
            }
            // lots of code.....
             }
             // lots of code.....
         return "";
    }
}



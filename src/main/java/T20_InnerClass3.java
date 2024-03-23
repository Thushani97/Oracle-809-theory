public class T20_InnerClass3 {
//
//    public  static void main(String[] args){
//
//    }

}
class TestOuter {
    public void myOuterMethod()    {
        TestOuter t1 = new TestOuter();
        TestInner t2 = new TestInner();
    }
    public class TestInner { }

    public static void main(String[] args)    {
        TestOuter to = new TestOuter();
//        TestInner t2 = new TestInner();

    }
}



class Test{
    static
    {
        System.out.println("In static 0");
    }
}
 public class T18_StaticBlockLoading{

    static
        {
            System.out.println("In static 1");
        }
        {
            System.out.println("In non - static");
        }
    static
    {
        System.out.println("In static 2");
    }
        public static void main(String args[ ])    {
//            T18_StaticBlockLoading st1;
            System.out.println(" 1 ");
            T18_StaticBlockLoading st1 = new T18_StaticBlockLoading();

            {
                System.out.println("hi");
            }
            Test new1;//2
            System.out.println(" 2 ");
//            T18_StaticBlockLoading st2 = new T18_StaticBlockLoading(); //3

    }

}



//class A1
//{
//    static int i = 10;
//    static { System.out.println("A1 Loaded "); }
//}
//public class A
//{
//    static { System.out.println("A Loaded "); }
//    public static void main(String[] args)
//    {
//        System.out.println(" A should have been loaded");
//        A1 a1 = null;
//        System.out.println(" A1 should not have been loaded");
//        System.out.println(a1.i);
//    }
//}

/**
 * A Loaded
 *  A should have been loaded
 *  A1 should not have been loaded
 * A1 Loaded
 * 10
 */
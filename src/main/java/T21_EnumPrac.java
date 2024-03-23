import java.util.Arrays;
import java.util.TreeSet;

public class T21_EnumPrac<K,V> {

    public  static void main(String[] args){
        Title.getMethod();
        System.out.println(Title.MR.ordinal());
        Title.MRS.format("TH","th");
        System.out.println(Arrays.toString(new Title[]{Title.valueOf("MR")}));;

        TreeSet<Title> treeSet = new TreeSet<>();
        treeSet.add(Title.valueOf("MS"));
        treeSet.add(Title.valueOf("MR"));
        treeSet.add(Title.valueOf("MRS"));
        System.out.println(treeSet);
    }

}

enum Title2{
    Dr;
    private Title t;
}

enum Title3{
    Dr(34);
    private Title t= Title.MR;
    public static int x;
    public static final int xx;
    private final int y;
//    Title3(){}
    static {
        xx=45;
}
    Title3(int y){
        this.y=y;
    }
}

enum Title implements Runnable{
    MR("Mr."),
    MRS("Mrs."),
    MS("Ms.");
    private String title;

    private Title(String s){
        title = s;     }
    public String format(String first, String last){
//        getMethod();
        return title+" "+first+" "+last;
    }

    public static void getMethod(){
//        MRS.format("fb","dgd");
        System.out.println("Hi static method!");
    }

    @Override
    public void run() {

    }

    enum Test{}
    class Names{}
    interface getEnums{}
}
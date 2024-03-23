public enum T21_enum {
    /**
     * enums should be defined at first.
     *  ; is important
     *  By default enums are --> static final
     */
    DOG("D"),CAT("C"),RAT("R"),PARROT(3); // using constructor

    private int x;
    String name;

    void getInt(){
        System.out.println(this.x); //0
        System.out.println(name);//null
        System.out.println(String.valueOf(name));//null

//        System.out.println(name.length());// NullPointerException
//        System.out.println(name.toString());//NullPointerException
    }

    /**
     *Constrictor
     * By default -> private
     * Can not define as public/protected/default
     */
    private T21_enum(String s){

    }

    T21_enum(int i){

    }
}

enum Pets {
    DOG("D"),
    CAT("C"),
    RAT("R"){ // Overriding the getData() method
        void getData(String s){
            System.out.println("This is Rat");
        }
    },
    PARROT(3);

    private static final String p ; // this should be a compile-time constant if it is static
    private static final String q ="Hi";
    String name;
    static {
        p="A";
    }
    private Pets(String s) {
//        this.name =  p+s+q;// Compile-time Error!!
        name =  s+q;
    }

    private Pets(int i) {
        // Constructor logic for PARROT with int parameter
    }

    void getData(String s){
        System.out.println("I am a "+s);
    }
}

class TestEnums {

    public  static void main(String[] args){

        Pets p1 = Pets.RAT;
        p1.getData("rat");

        Pets p2 = Pets.CAT;
        p2.getData("cat");
        T21_enum t1 = T21_enum.CAT;
        T21_enum t2 = T21_enum.PARROT;
        System.out.println();

        System.out.println(T21_enum.values());

        System.out.println(t1.name());
        t1.getInt();

    }
}
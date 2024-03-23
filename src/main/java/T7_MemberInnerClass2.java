public class T7_MemberInnerClass2 {
    private int x = 1;

    class B {
        private int x = 2;

        class C{
            private int x = 3;
            public void allTheX(){
                System.out.println(x); // 3
                System.out.println(this.x); //3
                System.out.println(B.this.x); //2
                System.out.println(T7_MemberInnerClass2.this.x); //1
            }
        }

    }


    public  static void main(String[] args){
        T7_MemberInnerClass2 a = new T7_MemberInnerClass2();
        T7_MemberInnerClass2.B b = a.new B();
        T7_MemberInnerClass2.B.C c = b.new C();
        c.allTheX();
    }

}

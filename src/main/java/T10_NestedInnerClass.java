public class T10_NestedInnerClass {
    static class Nested{
        private int price=12;
    }
    public  static void main(String[] args){
        Nested nested = new Nested();
        System.out.println(nested.price);
    }
}

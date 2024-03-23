import java.util.HashMap;
import java.util.Map;

class Book {
    private String title, isbn;
    public boolean equals(Object o){
        System.out.println("check");
        return (o instanceof Book && ((Book)o).isbn.equals(this.isbn));
    }

    public int hashCode(){ // when you override equals() method, you should override hashCode()
        System.out.println(isbn.hashCode());
        return isbn.hashCode();
    }
    public void setIsbn(String number) {
        this.isbn=number;
    }
}

class BookStore {
    int num=34;
    Map<Book, Integer> map = new HashMap<Book, Integer>();

    /**
     *when you call map.get(b), it internally uses the equals()
     * method to check if the specified Book object is equal to any key in the map.
     */
    Object getNumberOfCopies(Book b){
//        System.out.println(map.get(b));
        return map.get(b);
//        return null;
    }
    public void addBook(Book b, int numberofcopies){

        map.put(b, numberofcopies);
    }
}
public class T18_HashMap {

    static BookStore bs = new BookStore();
    public static void main(String[] args)   {
        BookStore bss = new BookStore();
        int x = bss.num;
        Book b = new Book(); b.setIsbn("111");
        bs.addBook(b, 10);
        System.out.println("set 1st 111");
        System.out.println(bs.getNumberOfCopies(b));
        b = new Book(); b.setIsbn("111");
        System.out.println(bs.getNumberOfCopies(b));
    }


}

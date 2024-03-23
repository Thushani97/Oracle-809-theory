package streamsapi;

import java.util.HashMap;
import java.util.Map;

public class Q4_equalHashCode {
}
class Pen {
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    private String isbn;
    public Pen(String isbn){ this.isbn = isbn;
    }

    public boolean equals(Object o){
        return (o instanceof Pen && ((Pen)o).isbn.equals(this.isbn));
    }
    public int hashCode(){ return 100; }

}

class BookStore {
    Map<Pen, Integer> map = new HashMap<Pen, Integer>();
    public BookStore(){
        Pen b = new Pen("A111");
        map.put(b, 10);
        System.out.println("A111 "+b.hashCode());
        b = new Pen("B222");
        map.put(b, 5);
        System.out.println("B222 "+b.hashCode());
        System.out.println(map);}

    Integer getNumberOfCopies(Pen b){
        return map.get(b);     }

    public static void main(String[] args){
        BookStore bs = new BookStore();
        Pen b = new Pen("A111");
        System.out.println(b.hashCode());
        System.out.println(bs.getNumberOfCopies(b));


    }      }
import java.util.Arrays;
import java.util.List;

public class T3_equals {
    private int idNumber;
    private int age;
    private String name;
    public T3_equals(int idNumber, int age, String name) {
        this.idNumber = idNumber;
        this.age = age;
        this.name = name;
    }

    @Override public boolean equals(Object obj) {
        if ( !(obj instanceof T3_equals)) return false;
        T3_equals otherLion = (T3_equals) obj;
        return this.idNumber == otherLion.idNumber;
    }
    public  static void main(String[] args){

    }

}

class AA {
    public void getItDone(int counter)    {
        assert counter >=0 : "Less than zero";
        for(int i=0; i<counter; i++){ }    } }
class BB extends AA {
    public void getItDone(int counter)    {
        System.out.println("ho");
        assert counter >100 : "Greater than 100";
        for(int i=counter; i>0; i--){ }    }
    public static void main(String args[])    {
        for(Card c : Card.values()) System.out.print(c+" ");
//        for(int i=0; i<4; i++) System.out.println(Card[i]+" ");
        AA a = new BB();
//        a.getItDone(400);
        } }

enum Card {     HEART, CLUB, SPADE, DIAMOND; }
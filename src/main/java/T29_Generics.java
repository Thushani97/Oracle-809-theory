import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class T29_Generics<K,V> {

    private K k;
    private V v;
    public T29_Generics(K k, V v){
        this.k = k;
        this.v = v;     }
    public K getK() { return k; }

    public static <X> T29_Generics<X, X> getDuplicateHolder(X x){
        return new T29_Generics<X,X>(x, x);
        }


}

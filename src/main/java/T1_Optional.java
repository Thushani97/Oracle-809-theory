import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class T1_Optional {
    public  static void main(String[] args){
        Optional<Double> optavg = calcAverage(30,40,50);
        optavg.ifPresent(System.out::println); // 40.0

        // T orElse(T t)
        System.out.println(optavg.orElse(Double.NaN)); // 40.0

        Optional<Double> optavg2 = calcAverage();
        //T orElse(T t)
        System.out.println(optavg2.orElse(Double.NaN)); // Nan

        // T orElseGet(Supplier<T> s)
        System.out.println(optavg2.orElseGet(()->Math.random()));//0.06324211869819019
    }

    public static Optional<Double> calcAverage(int... scores){
        if (scores.length==0)
            return Optional.empty();
        int sum =0;
        for (int score:scores)
            sum+=score;
        return Optional.of((double)sum/scores.length);
    }

    public static void doOptionalNull(){
        Optional<String> optSK = howToDealWithNull("Sk");
        optSK.ifPresent(System.out::println); // SK
        Optional<String> optNull = howToDealWithNull(null);
        System.out.println(optNull.orElseGet(
                ()->"Empty Optional" // Empty Optional
        ));
    }

    public static Optional<String> howToDealWithNull(String param){
        Optional optReturn = Optional.ofNullable(param);
        return optReturn;
    }

    public static void doOptionalPrimitiveAverage(){
        OptionalDouble optavg = IntStream.rangeClosed(1,10).average();
        optavg.ifPresent((d)-> System.out.println(d));
        System.out.println(optavg.getAsDouble());

        System.out.println(optavg.orElseGet(()->Double.NaN));
    }
}

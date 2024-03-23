import org.omg.CORBA.Object;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Mother {}
class HeavyAnimal { }
class Hippo extends HeavyAnimal {
    private String name;
    private double weight;

    public Hippo(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }
    @Override
    public String toString() {

        return name;
    }
}
class Elephant extends HeavyAnimal { }

public class T2_InstanceOf {
    public  static void main(String[] args){
        System.out.println(new int[0]);
        System.out.println(new ArrayList());
        HeavyAnimal hippo = new Hippo("A",34.4); // reference variable is HeavyAnimal
        System.out.println("hippo instanceof Hippo: "+(hippo instanceof Hippo)); // --> true
        System.out.println("hippo instanceof HeavyAnimal: "+(hippo instanceof HeavyAnimal));// --> true
        System.out.println("hippo instanceof Object: "+(hippo instanceof Object));// --> false
        System.out.println("hippo instanceof Elephant: "+(hippo instanceof Elephant));// --> false

        System.out.println(hippo);
        Hippo nullHippo = null;
        System.out.println("nullHippo instanceof Object: "+(nullHippo instanceof Object));// --> false

        Hippo anotherHippo = new Hippo("B",345.4);
        System.out.println(anotherHippo instanceof  Hippo);// --> true
        System.out.println(anotherHippo instanceof  HeavyAnimal);// --> true

        /**
         * The compilation checks only when instanceof is called on a class.
         */
//        System.out.println(anotherHippo instanceof  Elephant); // Compilation Error!!!!

        /**
         * When checking whether an object is an instance of an interface, Java waits until runtime to do the check.
         */
        System.out.println("hippo instanceof Mother: "+ (hippo instanceof Mother));
    }

}

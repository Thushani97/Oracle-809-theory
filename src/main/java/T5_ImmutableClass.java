import java.util.ArrayList;
import java.util.List;

final public class T5_ImmutableClass {
    private final String species;
    private final int age;
    private final List<String> favoriteFoods;

    public T5_ImmutableClass(String species,int age, List<String> favoriteFoods){
        this.species = species;
        this.age = age;
        this.favoriteFoods = new ArrayList<>(favoriteFoods);
//        this.favoriteFoods = favoriteFoods; // not properly encapsulated!
    }

    public String getSpecies() {
        return species;
    }
    public int getAge() {
        return age;
    }
    public int getFavoriteFoodsCount() {
        return favoriteFoods.size();
    }
    public String getFavoriteFood(int index) {
        return favoriteFoods.get(index);
    }

    public  static void main(String[] args){

    }

}

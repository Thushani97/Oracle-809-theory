import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class T34_Serializable {

    public static void main(String[] args) {


    }
}

class School implements Serializable {
    private static final long serialVersionUID=1L; //it is considered a good practice to do so and update this static class variable anytime you modify the class.
    private String name;
    private int age;
    private char type;

    public School(String name, int age, char type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    @Override
    public String toString() {
        return "name= " + name + ", age=" + age + ", type=" + type ;
    }
}

class ObjectStreamSmaple{
    public static List<School> getSchool(File dataFile) throws IOException,ClassNotFoundException{
        List<School> schools = new ArrayList<>();
        try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))){
            while (true){
                Object obj = in.readObject();
                if(obj instanceof School){
                    schools.add((School) obj);
                }
            }
        }catch (EOFException e){

        }
        return schools;
    }

    public static void createAnimalsFile(List<School> schools,File dataFile) throws IOException{
        try(ObjectOutputStream out= new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)))){
            for (School s:schools) {
                out.writeObject(s);
            }
        }
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<School> schools = new ArrayList<School>();
        schools.add(new School("Asitha",26,'A'));
        schools.add(new School("Thush",16,'B'));

        File dataFile = new File("school.data");
        createAnimalsFile(schools,dataFile);
        System.out.println(getSchool(dataFile));//[name= Asitha, age=26, type=A, name= Thush, age=16, type=B]
    }
}
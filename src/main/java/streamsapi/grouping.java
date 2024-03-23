package streamsapi;

import java.util.*;
import java.util.stream.Collectors;

import static streamsapi.School.groupByMarks;

public class grouping {
    public static void main(String[] args) {

        groupByMarks();//{20=[S1:20, S3:20], 30=[S3:30]}
        List<String> names = Arrays.asList("Peterrr", "Paul", "Pascal");
        Optional<String> ops = names.stream()
                .parallel()
//                .allMatch(name->name!=null) ;
                .filter(name->name.length()>6)
                .findAny();
        System.out.println(ops.get());
    }
}

class Course{
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return id+":"+ category;
    }

    private String id;

    public Course(String id, String category) {
        this.id = id;
        this.category = category;
    }

    private String category;

    static void groupingByCategory(){
        List<Course> s1 = Arrays.asList(
                new Course("OCAJP", "Java"),
                new Course("OCPJP", "Java"),
                new Course("C#", "C#"),
                new Course("OCEJPA", "Java") );

        s1.stream().collect(Collectors.groupingBy(c->c.category)).forEach((k1,v1)-> System.out.println(v1));
    }

}

class School {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
    public String toString(){
        return name+":"+marks;     }

    private String name;
    private int marks;
    public School(String name, int marks){
        this.name = name;
        this.marks = marks;     }

    static void groupByMarks(){
        /**
         * groupingBy usage
         */
        List<School> ls = Arrays.asList(new School("ssS1", 10), new School("S3", 30), new School("S3", 20) );
//        Map<Integer, Set<School>> map= ls.stream().collect(Collectors.groupingBy(x-> x.getMarks(),Collectors.toSet()));//{20=[S1:20, S3:20], 30=[S3:30]}
//        Map<Integer, List<School>> map= ls.stream().collect(Collectors.groupingBy(x-> x.getMarks(),Collectors.toList()));//{20=[S1:20, S3:20], 30=[S3:30]}
//        Map<Integer, List<School>> map= ls.stream().collect(Collectors.groupingBy(x-> x.getMarks()));//{20=[S1:20, S3:20], 30=[S3:30]}
        Map<Integer, List<Object>> map= ls.stream()
                .collect(Collectors.groupingBy(x-> x.getMarks()
                                ,Collectors.mapping(x->x.getMarks()
                                        ,Collectors.toList())));//{20=[S1, S3], 30=[S3]}

        System.out.println(map);//

        /**
         * Comparator usage!
         */
//        Comparator<School> c1 = Comparator.comparing(School::getMarks);//(s1,s2)->s1.getName().compareTo(s2.getName()
//
//        ls.stream().sorted(c1.thenComparing(x->x.getMarks()));
//        System.out.println(ls);

    }
}
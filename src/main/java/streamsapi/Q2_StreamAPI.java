package streamsapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Names{
    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
    public void printNames(){
        System.out.println(getList());     }
    private List<String> list;

    void testForEach(){
        List<String> list = Arrays.asList(
                "Bob Hope",
                "Bob Dole",
                "Bob Brown"        );

        Names n = new Names();
//        n.setList(list);
        n.setList(list.stream().collect(Collectors.toList()));
        n.getList().forEach(System.out::println);
        n.getList().forEach(x-> n.printNames());
    }
}


public class Q2_StreamAPI {
    public static void main(String[] args) {

        Stream<String> names = Stream.of("Sarah Adams", "Suzy Pinnell", "Paul Basgall");
//        names.forEach(e->e.split(" ")[0]);
        names.map(e->e.split(" ")[0]);
        Names n1= new Names();
//        n1.testForEach();
    }
}

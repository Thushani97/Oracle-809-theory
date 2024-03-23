import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class T31_Concurrency2 {

    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        // Create a list of strings
        List<String> dataToAdd = new ArrayList<>();
        dataToAdd.add("One");
        dataToAdd.add("Two");
        dataToAdd.add("Three");

        // Create two threads, one for adding data and another for iterating
        Thread addThread = new Thread(() -> {
            myCache.addData(dataToAdd);
            System.out.println("Data added by thread: " + Thread.currentThread().getName());
        });

        Thread iterateThread = new Thread(() -> {
            Iterator<String> iterator = myCache.getIterator();
            System.out.println("Iterating by thread: " + Thread.currentThread().getName());
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        });

        // Start both threads
        addThread.start();
        iterateThread.start();

        // Wait for both threads to finish
        try {
            addThread.join();
            iterateThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyCache {
    private List<String> cal = new ArrayList<>();

    public void addData(List<String> list) {
        cal.addAll(list);
    }

    public Iterator<String> getIterator() {
        return cal.iterator();
    }
}

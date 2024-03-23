import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class T31_Concurrency extends RecursiveAction {
    int[] ia; int from; int to;
    public T31_Concurrency(int[] ia, int from, int to){
        this.ia = ia; this.from = from; this.to = to;
    }

    protected void compute() {
        if (from == to) {
            ia[from] = UtilityClass.utilityMethod(ia[from]);
        } else {
            int mid = (from + to) / 2;
            T31_Concurrency newtask1 = new T31_Concurrency(ia, from, mid);
            T31_Concurrency newtask2 = new T31_Concurrency(ia, mid + 1, to);
            newtask2.fork();
            newtask1.compute();
            newtask2.join();
        }
    }

        public static void main (String[]args){
            int ia[] = new int[]{1, 2, 3, 4, 5, 6, 7};
            ForkJoinPool fjp = new ForkJoinPool();// Creates a new ForkJoinPool.
            T31_Concurrency st = new T31_Concurrency(ia, 0, 6);//Creates an instance of the T31_Concurrency class, representing the task to be performed on the array ia from index 0 to 6.
            fjp.invoke(st);//Submits the task st to the ForkJoinPool for execution. The invoke() method starts the computation and waits for it to complete before returning.
            System.out.print("New Array Values = ");
            for (int i : ia) System.out.print(i + " ");
        }

}

class UtilityClass{
    public static int utilityMethod(int x) {
        return x+1;
    }
}


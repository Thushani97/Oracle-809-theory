import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class T32_CyclicBarrier extends Thread{

    private final CyclicBarrier barrier;
    private final String friendName;

    public T32_CyclicBarrier(CyclicBarrier barrier,String  friendName){
        this.barrier=barrier;
        this.friendName=friendName;
    }
    @Override
    public void run(){
        System.out.println(friendName+ " ready!!!");
//        getReadyAndBeAtMeetingPoint();
        System.out.println(friendName+ " is ready and waiting for "+ (barrier.getParties()-barrier.getNumberWaiting()-1)+ " at the point!");
        try {
            barrier.await();
            System.out.println(friendName+ " continue");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    private void getReadyAndBeAtMeetingPoint() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextLong(5000,15000));
        }catch (InterruptedException ex){
            Logger.getLogger("Error!");
        }
    }

    public static void main (String[]args){
        CyclicBarrier c = new CyclicBarrier(5);
        for (int i = 0; i < 5; i++) {
            T32_CyclicBarrier t = new T32_CyclicBarrier(c,"Friend "+i);
            t.start();
        }
    }

}

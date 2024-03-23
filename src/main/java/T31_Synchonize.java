public class T31_Synchonize {

  public synchronized void doALotStuff()  {

      try {
          System.out.println("doALotStuff doing..");
          LINE1: Thread.sleep(4000);
          System.out.println("doALotStuff finished..");
      }catch (Exception e){

      }
  }

  public  synchronized void doSmallStuff() throws InterruptedException {
      for (int i = 0; i < 10; i++) {
          Thread.sleep(1000);
          System.out.println(i);
      }
      System.out.println("doSmallStuff Finished..");

  }
  public static void main(String[] args)  {
      T31_Synchonize t1 = new T31_Synchonize();
      T31_Synchonize t2 = new T31_Synchonize();

      Thread tt1 = new Thread(()->{
          t1.doALotStuff();
      });

      System.out.println("Main Thread!!");
//      try {
//          Thread.sleep(500);
//      } catch (InterruptedException e) {
//          e.printStackTrace();
//      }
      Thread tt2 = new Thread(()-> {
          try {
              t1.doSmallStuff();
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      });
      tt1.start();
      tt2.start();
//      t1.doSmallStuff();
//      t1.doALotStuff();
  }


}


class SynchronizedObj {
    static StringBuffer sb1 = new StringBuffer();
    static StringBuffer sb2 = new StringBuffer();

    public static void main(String[] args)   {
        new Thread       (
                new Runnable()          {

                    public void run()
                    {
                        synchronized(sb1)
                        {
                            sb1.append("X");
                            synchronized(sb2)
                            {
                                sb2.append("Y");
                            }
                        }
                        System.out.println(sb1);
                    }
                }  ).start();

        new Thread       (
                new Runnable()
                {
                    public void run()
                    {
                        synchronized(sb2)
                        {
                            sb2.append("Y");
                            synchronized(sb1)
                            {
                                sb1.append("X");
                            }
                        }
                        System.out.println(sb2);
                    }
                }  ).start();
    }
}


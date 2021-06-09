package others;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenOddThread implements Runnable{
    private final Object obj1 = this;
    private List<Integer> list;

    public EvenOddThread(List<Integer> list) {
        this.list = list;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        synchronized (obj1){
            for(Integer i: list){
                String name = Thread.currentThread().getName();
                try{
                    if (i%2 == 0 && name.equals("tick")) {
                        System.out.println(name + ": " + i);
                        Thread.sleep(1000);
                        obj1.notify();
                        obj1.wait();
                    } else if(i%2 == 1 && name.equals("tock")){
                        obj1.wait();
                        System.out.println(name + ": " + i);
                        Thread.sleep(1000);
                        obj1.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args){

        List<Integer> integers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        EvenOddThread tktk = new EvenOddThread(integers);
        Thread tick = new Thread(tktk,"tick");
        Thread tock = new Thread(tktk,"tock");

        tock.start();
        tick.start();
    }



/*    public static void main(String [] args) throws InterruptedException {
        Thread thread = new Thread(() -> System.out.println(Thread.currentThread().getName() + " is doing work"));

        thread.setName("thread1");

        thread.start();
        Thread.sleep(5000);

        System.out.println(thread.getName() + " is now in the " + thread.getState() + " state");
    }*/
}

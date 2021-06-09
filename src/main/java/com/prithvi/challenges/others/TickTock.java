package others;

public class TickTock implements Runnable{
    private final Object obj1 = this;
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
            while(true){
                String name = Thread.currentThread().getName();
                //System.out.println(name);
                try {
                    if (name.equals("tick")) {
                        System.out.println("tick");
                        Thread.sleep(1000);
                        obj1.notify();
                        obj1.wait();
                    } else {
                        obj1.wait();
                        System.out.println("tock");
                        Thread.sleep(1000);
                        obj1.notify();
                    }
                }
                catch(Exception e){

                }
            }
        }

    }

    public static void main(String[] args){
        TickTock tktk = new TickTock();
        Thread tick = new Thread(tktk,"tick");
        Thread tock = new Thread(tktk,"tock");

        tock.start();
        tick.start();
    }
}

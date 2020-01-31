package others;

public class DeadLock{
    public static void main(String[] args){

        final String string1 = "Hello";
        final String string2 = "World";

        Thread t1 = new Thread( () -> {
            synchronized(string1){
                System.out.println("1 locked");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (string2){

                }
            }
        });

        Thread t2 = new Thread( () -> {
            synchronized(string2) {
                System.out.println("2 locked");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (string1) {

                }
            }
        });


        t1.start();
        t2.start();
    }
}

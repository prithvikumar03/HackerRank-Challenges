package threading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueTest {

    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);

        final Runnable producer = () -> {
          while(true){
              System.out.println("Producing a new element:" + Thread.currentThread().getName());
              try {
                  blockingQueue.add(new Random().nextInt());
                  Thread.sleep(50);
              }catch(Exception e){
                  System.out.println("Queue is full");
              }

          }
        };

        Thread producer1 = new Thread(producer);
        Thread producer2 = new Thread(producer);

        producer1.start();
        producer2.start();

        final Runnable consumer = () -> {
            while(true){
                try {
                    System.out.println("Consuming element Thread: Element:" + Thread.currentThread().getName() + ":::" + blockingQueue.take());
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println("Waiting for new element");
                }
            }
        };

        new Thread(consumer).start();
        new Thread(consumer).start();
        new Thread(consumer).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

package threading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CustomBlockingQueue<E> {

    //1. Two threads - Producer & Consumer
    //2. Producer while queue not full
    //3. Consume while queue not empty


    Queue<E> queue;
    int queueLength = 10;
    ReentrantLock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public CustomBlockingQueue(int queueLength) {
        queue = new LinkedList<E>();
        this.queueLength = queueLength;
    }

    public void putIntoQueue(E element){
            lock.lock();
            try{
                if(this.queue.size() == queueLength){
                    notFull.await();
                }
                queue.add(element);
                notEmpty.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
    }

    public E removeFromQueue(){
            lock.lock();
            try {
                while(this.queue.size() == 0){
                    System.out.println("Queue is empty " + Thread.currentThread().getName());
                    notEmpty.await();
                }
                E  remove = queue.remove();
                notFull.signalAll();

                return remove;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            return null;
    }

    public static void main(String[] args) {

        CustomBlockingQueue<String> queue = new CustomBlockingQueue<String>(5);
        Thread producer1 = new Thread(() -> {
          while(true){
              queue.putIntoQueue("producer1");
              try {
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
        });

        Thread producer2 = new Thread(() -> {
            while(true){
                queue.putIntoQueue("producer2");
                try {
                    Thread.sleep(1200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer1 = new Thread(() -> {
            while(true){
                System.out.println(queue.removeFromQueue());
                try {
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer2 = new Thread(() -> {
            while(true){
                System.out.println(queue.removeFromQueue());
                try {
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();

    }

}

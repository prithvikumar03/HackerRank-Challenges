package others;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenOddNumberPrint {
    int MAX = 20;
    int count = 0;
    boolean isOdd = false;

    synchronized void printEven() throws InterruptedException {
        while(count < MAX){
            while(!isOdd){
                System.out.println("Waiting for odd number");
                wait();
                System.out.println("Will print odd number now");
            }
            System.out.println(Thread.currentThread().getName() + "::" + count);
            count++;
            isOdd = false;
            notify();
        }
    }

    synchronized void printOdd() throws InterruptedException {
        while(count < MAX){
            while(isOdd){
                System.out.println("Waiting for even number");
                wait();
                System.out.println("Will print even number now");
            }
            System.out.println(Thread.currentThread().getName() + "::" + count);
            count++;
            isOdd = true;
            notify();
        }
    }

    public static void main(String[] args){

        EvenOddNumberPrint evenOddNumberPrint = new EvenOddNumberPrint();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(
                () -> {
                    try {
                        evenOddNumberPrint.printEven();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
        executorService.submit(
                () -> {
                    try {
                        evenOddNumberPrint.printOdd();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );

/*        Thread thread1 = new Thread(() -> {
            try {
                evenOddNumberPrint.printEven();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                evenOddNumberPrint.printOdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();*/

        executorService.shutdown();

    }
}

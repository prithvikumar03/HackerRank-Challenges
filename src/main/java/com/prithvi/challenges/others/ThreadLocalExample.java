package others;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class DateFormatContextHolder {
    public static ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z"));
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
}

public class ThreadLocalExample implements Runnable {

    @Override
    public void run() {

        String id = Thread.currentThread().getName();
        SimpleDateFormat simpleDateFormat = DateFormatContextHolder.simpleDateFormat;
        Date date = new Date(System.currentTimeMillis());
        System.out.println("Date before Formatting: " + id + " " + date);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String format = simpleDateFormat.format(new Date(System.currentTimeMillis()));
        System.out.println( id + "  " + format);
    }

    public static void main(String[] args) {
        ThreadLocalExample threadLocalExample = new ThreadLocalExample();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 20; i++) {
            executorService.submit(threadLocalExample);
            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
        executorService.shutdown();
    }
}


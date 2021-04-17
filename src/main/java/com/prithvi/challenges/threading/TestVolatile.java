package threading;

import java.util.logging.Logger;

public class TestVolatile {

    public static volatile int x = 0;
    public static boolean flag = true;

/*    public void write(){
        x = 10;
    }

    public void read(){
        int r2 = x;
        System.out.println(r2);
    }*/
    public static void main(String[] args) {



        //TestVolatile testVolatile = new TestVolatile();

        //System.out.println();
       /* Thread thread = new Thread(
                () -> {
                    int y = 0;
                    //testVolatile.write();
                    //TestVolatile.flag = false;
                    while(y<5){
                        y=x;
                        System.out.println("y is " + y);
                    }
                    flag=false;
                }
        );

        Thread thread2 = new Thread(
                () -> {
                    while(flag){
                        try {
                            System.out.println("x is" + x);
                            x++;
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );*/

        /*thread.start();
        thread2.start();*/


        new Class1().thread.start();
        new Class2().thread2.start();

    }

    /*static class Class1{
        Thread thread = new Thread(
                () -> {
                    int y = x;
                    //testVolatile.write();
                    flag = false;
                    while(x<5){
                        if(y!=x){
                            System.out.println("y is " + y);
                            y=x;
                        }
                    }
                }
        );
    }

    static class Class2{
        Thread thread2 = new Thread(
                () -> {
                    int y=x;
                    while(x<5){
                        try {
                            System.out.println("x is" + x);
                            //x=++y;
                            x++;
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
    }*/

    static class Class1{
        Logger logger = Logger.getLogger(TestVolatile.class.getName());
        Thread thread = new Thread(
                () -> {
                    int y = x; //changed
                    //testVolatile.write();
                    //TestVolatile.flag = false;
                    while(y<5){
                        /*try {
                            Thread.sleep(30);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }*/
                        //logger.info("x & y are " + (y!=x) + x + "..." + y);
                        if(y!=x) {//added
                            y = x;
                            logger.info("#####################################y is " + y);
                        }
                    }
                    flag=false;
                }
        );
    }

    static class Class2{
        Thread thread2 = new Thread(
                () -> {
                    while(flag){
                        try {
                            System.out.println("x is" + x);
                            x++;
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
    }
}

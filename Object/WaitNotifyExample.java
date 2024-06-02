package Object;


import java.lang.reflect.Executable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WaitNotifyExample {


    public static void main(String[] args) {

        Asset asset = new Asset();

        ExecutorService service = Executors.newFixedThreadPool(5);

        for(int i=0;i<5;i++){
            Runnable runnable = new Runnable() {
                public void run() {
                    synchronized (asset){
                        try {
                            System.out.println(Thread.currentThread().getName() + " enters waiting state ");
                            asset.wait();
                            System.out.println(Thread.currentThread().getName() +" EXITS waiting state" );
                        } catch (InterruptedException e) {

                            throw new RuntimeException(e);
                        }
                    }
                }
            };
            new Thread(runnable).start();
        }

        //service.shutdown();

       /* Runnable runnable = new Runnable() {
            public void run() {
                synchronized (asset){
                    try {
                        System.out.println("Thread1 enters waiting state");
                        asset.wait();
                        System.out.println("Thread1 EXITS waiting state");
                    } catch (InterruptedException e) {

                        throw new RuntimeException(e);
                    }
                }
            }
        };
        new Thread(runnable).start();
   */

        Runnable runnable = new Runnable() {
            public void run() {
                synchronized (asset){
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Thread 2 about to notify");
                        asset.notifyAll();
                }
                System.out.println("Thread 2 resume");
            }
        };
        new Thread(runnable).start();

    }
}


class Asset{

    private String name;
    private int value;


}

import java.util.concurrent.Semaphore;

public class Thed {
    Semaphore x = new Semaphore(0);
    Semaphore y = new Semaphore(0);
    Runnable a = () -> {
        System.out.println("Thread A");
        x.release();
    };
    Runnable b = () -> {
        try{
            x.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread B");
        y.release();
    };
    Runnable c = () -> {
        try{
            y.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread C");
    };
}

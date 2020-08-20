import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Curr {
    public void demo() throws ExecutionException, InterruptedException {
        Callable<Integer> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 123;
            }
            catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(task);

        System.out.println("future done? " + future.isDone());

        Integer result = future.get();

        System.out.println("future done? " + future.isDone());
        System.out.print("result: " + result);


        executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        });
    }

   public void executorDemo() {

       ExecutorService executor = Executors.newFixedThreadPool(2);
       ReentrantLock lock = new ReentrantLock();

       executor.submit(() -> {
           lock.lock();
           try {
               Util.sleep(1);
           } finally {
               lock.unlock();
           }
       });

       executor.submit(() -> {
           System.out.println("Locked: " + lock.isLocked());
           System.out.println("Held by me: " + lock.isHeldByCurrentThread());
           boolean locked = lock.tryLock();
           System.out.println("Lock acquired: " + locked);
       });

       Util.stop(executor);
   }
}

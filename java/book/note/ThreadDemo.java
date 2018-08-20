/*
Demo program to use Runnable to implement multithread program
*/
class MyThread implements Runnable{
    private int tickets = 5;
    @Override
    public void run(){
        for(int i=0; i<50; ++i){
            if(this.tickets > 0){
                System.out.println("Sell tickets " + this.tickets--);
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
}

class NewThread implements Runnable{
    Thread t;
    NewThread(){
        t = new Thread(this, "Demo Thread");//calling the run function when constructed
        System.out.println("Child thread: " + t);
        t.start();
    }

    public void run(){
        try{
            for(int i=5; i>0; --i){
                System.out.println("Child Thread: " + i);
                Thread.sleep(500);
            }
        } catch(InterruptedException e){
            System.out.println("Child interrupted.");
        }
        System.out.println("Exiting child thread");
    }
}
public class ThreadDemo{
    public static void main(String[] args) throws Exception{
        /*
        MyThread th = new MyThread();
        new Thread(th, "线程").start();
        th.run();
        */
        new NewThread();
        try{
            for(int i=5; i>0; --i){
                System.out.println("Main Thread: " + i);
                Thread.sleep(1000);
            }
        } catch(InterruptedException e){
            System.out.println("Main interrupted.");
        }
        System.out.println("Exiting main thread");
    }
}

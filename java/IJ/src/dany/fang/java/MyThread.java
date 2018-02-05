package dany.fang.java;

public class MyThread extends Thread {
    private String title;
    public MyThread(String title){
        this.title = title;
    }
    @Override
    public void run() {
        for(int i=0;i<50;i++){
            System.out.println(this.title+"run.x  "+ i);
        }
    }
}

/*
* This source code demos the proxy design pattern
* A real task is to be completed
* define a proxy class that processes all proceeding task before real task can be completed
*/

interface Subject{
    public void get();
}

//this class carries the real task to be completed
class RealSubject implements Subject{
    @Override
    public void get(){
        System.out.println("Real Subject processes the task");
    }
}

//this class carries the sub-task before the real task can be processed
class ProxySubject implements Subject{
    private Subject sub = null;
    public ProxySubject(Subject sub){
        this.sub = sub;
    }
    public void prepare(){
        System.out.println("Proxy prepares");
    }
    public void destroy(){
        System.out.println("Proxy destroys");
    }
    
    @Override
    public void get(){
        this.prepare();
        this.sub.get();
        this.destroy();
    }
}

public class Proxy{
    public static void main(String[] args){
        Subject sub = new ProxySubject(new RealSubject());
        sub.get();
    }
}

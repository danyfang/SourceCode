/*
* This demos the design pattern of Singleton
* make constructor private and make the instance final
* Wherever an instance of this class is created, they all point to an single instance (the same piece of memo)
*/

class Singleton{
    private static final Singleton INSTANCE = new Singleton();
    private Singleton(){}
    public void print(){
        System.out.println("Hello World, this is design pattern Singleton");
    }
    public static Singleton getInstance(){
        return INSTANCE;
    }
}

public class Single{
    public static void main(String[] args){
        Singleton s = Singleton.getInstance();
        s.print();
        Singleton t = Singleton.getInstance();
        t.print();
    }
}

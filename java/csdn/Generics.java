/*
* This source code demos the usage of Generics programming in Java
*/

class Message<T>{
    private T info;
    public void setInfo(T info){
        this.info = info; 
    }
    public T getInfo(){
        return this.info;
    }
}

public class Generics{
    public static void main(String[] args){
        Message<String> m = new Message<>();
        m.setInfo("Hello World");
        Message<Integer> n = new Message<>();
        n.setInfo(4);
        print(m);
        print(n);
    }

    public static void print(Message<?> msg){
        System.out.println(msg.getInfo());
    }
    public static void modify(Message<String> msg, String m){
        msg.setInfo(m); 
    }
}

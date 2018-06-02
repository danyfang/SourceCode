package dany.fang.java;
abstract class A{
    public A(){
        this.print();
    }
    public abstract void print();
}

public class Intereste extends A{
    private int data = 10;
    public Intereste(int data){
        this.data =  data;
	    this.print();
    }
    public void print(){
        System.out.println("data = "+ this.data);
    }
}

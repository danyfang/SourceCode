abstract class A{
	private String info = "Hello World";
	public void print(){
		System.out.println(info);
	}

	public abstract void get(); 
}

class B extends A{
	public void get(){
		System.out.println("Hello Xuqiang");
	}
}

public class final_{
	public static void main(String[] args){
		A a = new B();
		a.print();
		a.get();
	}
}

class A{
	public void print(){
		System.out.println("Hello, this is A");
	}	
}

class B extends A{
	public void print(){
		super.print();
		System.out.println("你好，这是B");
	}
}

public class inhe{
	public static void main(String[] args){
		B b = new B();
		b.print();
	}
}

interface A{
	public void printA();
}

interface B{
	public void printB();
}

interface C extends A,B{
	public void printC();
}

class D implements C{
	public void printA(){
		System.out.println("print A");
	}
	public void printB(){
		System.out.println("print B");
	}
	public void printC(){
		System.out.println("print C");
	}
}


public class Interface{
	public static void main(String[] args){
		C c = new D();
		c.printA();
		c.printB();
		c.printC();
	}
}

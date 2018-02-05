package dany.java.demo;

class MyMath{
	public int div(int x, int y)throws Exception{
		return x/y;
	} 	
}

public class Exe{
	public static void main(String [] args){
		try{
			System.out.println(new MyMath().div(Integer.parseInt(args[0]),Integer.parseInt(args[1])));
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("hello, exception");
		}
		try{
			throw new Exception("just for fun");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

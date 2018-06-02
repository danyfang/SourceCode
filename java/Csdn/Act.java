/*
* This source code demos the usage of template design pattern using abstract class
* abstract gives a template, all children will follow the template
*/

abstract class Action{
	public static final int EAT = 3;
	public static final int SLEEP = 5; 
	public static final int RUN = 7; 
	public static final int WORK = 9; 
	
	abstract void eat();
	abstract void sleep();
	abstract void run();
	abstract void work();

	public void Order(int flag){
		switch(flag){
		case EAT:
			this.eat();
			break;
		case SLEEP:
			this.sleep();
			break;
		case RUN:
			this.run();
			break;
		case WORK:
			this.work();
			break;
		case EAT+SLEEP:
			this.eat();
			this.sleep();
			break;
		case EAT+WORK:
			this.eat();
			this.work();
			break;
		case EAT+SLEEP+RUN:
			this.eat();
			this.sleep();
			this.run();
			break;
		case EAT+RUN+SLEEP+WORK:
			this.eat();
			this.run();
			this.sleep();
			this.work();
			break;
		}
	}
} 

class Dog extends Action{
	public void eat(){
		System.out.println("Dog eats");
	}
	public void sleep(){
		System.out.println("Dog sleeps");
	}
	public void run(){}
	public void work(){}
}

class Man extends Action{
	public void eat(){
		System.out.println("Man eats");	
	}
	public void sleep(){
		System.out.println("Man sleeps");	
	}
	public void run(){
		System.out.println("Man runs");	
	}
	public void work(){
		System.out.println("Man works");	
	}
}

class Robot extends Action{
	public void eat(){
		System.out.println("Robot eats");	
	}
	public void sleep(){}
	public void run(){}
	public void work(){
		System.out.println("Robot works");
	}
}

class Fun{
	static String str = "Hello World!";
}

public class Act{
	public static void main(String[] args){
		Action d = new Dog();
		Action m = new Man();
		Action r = new Robot();
		d.Order(Action.EAT+Action.SLEEP);	
		m.Order(Action.EAT+Action.SLEEP+Action.RUN+Action.WORK);	
		r.Order(Action.EAT+Action.WORK);	
		System.out.println(Fun.str);
	}
}

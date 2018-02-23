public class Person{
	private int age;
	private String name;
	public Person(){
		this("",32);
		System.out.println("Constructor Executed!");
	};
	public Person(String name){
		this();
		this.name = name;
	}
	public Person(String name, int age){
		this(name);
		this.age = age;
	}
	public void print(){
		System.out.println("Name"+name+"Age"+age);
	}

	public static void main(String args[]){
		Person per = new Person("Dany", 25);	
		per.print();
	}

}

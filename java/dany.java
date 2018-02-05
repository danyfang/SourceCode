class Student{
	private String name;
	private int id;
	private String country;
	private String birthday;

	public Student(String name, int id, String country, String birthday){
		this.name = name;
		this.id = id;
		this.country = country;
		this.birthday = birthday;
	}
	
	public void getInfo(){
		System.out.println("Name: "+ this.name+ " age: "+this.id+ " country: " +this.country+" birthday:" + this.birthday);
	}
	
	static	{
		System.out.println("this is a code block and it is in class Student");
	}

}
public class dany{
	public static void main(String [] args){
		Student s = new Student("方绪强",26, "中国","01-10-1991");
		s.getInfo();
		int arr[] = {12,34234,3543,543,645,645,64,756,534654};
		System.out.println(arr);
		int arr2[] = new int[]{12,21421423,432,5,345,346,4576,457,5};
		System.out.println(arr2);
		char ch = 'a';
	}	

}

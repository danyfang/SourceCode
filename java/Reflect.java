class Person{}
public class Reflect{
	public static void main(String [] args){
		Person per = new Person();
		Class <?> cls = per.getClass();
		Class <?> cls_2 = Person.class;
		System.out.println(per.getClass().getName());
		System.out.println(cls.getName());
		System.out.println(cls_2.getName());
	}
}

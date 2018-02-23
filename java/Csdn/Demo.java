class Person{
	private String name;
	private	int age;
	public String getName(){
			return name;
		};
	public	int getAge(){
			return age;
		};
	public  Person(String s){
		this(s,20);
	}
	public	Person(String s, int i){
			name = s;
			age = i;
		};
	public void setName(String s){
		name = s;
		}
	public void setAge(int i){
		age = i;
		}
	public	void tell(){
			System.out.println("Name is: "+name+" ,age is:"+age);
		};
	public  boolean compare(Person p){
		if (p == null)
			return false;
		if (this == p){
			return true;
		}
		if (this.name.equals(p.getName()) && this.age == p.getAge()){
			return true;
		}
		return false;
		
	}
}

public class Demo{
	public static void main(String[] args){
		String sss = new String("Hello World");//using constructor; can add intern() to add string into pool
		String sse = "Hello World";
		System.out.println(sse == sss);// here comparing two String, if using intern(); it is true!!!
/*
		Person  per2 = new Person("Danny", 26);
		per2.tell();
		Person per1 = new Person("Fang", 30);
		per1.tell();	
		System.out.println(per2.compare(per1));
		Person per3 = per2;
		per3.setName("Xuqiang");
		per3.tell();
		per2.tell();
		int arr[] = new int [] {23425345,436,4645654,56,756,8678,769,87,9879,8,980890,890,980,980,980,89};

		for (int i=0; i<arr.length; i++){
			System.out.println(arr[i]*arr[i]);
		}
		print(arr);
		
		toBinary(3);
		System.out.println("the end\n");
		toBinary(40);
		System.out.println("the end\n");
		System.out.println(calculate(5));
		int  bubbleArr[] = new int [] {1,3,2,6,10,0,5,8};
		bubbleSort(bubbleArr);
		print(bubbleArr);
		System.out.println("The Max number in array is "+getMax(bubbleArr));
		

		Person Pa[] = new Person[3];
		Pa[0] = new Person("张三",30);
		Pa[1] = new Person("李四",23);
		Pa[2] = new Person("王二麻子",43);
		for (int i=0; i< 3; i++){
			System.out.println(Pa[i].getName());
		}
		
		int doubleArr[][] = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		for (int i=0; i<doubleArr.length; i++){
			for (int j=0; j<doubleArr[i].length;j++){
				System.out.println(doubleArr[i][j]);
			}
		}
		exchange(doubleArr);
		for (int i=0; i<doubleArr.length; i++){
			for (int j=0; j<doubleArr[i].length;j++){
				System.out.println(doubleArr[i][j]);				
			}
		}
		String str = new String("Hello");
		String str2 = "Hello";
		System.out.println(str);
		String str3 = "Hello";	
		System.out.println(str2);
		System.out.println(str3);
		String strArr[] = new String[1000];
		for (int i=0; i<1000; i++){
			strArr[i] = "*";
		}
		for (int i=0; i<1000; i++){
			System.out.print(strArr[i]);
			if (i%50 == 0){
				System.out.println("\n");
			}
		}
		String[] sArr = {"hello", "xuqiang", "fang", "how", "are", "you"};
		System.out.println(getMax(sArr));
		System.out.println("************************************************\n");

		Person p = new Person("Xujun");
		fun(p);
		p.tell();	
*/
	}
	public static void print(int temp[]){
		for (int i=0; i<temp.length; i++)
			System.out.println(temp[i]);
	}
	public static void toBinary(int num){
		if (num == 0)
			return;
		toBinary(num/2);
		System.out.print(num%2);
	}
	public static int calculate(int num){
		if (num == 1)
			return 8;
		return 2+calculate(num-1);
	}
	public static void bubbleSort(int [] temp){
		for (int i=0; i<temp.length; i++){
			for (int j=1; j<temp.length; j++){
				if(temp[j]<temp[j-1]){
					int t = temp[j];
					temp[j] = temp[j-1];
					temp[j-1] = t;
				}
			}
		}
	}
	public static int getMax(int temp[]){
		int max = temp[0];
		for (int i=1; i<temp.length; i++){
			if(temp[i]>max){
				max = temp[i];
			}
		}
		return max;
	}
	public static String getMax(String[] temp){
		String max = temp[0];
		for (int i=1; i<temp.length; i++){
			if(temp[i].compareTo(max)>0){
				max = temp[i];
			}
		}
		return max;

	}
	public static void exchange(int temp[][]){
		for (int i=0; i<temp.length; i++){
			for (int j=i+1; j<temp[i].length;j++){
				int t = temp[i][j];
				temp[i][j] = temp[j][i];
				temp[j][i] = t;
			}
		}
 	}
	public static void fun(Person per){
		per.setName("Xuqiang Fang is not a student anymore");
	}
}

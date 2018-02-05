class isValidate{
	private String username;
	private String password;
	
	public isValidate(String username, String password){
		this.username = username;
		this.password = password;
	}  
	public isValidate(){
		this("default","default");//simply use this and no need to call constructor specifically.
	}
	/*
	class innerclass{
		private String usr = "danyfang";
		private String psw = "ilovesusie";
		innerclass(){
			if (new isValidate(usr,psw).isValid()){
				System.out.println("Inner class login successful!");
			}
		}
	}
	*/
	class innerclass{
		innerclass(){
			System.out.println("Hello World!");
			if(isValidate.this.isValid()){
				System.out.println("Login Success!");
			}
			else {
				System.out.println("Login Failure!");
			}
		}		
	}
	
	public boolean isValid(){
		if("danyfang".equals(this.username) && "ilovesusie".equals(password)){
			return true;
		}
		return false;
	}
}

class Operate{
	private String args[];
	public Operate(String args[]){
		this.args = args;
		this.exit();
	}

	public void exit(){
		if (args.length < 2){
			System.out.println("Parameter Error, must contain username and password");
			System.exit(-1);
		}
		if (new isValidate(args[0],args[1]).isValid()){
			System.out.println("Login Successful!");
		}
		else
			System.out.println("Login Failure!");
	}
}

public class LoginDemo{
	public static void main(String args[]){
		isValidate.innerclass in = new isValidate().new innerclass();
	}
	
}

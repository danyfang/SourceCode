class Emp{
	private int id;
	private String name;
	private int salary;
	
	private Emp mgr;
	private Dept dept;
	public void setId(int id){
		this.id = id;
	} 
	public int getId(){
		return this.id;
	}

	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	
	public void setSalary(int salary){
		this.salary = salary;
	}
	
	public int getSalary(){
		return this.salary;
	}
	public void setMgr(Emp mgr){
		this.mgr = mgr;
	}
	
	public void setDept(Dept dept){
		this.dept = dept;
	}
	public Dept getDept(){
		return this.dept;
	}

	public Emp(int id, String name, int salary){
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public String getInfo(){
		return "Id: "+this.id+" Name: "+this.name+" salary: "+this.salary;
	}
	
}

class Dept{
	private int depNo;
	private String depName;
	private String loc;
	private Emp[] emp;
	
	public void setdepNo(int depNo){
		this.depNo = depNo;
	}
	public int getdepNo(){
		return depNo;	
	}
	
	public void setdepName(String depName){
		this.depName = depName;
	}
	public String getdepName(){
		return depName;
	}
	
	public void setloc(String loc){
		this.loc = loc;
	}
	public String getloc(){
		return this.loc;
	}
	
	public void setEmp(Emp[] emp){
		this.emp = emp;
	}
	public Emp[] getEmp(){
		return this.emp;
	}
	
	public Dept(int depNo, String depName, String loc){
		this.depNo = depNo;	
		this.depName = depName;
		this.loc = loc;
	}
	public  String getInfo(){
		return "ID: "+ this.depNo+" Name: "+this.depName+" Location: "+this.loc;
	}
}

public class table{
	public static void main(String[] args){
		Emp empa = new Emp(1200,"张三",800);
		Emp empb = new Emp(1201,"李四",900);		
		Emp empc = new Emp(1202,"王二麻子",850);
		Emp empd = new Emp(1203,"孙七",870);
		Dept depa = new Dept(12,"采购","上海");
		empb.setMgr(empa);
		empc.setMgr(empa);
		empd.setMgr(empa);
		empa.setDept(depa);
		depa.setEmp(new Emp[] {empa,empb,empc,empd});
		System.out.println(depa.getInfo());
		for (int i=0; i<depa.getEmp().length; i++){
			System.out.println(depa.getEmp()[i].getInfo());
		}
	}

}

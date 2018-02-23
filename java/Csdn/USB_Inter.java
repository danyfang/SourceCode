interface USB{
	public void install();
	public void work();
}

class Computer{
	public void plugin(USB usb){
		usb.install();
		usb.work();
	}
}

class Phone implements USB{
	public void install(){
		System.out.println("install Phone USB");
	}

	public void work(){
		System.out.println("work Phone USB");
	}
}

class Printer implements USB{
	public void install(){
		System.out.println("install Printer USB");
	}

	public void work(){
		System.out.println("work Printer USB");
	}

}
public class USB_Inter{
	public static void main(String[] args){
		Computer c = new Computer();
		c.plugin(new Phone());
		c.plugin(new Printer());
	}
}

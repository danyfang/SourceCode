import java.net.Socket;
import java.util.Scanner;

public class Client{
	public static void main(String[] args) throws Exception{
		Socket client = new Socket("localhost", 9999);
		Scanner scan = new Scanner(client.getInputStream());
		scan.useDelimiter("\n");
		if(scan.hasNext()){
			System.out.println("What server responds" + scan.next());
		}
		scan.close();
		client.close();
	}
}

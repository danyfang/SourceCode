import java.net.ServerSocket;
import java.io.PrintStream;
import java.net.Socket;

public class Web{
	public static void main(String[] args) throws Exception{
		ServerSocket server = new ServerSocket(9999);
		System.out.println("Server starts");
		Socket client = server.accept();
		PrintStream out = new PrintStream(client.getOutputStream());
		out.println("Hello World");
		out.close();
		client.close();
		server.close();
		System.out.println("Server stops");
	}
}

import java.io.*;


public class PrintString {
    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static void main(String[] args) {
        //PrintString pr = new PrintString();
        try{
            System.out.println(PrintString.getString());
        }
        catch(Exception e)
        {
            System.out.println("Exception");
        }
        //pr.getString();
    }
}
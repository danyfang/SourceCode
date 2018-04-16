import javax.swing.JFrame;
import java.awt.Color;
class father{
    private String name;
    public void print(){
    
    }
}
class son extends father{
    public void print(){
    
    }
}


//Singleton Mode: constructor is private, get instance via static method
class Singleton{
    private static final Singleton instance = new Singleton();

    private Singleton(){}
    public static Singleton getInstance(){
        return instance;
    }
}

public class Keyword{
    public static void main(String[] args){
        Singleton ins = Singleton.getInstance();
        /*
        JFrame f = new JFrame("First Swing Instance");
        f.setSize(430,200);
        f.setBackground(Color.WHITE);
        f.setLocation(300,200);
        f.setVisible(true);
        */
        Integer var = 15;
        System.out.println(++var);
    } 
}

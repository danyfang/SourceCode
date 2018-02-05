package dany.fang.java;

public class Color {//多例设计方法
    private static final Color RED = new Color("red");
    private static final Color GREEN= new Color("green");
    private static final Color BLUE = new Color("blue");
    private String title;
    private Color(String title){
        this.title = title;
    }
    public String toString(){
        return this.title;
    }
    public static Color getInstance(int ch){
        switch (ch){
            case 0:
                return RED;
            case 1:
                return GREEN;
            case 2:
                return BLUE;
            default:
                return null;
        }
    }
}

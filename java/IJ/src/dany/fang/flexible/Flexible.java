package dany.fang.flexible;

public class Flexible<T> {
    private T x;
    private T y;
    public Flexible(T x, T y){
        this.x = x;
        this.y = y;
    }
    public Flexible(){

    }
    public void setX(T x){
        this.x = x;
    }
    public void setY(T y){
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public T getY() {
        return y;
    }
    public void print(){
        System.out.println("X = "+ this.x+ " Y = "+this.y);
    }
}

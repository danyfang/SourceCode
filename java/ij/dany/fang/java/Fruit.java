package dany.fang.java;
public interface Fruit{
    public void eat();
}
class Apple implements Fruit{
    @Override
    public void eat(){
        System.out.println("eat the apple");
    }
}
class Orange implements Fruit{
    @Override
    public void eat() {
        System.out.println("eat the orange");
    }
}
class Banana implements Fruit{
    @Override
    public void eat() {
        System.out.println("eat the banana");
    }
}

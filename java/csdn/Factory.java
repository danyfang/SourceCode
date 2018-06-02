/*
* This source codes demos the Factory design pattern
* A factory produces all products that follow a certain interface
*/

interface Fruit{
    public void eat();
}

class Apple implements Fruit{
    @Override
    public void eat(){
        System.out.println("Eat apples");
    }
}

class Orange implements Fruit{
    @Override
    public void eat(){
        System.out.println("Eat oranges");
    }
}

class Factory{
    public static Fruit getInstance(String className){
        if("APPLE".equals(className.toUpperCase())){
            return new Apple();
        }
        else if("ORANGE".equals(className.toUpperCase())){
            return new Orange();
        }
        return null;
    }    

    public static void main(String[] args){
        Fruit f = Factory.getInstance(args[0]);
        if(f != null){
            f.eat();
        }
    }
}



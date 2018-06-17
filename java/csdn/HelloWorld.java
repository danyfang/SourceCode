class HelloWorld
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        int a = 10;
        int b = 9;
        System.out.println(a+b);
        Motorcycle m = new Motorcycle();
        m.make = "Yamaha RZ350";
        m.color ="Red";
        m.startEngine();
        m.startEngine();
    }
}


class Motorcycle{
    String make;
    String color;
    boolean engineState;

    void startEngine()
    {
        if (engineState == true)
        {
            System.out.println("The engine is already on.");
        }
        else{
            engineState = true;
            System.out.println("The engine is now on.");
        }
    }
}
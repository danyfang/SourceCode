public class Execp{
    public static void main(String[] args){
        System.out.println("Before calculation");
        try{
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            int  result = x/y;
            System.out.println("Calculation result:"+result);
        } catch(ArithmeticException e){
            System.out.println(e);
        } catch(ArrayIndexOutOfBoundsException f){
            System.out.println(f);
        }
        System.out.println("After calculation");
    }
}
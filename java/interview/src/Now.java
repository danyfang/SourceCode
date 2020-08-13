import java.util.Scanner;

/*
* Nowcoder solutions, written by Xuqiang Fang in Aug, 2020
* */
public class Now {
    public void printHelloWorld(){
        System.out.println("Hello, Nowcoder");
    }


    public void readInput(){
        Scanner keyin = new Scanner(System.in);
        while(keyin.hasNextLine()) {
            String putIn = keyin.nextLine();
            System.out.println(putIn);
        }
    }
}

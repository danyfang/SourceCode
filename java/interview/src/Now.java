import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
* Nowcoder solutions, written by Xuqiang Fang in Aug, 2020
* */
public class Now {
    public void printHelloWorld(){
        System.out.println("Hello, Nowcoder");
        String ans = "Hello World";
        String[] arr = ans.split(" ");
        Set<Integer> set = new HashSet<>();
        for(int k : set){
            System.out.println(k);
        }
    }


    public void readInput(){
        Scanner keyin = new Scanner(System.in);
        while(keyin.hasNextLine()) {
            String putIn = keyin.nextLine();
            System.out.println(putIn);
        }
    }

    public static int hexToInt(String s){
        char[] ch = s.substring(2).toCharArray();
        int n = ch.length;
        int ans = 0;
        for(int i=n-1; i>=0; --i){
            int pow = n-1-i;
            if(ch[i] >= '0' && ch[i] <= '9'){
                ans += (ch[i]-'0')*Math.pow(16, pow);
            } else {
                ans += (ch[i]-'A'+10)*Math.pow(16, pow);
            }
        }
        return ans;
    }
}

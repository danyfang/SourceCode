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

    public static long dateToSeconds(String s){
        int[] mon = new int[]{0,31,28,31,30,31,30,31,31,30,31,30};
        int year = Integer.parseInt(s.substring(0, 4));
        int month = Integer.parseInt(s.substring(5,7));
        int day = Integer.parseInt(s.substring(8,10));
        int hour = Integer.parseInt(s.substring(11,13));
        int minute = Integer.parseInt(s.substring(14,16));
        int second = Integer.parseInt(s.substring(17,19));
        long ans = 0;
        for(int y=2000; y<year; ++y){
            if((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0)){
                ans += 366*24*3600;
            } else {
                ans += 365*24*3600;
            }
        }
        for(int m=1; m<=month; ++m){
            ans += mon[m-1] * 24* 3600;
            if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
                if(month > 2){
                    ans += 24 * 3600;
                }
            }
        }
        ans += (day-1) * 24 * 3600;
        ans += hour * 3600;
        ans += minute * 60;
        ans += second;
        return ans;
    }
}

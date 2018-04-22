//Leetcode problem 412 Fizz Buzz
//Solution written by Xuqiang Fang on 22 April, 2018
import java.util.Arrays;
import java.util.List;
class Solution{
    public List<String> fizzBuzz(int n){
        String[] s = new String[n];
        for(int i=0; i<n; ++i){
            s[i] = String.valueOf(i+1);
        }
        int multi = 1;
        while(multi * 3 <= n){
            s[3 * multi - 1] = "Fizz";
            multi++;
        }
        multi = 1;
        while(multi * 5 <= n){
            if(s[5 * multi - 1].equals("Fizz")){
                s[5 * multi - 1] += "Buzz";
            } 
            else{
                s[5 * multi - 1] = "Buzz";
            }
            multi++;
        }
        return Arrays.asList(s);
    }	
}

public class FizzBuzz{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.fizzBuzz(Integer.valueOf(args[0])));
	}
}

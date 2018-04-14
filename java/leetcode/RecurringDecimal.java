//Leetcode problem 166 Fraction to Recurring Integer
//Solution written by Xuqiang Fang on 12 April, 2018

import java.util.HashMap;
import java.util.Map;
class Solution{
    public String fractionToInteger(int numerator, int denominator) {
        if(numerator == Integer.MIN_VALUE && denominator == -1)
            return  String.valueOf(Integer.MIN_VALUE); 
        Map<Integer, Integer> map = new HashMap<>();
        int remain = numerator % denominator;
        if(remain == 0){
            return String.valueOf(numerator / denominator);
        }
        int index = 0;//denote the decimal index;
        int decimal = 0;//denote the decimal value;
        while(remain != 0){
            index++;
            decimal = remain * 10 / denominator;
            remain = remain * 10 % denominator;
        }
        return "";
    }	

}

public class RecurringInteger{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.fractionToInteger(Integer.valueOf(args[0]), Integer.valueOf(args[1])));
	}
}

//Leetcode problem 166 Fraction to Recurring Integer
//Solution written by Xuqiang Fang on 12 April, 2018

import java.util.HashMap;
import java.util.Map;
class Solution{
    //solution provided by user@dchen0215
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0)
            return "0";

        StringBuilder sb = new StringBuilder();
        sb.append(((numerator > 0) ^ (denominator > 0)) ? "-": "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        sb.append(num/den);
        num %= den;
        if(num == 0)
            return sb.toString();


        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(num, sb.length());
        while(num != 0){
            num *= 10;
            sb.append(num/den);
            num %= den;
            if(map.containsKey(num)){
                int index = map.get(num);
                sb.insert(index, "(");
                sb.append(")");
                break;
            }
            else{
                map.put(num, sb.length());
            }
        }
        return sb.toString();
    }	

}

public class RecurringDecimal{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.fractionToDecimal(Integer.valueOf(args[0]), Integer.valueOf(args[1])));
	}
}

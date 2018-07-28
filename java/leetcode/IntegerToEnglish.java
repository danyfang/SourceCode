//Leetcode problem 273 Integer to English Words
//Solution written by Xuqiang Fang on 28 July, 2018
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
class Solution{
    String[] unit = {"", "Thousand", "Million", "Billion"};
    String[] digit = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
                        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", 
                        "Seventeen", "Eighteen", "Nineteen"};
    String[] tenth = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public String numberToWords(int num) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        String s = String.valueOf(num);
        while(s.length() > 3){
            stack.push(Integer.parseInt(s.substring(s.length()-3)));
            s = s.substring(0, s.length()-3);
        }
        stack.push(Integer.parseInt(s));
        int size = stack.size()-1;
        while(!stack.isEmpty()){
            int prev = sb.length();
            //System.out.println(stack.peek());
            helper(stack.pop(), sb);
            if(sb.length() > prev){
                sb.append(" ");
                sb.append(unit[size--]);
            }
            else{
                size--;
            }
        }
        while(sb.charAt(sb.length()-1) == ' '){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
    private void helper(int num, StringBuilder sb){
        if(num == 0 && sb.length() > 0){
            return;
        }
        else if(num >= 100){
            if(num/100 != 0){
                if(sb.length() > 0){
                    sb.append(" ");
                }
                sb.append(digit[num/100]);
                sb.append(" Hundred");
            }
            int rest = num % 100;
            if(rest != 0){
                helper2(rest, sb);
            }
        }
        else{
            helper2(num, sb);
        }
    }
    private void helper2(int rest, StringBuilder sb){
        if(rest < 20){
            if(sb.length() > 0){
                sb.append(" ");
            }
            sb.append(digit[rest]);
        }
        else{
            int ten = rest/10;
            if(ten >= 2){
                if(sb.length() > 0){
                    sb.append(" ");
                }
                sb.append(tenth[ten-2]);
            }
            int dig = rest % 10;
            if(dig != 0){
                if(sb.length() > 0){
                    sb.append(" ");
                }
                sb.append(digit[dig]);
            }
        }
    }
}

public class IntegerToEnglish{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.numberToWords(Integer.parseInt(args[0])));
	}
}

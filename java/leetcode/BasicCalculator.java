//Leetcode problem 227 Basic Calculator II
//Solution written by Xuqiang Fang on 11 May, 2018
import java.util.Stack;
class Solution{
    public int calculate(String s){
        if(s.length() == 0)
            return 1;
        char[] ch = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for(int i=0; i<s.length(); ++i){
            if(Character.isDigit(ch[i])){
                num = num * 10 + ch[i] - '0';
            }
            if((!Character.isDigit(ch[i]) && ch[i] != ' ') || i == ch.length - 1){
                if(sign == '-'){
                    stack.push(-num);
                }
                else if(sign == '+'){
                    stack.push(num);
                }
                else if(sign == '*'){
                    stack.push(stack.pop() * num);
                }
                else if(sign == '/'){
                    stack.push(stack.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        int res = 0;
        for(int i : stack)
            res += i;
        return res;
    }
}

public class BasicCalculator{
	public static void main(String[] args){
		Solution s = new Solution();
        String S = "6*7-9/3";
        System.out.println(s.calculate(S));
	}
}

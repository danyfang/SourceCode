//Leetcode problem 224 Basic Calculator 
//Leetcode problem 227 Basic Calculator II
//Solution written by Xuqiang Fang on 11 May, 2018
import java.util.Stack;
class Solution_{
    public int calculate(String s){
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        int number = 0;
        int sign = 1;
        for(int i=0; i<s.length(); ++i){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                number = 10 * number + (c-'0');
            }
            else if(c == '+'){
                ans += sign * number;
                number = 0;
                sign = 1;
            }
            else if(c == '-'){
                ans += sign * number;
                number = 0;
                sign = -1;
            }
            else if(c == '('){
                stack.push(ans);
                stack.push(sign);
                sign = 1;
                ans = 0;
            }
            else if(c == ')'){
                ans += sign * number;
                number = 0;
                ans *= stack.pop();
                ans += stack.pop();
            }
        }
        if(number != 0){
            ans += sign * number;
        }
        return ans;
    }
}
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
        Solution_ t = new Solution_();
        String s0 = " 2-1 + 2";
        System.out.println(t.calculate(s0));
        System.out.println(s.calculate(s0));
	}
}

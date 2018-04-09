//Leetcode problem 150 Evaluate Reverse Polish Notation
//Solution written by Xuqiang Fang on 
import java.util.Stack;
class Solution{
    public int evalRPN(String[] tokens){
        if(tokens == null || tokens.length == 0)
            return -1;
        Stack<Integer> stack = new Stack<>(); 
        int a = 0;
        int b = 0;
        try{
            for(String s : tokens){
                //System.out.println("a = " + a);
                //System.out.println("b = " + b);
                switch(s){
                    case "+":
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(a + b);
                        break;
                    case "-":
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(b - a);
                        break;
                    case "*":
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(a * b);
                        break;
                    case "/":
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(b / a);
                        break;
                    default:
                        stack.push(Integer.valueOf(s));
                }
            }
        }
        catch (Exception e){}
        return stack.pop();
    }	
}

public class PolishNotation{
	public static void main(String[] args){
		Solution s = new Solution();
        String[] tokens = {"-2", "1", "+", "3", "*"};
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println(s.evalRPN(tokens));
        System.out.println(s.evalRPN(tokens2));
	}
}

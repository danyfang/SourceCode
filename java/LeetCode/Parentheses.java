//Leetcode problem 22 Generate Parantheses
//Leetcode problem 20 Valid parentheses
/*
Given n pairs of parantheses, write a function to generate all
combinations of well-formed parathenses
For example when n = 3, a solution set is:
[
"((()))",
"(()())",
"(())()",
"()(())",
"()()()",
]
*/
// Solution written by Xuqiang Fang on 27 Feb, 2018
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;
import java.lang.Integer;
import java.util.Stack;


class Solution{//solution a: brutal force, n has limit, otherwise overflow
	public List<String> generateParenthesis(int n){
		List<String> result = new ArrayList<String>();
		char[] chr = new char[2*n];
		int total = (int)Math.pow(2, 2*n);// could overflow here
		int low = (int)Math.pow(2,2*n-1);
		for(int j=low; j<total; j++){
			String binary = Integer.toBinaryString(j);
			for(int x=binary.length()-1; x>=0; x--){
				if(binary.charAt(x) == '1')
					chr[x] = '(';
				else
					chr[x] = ')'; 
			}
			String str = String.valueOf(chr);
			if(isLegal(str) && !result.contains(str)){
				result.add(str);
			}
		}
		return result;
	}

	public boolean isLegal(String a){
		if(a.charAt(0) != '('){
			return false;
		}
		int left = 0;
		int right = 0;
		for(int i=0; i<a.length(); i++){
			if(a.charAt(i) == '(')
				left++;
			else
				right++;

			if(left < right){
				return false;
			}
		}
		if(left == right)
			return true;
		else
			return false;
	}
	


	//another solution, use backtracking 
	public List<String> generateParen(int n){
		List<String> result = new ArrayList<String>();
		backtrack(result,"",0,0,n);
		return result;
	}
	public void backtrack(List<String> list, String str, int open, int close, int max){
		if(str.length() == max*2){
			list.add(str);
			return;
		}
		if(open < max){
			backtrack(list, str+"(", open+1, close, max);
		}
		if(close < open)
			backtrack(list, str+")", open, close+1, max);
	}


	public boolean isValid(String s) {
		if(s.length() % 2 != 0)
			return false;
		Stack<Character> stack = new Stack<Character>();
		for(char x: s.toCharArray()){
			if(x == '(')
				stack.push(')');
			else if(x == '[')
				stack.push(']');
			else if(x == '{')
				stack.push('}');
			else if(stack.isEmpty() || stack.pop() != x)
				return false;
		}
		return stack.isEmpty();
	}
}

public class Parentheses{
	public static void main(String[] args){
		Solution s = new Solution();
		//System.out.println(s.generateParenthesis(Integer.valueOf(args[0])));
		//System.out.println(s.generateParen(Integer.valueOf(args[0])));
		String a = "{[()]}";
		System.out.println(s.isValid(a));
	}
}

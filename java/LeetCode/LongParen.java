//Leetcode Problem 32. Longest Valid Parentheses
//Solution written by Xuqiang Fang on 27th Feb, 2018
/*
Given a string containing just '(' and ')',
return the longest valid substring length
*/
//Solution: using dynamic programming technique
//Current solution accepted

class Solution{
	public int longestValidParentheses(String s){
		if(s == null || s.length() == 0){
			return 0;
		}
		int max = 0;
		int[] dp =  new int[s.length()];
		dp[0] = 0;
		for(int i=1; i<s.length(); i++){
			if(s.charAt(i) == '('){
				continue;
			}else{
				if(s.charAt(i-1) == '('){
					if(i-2>=0){
						dp[i] = dp[i-2] + 2;
					}else{
						dp[i] = 2;
					}
				}
				if(s.charAt(i-1) == ')' && i-dp[i-1]-1 >= 0){
					if(s.charAt(i-dp[i-1]-1) == '('){
						if(i-dp[i-1]-2>=0)
							dp[i] = dp[i-1] + dp[i-dp[i-1]-2] + 2;
						else 
							dp[i] = dp[i-1] + 2;
					}
				}
			}
		}
		for(int i=0; i<s.length(); i++){
			max = dp[i] > max ? dp[i] : max;
		}
		return max;
	}
}

public class LongParen{
	public static void main(String[] args){
		Solution s = new Solution();
		String a = ")()()())";
		String b = "()"; 
		System.out.println(s.longestValidParentheses(a));
		System.out.println(s.longestValidParentheses(b));
	}
}

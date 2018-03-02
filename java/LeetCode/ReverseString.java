//Leetcode problem 344 Reverse String
//Solution written by Xuqiang Fang on 2 March 2018
/*
Given a string return the reverse of the string
*/
class Solution{
	public String reverseString(String s){
		if(s == null){
			return null;
		}
		if(s.length() <= 1){
			return s;
		}

		char[] result = new char[s.length()];
		for(int i=s.length()-1; i>=0; i--){
			result[s.length()-1-i] = s.charAt(i); 
		}
		return String.valueOf(result);
	}
}

public class ReverseString{
	public static void main(String[] args){
		Solution s = new Solution();
		String a = "Hello";
		System.out.println(s.reverseString(a));
	}
}

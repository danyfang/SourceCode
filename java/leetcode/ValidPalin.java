//Leetcode problem 680 Valid Palindrome II
//Solution written by Xuqiang Fang on 13 March 2018
/*
Given a non-empty string s, you may delete at most one character.
Judge whether you can make it a palindrome.
The string will only contain lowercase characters a-z. 
The maximum length of the string is 50000.
*/
//Solution provided by references user@
/*
The tricky part is to decide which character to delete.
*/
class Solution{
	public boolean validPalindrome(String s) {
		int l = -1, r = s.length();
		while (++l < --r) 
			if (s.charAt(l) != s.charAt(r)) return isPalindromic(s, l, r+1) || isPalindromic(s, l-1, r);
		return true;
	}

	public boolean isPalindromic(String s, int l, int r) {
		while (++l < --r) 
			if (s.charAt(l) != s.charAt(r)) return false;
		return true;
	}
}
public class ValidPalin{
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.validPalindrome(args[0]));
	}
}

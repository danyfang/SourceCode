//Leetcode problem 125 Valid Palindrome
//Solution written by Xuqiang Fang on 12 March 2018 
/*
Given a string, determine if it is a palindrome, considering only alphanumeric 
characters and ignoring cases.
For the purpose of this problem, we define empty string as valid palindrome.
*/
class Solution{
	public boolean isParlindrome(String s){
		if(s == null || s.length() == 0)
			return true;
		String str = s.replaceAll("\\W","").toLowerCase();
		for(int i=0, j=str.length()-1; i<=j; i++,j--){
			if(str.charAt(i) != str.charAt(j))
				return false;
		}
		return true;
		/*
		int low = 0;
		int high = s.length()-1;

		while(s.charAt(low) == s.charAt(high)){
			low++;
		}
		*/
	}	
}

public class ValidParlindrome{
	public static void main(String[] args){
		Solution s = new Solution();
		String str = "A man, a plan, a canal: Panama";
		String str2 = "race a car";
		System.out.println(s.isParlindrome(str));
		System.out.println(s.isParlindrome(str2));
	}
}

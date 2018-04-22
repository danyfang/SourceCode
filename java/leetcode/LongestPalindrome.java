//Leetcode problem 409 Longest Palindrome
//Solution written by Xuqiang Fang on 22 April, 2018 

class Solution{
    public int longestPalindrome(String s){
        if(s == null || s.length() == 0)
            return 0;
        int[] num = new int[56];
        char[] ch = s.toCharArray();
        for(char c : ch){
            if(c >= 'a'){
                num[28 + c - 'a']++;
            }
            else{
                num[c-'A']++;
            }
        }
        
        int length = 0;
        boolean hasOdd = false;
        for(int i : num){
            if(i > 0){
                if(i % 2 == 0){
                    length += i;
                } 
                else{
                    length += i - 1;
                    hasOdd = false;
                }
            }
        }
        if(hasOdd)
            return length+1;
        return length;
    }	
}

public class LongestPalindrome{
	public static void main(String[] args){
		Solution s = new Solution();
	}
}

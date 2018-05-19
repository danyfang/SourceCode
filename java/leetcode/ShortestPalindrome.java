//Leetcode problem  214 Shortest Palindrome
//Solution written by Xuqiang Fang on 19 May, 2018
class Solution{
    public String shortestPalindrome(String s){
        int index = 1;
        for(int i=s.length(); i>0; --i){
            if(isPalin(s.substring(0, i))){
                index = i;
                break;
            }
        } 
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1; i>=index; --i){
            sb.append(s.charAt(i)); 
        }
        sb.append(s);
        return sb.toString();
    }
    private boolean isPalin(String S){
        int l = 0;
        int r = S.length()-1;
        while(l < r){
            if(S.charAt(l++) != S.charAt(r--)){
                return false;
            }
        }
        return true;
    }
}

public class ShortestPalindrome{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.shortestPalindrome(args[0]));
	}
}

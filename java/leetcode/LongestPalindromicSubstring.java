//Leetcode problem 5 Longest Palindromic Substring
//Solution written by Xuqiang Fang on 24 May, 2018
class Solution{
    public String longestPalindrome(String s){
        if(s.length() == 0){
            return s;
        } 
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = 1;
        
        String ans = s.substring(0,1);
        for(int i=1; i<n; ++i){
            int c = dp[i-1]; 
            if(i-c-1 >= 0 && s.charAt(i-c-1) == s.charAt(i)){
                dp[i] = dp[i-1] + 2;
            }
            else{
                for(int j=i-c; j<=i; ++j){
                    if(isPalin(s.substring(j,i+1))){
                        dp[i] = i+1-j;
                        break;
                    }
                }
            }
            if(dp[i] > ans.length()){
                ans = s.substring(i-dp[i]+1, i+1);
            }
        }
        return ans;
    }

    private boolean isPalin(String s){
        int l = 0;
        int r = s.length()-1;
        while(l < r){
            if(s.charAt(l++) != s.charAt(r--)){
                return false;
            }
        }
        return true;
    }
}

public class LongestPalindromicSubstring{
	public static void main(String[] args){
		Solution s = new Solution();
        String s1 = "babad";
        String s2 = "cbbd";
        String s3 = "a";
        System.out.println(s.longestPalindrome(s1));
        System.out.println(s.longestPalindrome(s2));
        System.out.println(s.longestPalindrome(s3));
	}
}

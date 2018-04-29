//Leetcode problem 516 Longest Palindromic Subsequence
//Solution written by Xuqiang Fang on 28 April, 2018 

class Solution{
    public int longestPalindromeSubseq(String s){
        if(s == null || s.length() == 0)
            return 0;
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i=0; i<n; ++i){
            dp[i][i] = 1;
        }
        for(int i=n-2; i>=0; i--){
            for(int j=i+1; j<n; ++j){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }
                else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }

        return dp[0][n-1];
    }	
}

public class LongestPalindromicSubsequence{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.longestPalindromeSubseq(args[0]));
	}
}

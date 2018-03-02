//Leetcode problem 97. Interleaving String
//Solution provided by user@ on Leetcode using dynamic programming


/*
Given s1, s2, s3 find whether s3 is formed by the interleaving of s1 and s2
For example , given : s1 = "aabcc", s2 = "dbbca",
when s3= "aadbbcbcac" return true
when s3 = "aadbbbaccc", return false
*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution{
	public boolean isInterleave(String s1, String s2, String s3){
		if(s1.length() + s2.length() != s3.length()){
			return false;
		}
		boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
		for(int i=0; i<=s1.length(); i++){
			for(int j=0; j<=s2.length(); j++){
				if(i==0 && j==0)
					dp[i][j] = true;
				else if(i == 0)
					dp[i][j] = dp[i][j-1] && (s2.charAt(j-1) == s3.charAt(i+j-1));
				else if(j == 0)
					dp[i][j] = dp[i-1][j] && (s1.charAt(i-1) == s3.charAt(i+j-1));
				else 
					dp[i][j] = (dp[i-1][j] && (s1.charAt(i-1) == s3.charAt(i+j-1)) ||
					(dp[i][j-1] && (s2.charAt(j-1) == s3.charAt(i+j-1))));
			}
		}
		return dp[s1.length()][s2.length()];
	}
}

public class Interleave{
	public static void main(String[] args){
		Solution s = new Solution();
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		String s4 = "aadbbbaccc";
		System.out.println(s.isInterleave(s1,s2,s3));
		System.out.println(s.isInterleave(s1,s2,s4));
	}
}
/*
It feels like this problem is set for dynamic programming
with dynmaic programming the logic is so clear and easy!
*/

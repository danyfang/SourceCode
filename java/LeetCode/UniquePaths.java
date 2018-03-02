//Leetcode problem 62. Unique Paths
//Solution written by Xuqiang Fang on 1 March, 2018
/*
Problem Description:
A robot is located at the top-left coner of a m*x grid
it can only move either down or right to reach the bottom right
How many possible unique paths are there?
*/

class Solution{
	public int uniquePaths(int m, int n){
		if(m==0 && n==0){
			return 0;
		}
		int[][] dp = new int[m][n];
		for(int i=0; i<m; i++){
			dp[i][0] = 1;
		}
		for(int j=0; j<n; j++){
			dp[0][j] = 1;
		}

		for(int i=1; i<m; i++){
			for(int j=1; j<n; j++){
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}

		return dp[m-1][n-1];
	}
}

public class UniquePaths{
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.uniquePaths(0,0));

	}
}

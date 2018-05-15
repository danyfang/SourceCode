//Leetcode problem 583 Delete Operation for Two Strings
//Solution written by Xuqiang Fang on 15 May, 2018
class Solution{
    public int minDistance(String word1, String word2){
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1; i<=m; ++i){
            dp[i][0] = i;
        }
        for(int j=1; j<=n; ++j){
            dp[0][j] = j;
        }

        for(int i=1; i<=m; ++i){
            for(int j=1; j<=n; ++j){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j]+1, dp[i][j-1]+1), dp[i-1][j-1]+2);
                }
            }
        }

        return dp[m][n];
    }
}

public class DeleteOperation{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.minDistance(args[0], args[1]));
	}
}

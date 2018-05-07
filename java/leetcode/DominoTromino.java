//Leetcode problem 790 Domino and Tromino Tiling
//Solution written by Xuqiang Fang on 6 May, 2018
/*
dp[i][0] ways to cover i cols, both rows of i are covered
dp[i][1] ways to cover i cols, only top row is covered
dp[i][2] ways to cover i cols, only bottom row is covered
*/
class Solution{
    public int dominoTromino(int N){
        int mod = 100000007;
        long[][] dp = new long[N+1][2];
        dp[0][0] = dp[1][0] = 1;
        for(int i=2; i<=N; ++i){
            dp[i][0] = (dp[i-1][0] + dp[i-2][0] + 2*dp[i-1][1])%mod;
            dp[i][1] = (dp[i-2][0] + dp[i-1][1])%mod;
        }

        return (int)dp[N][0];
    }
}

public class DominoTromino{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.dominoTromino(Integer.valueOf(args[0])));
	}
}

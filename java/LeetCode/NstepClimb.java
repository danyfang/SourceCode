//Leetcode problem 70 CLimbing stairs
//Solution written by Xuqiang Fang on 1 March 2018

/*
Climbing stairs , each time can take 1 or 2 steps, total n steps.
How many different ways to climb it?
*/
/*
I spent like an hour for this problem and it turns out my solution was too 
complicated and there is a very simple dynamic programming solution

*/
import java.lang.Integer;

class Solution {
	public int climbStairs(int n){
		if(n <= 3)
			return n;

		long[][] dp = new long[n/2+1][n+1];
		for(int i=0; i<=n/2; i++){
			dp[i][2*i] = 1;
			for(int j=2*i+1; j<=n; j++){
				if(i == 0){
					dp[i][j] = 1;
				}else{
					dp[i][j] = dp[i][j-1]*(j-i)/(j-2*i) ;
				}

			}
		}
		/*
		for(int i=0; i<=n/2; i++){
			for(int j=0; j<=n; j++){
				System.out.print(dp[i][j]);
			}
			System.out.println("\n");
		}
		*/
		int sum = 0;
		for(int i=0; i<=n/2; i++){
			sum += (int)dp[i][n];
		}

		return sum;
	}
	//another solution very simple
	public int climbStairs_(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

public class NstepClimb{
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.climbStairs(Integer.valueOf(args[0])) ==
		s.climbStairs_(Integer.valueOf(args[0])));
	}
}

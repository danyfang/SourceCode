//Leetcode problem 746 Min Cost Climbing Stairs
//Solution written by Xuqiang Fang on 1 May, 2018 

class Solution{
    public int minCostClimbingStairs(int[] cost){
        int n = cost.length;//n >= 2
        int[] dp = new int[n];
        //dp[i] means minimum cost from step i to the top
        dp[n-1] = cost[n-1];
        dp[n-2] = cost[n-2];
        for(int i=n-3; i>=0; --i){
            dp[i] = cost[i] + Math.min(dp[i+1], dp[i+2]);
        }

        return Math.min(dp[0], dp[1]);
    }	
}

public class ClimbingStairs{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        int[] cost1 = {10,15,20};
        System.out.println(s.minCostClimbingStairs(cost));
        System.out.println(s.minCostClimbingStairs(cost1));
	}
}

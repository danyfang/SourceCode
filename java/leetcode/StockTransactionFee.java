//Leetcode problem 714 Best Time to Buy and Sell Stock With Transaction Fee
//Solution written by Xuqiang Fang on 1 May, 2018

class Solution{
    public int maxProfit(int[] prices, int fee){
        //dp[i][j] means max profit for subarray[0,i] and exact j transactions without considering fees
        int n = prices.length;
        int m = n/2;
        int[][] dp = new int[m+1][n+1];
        for(int i=1; i<=m; ++i){
            dp[i][2*i] = prices[2*i-1]-prices[2*i-2] + dp[i-1][2*i-2];        
        }
        int maxProfit = 0;
        for(int i=1; i<=m; ++i){
            for(int j=2*i+1; j<=n; ++j){
                 
            }
            maxProfit = Math.max(maxProfit, dp[i][n]-fee*i);
        }

        return maxProfit;
    }	
}

public class StockTransactionFee{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] prices = {1,3,2,8,4,9};
        System.out.println(s.maxProfit(prices, 2));
	}
}

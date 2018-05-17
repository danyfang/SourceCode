//Leetcode problem 309 Best Time to Buy and Seel Stock with Cooldown
//Solution written by Xuqiang Fang on 16 May, 2018
class Solution{
    // there are three states, hold, sold and rest(includes cooldown)
    /**
    hold[i] = max(hold[i-1], rest[i-1]-prices[i])
    sold[i] = hold[i-1] + prices[i]
    rest[i] = max(res[i-1], sold[i-1])
    init rest[0] = sold[0] = 0
    hold[0] = -inf
    ans = max(rest[i], sold[i]);
    */

    public int maxProfit(int[] prices){
        int n = prices.length;
        int sold = 0;
        int rest = 0;
        int hold = Integer.MIN_VALUE;
        for(int i=0; i<n; ++i){
            int prev = sold;
            sold = hold + prices[i];
            hold = Math.max(hold, rest-prices[i]);
            rest = Math.max(rest, prev);
        }

        return Math.max(rest, sold);
    }
}

public class StockCooldown{
	public static void main(String[] args){
		Solution s = new Solution();
	}
}

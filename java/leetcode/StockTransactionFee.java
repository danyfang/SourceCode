//Leetcode problem 714 Best Time to Buy and Sell Stock With Transaction Fee
//Solution written by Xuqiang Fang on 16 May, 2018

class Solution{
    public int maxProfit(int[] prices, int fee){
        int t0 = 0;
        int t1 = Integer.MIN_VALUE;
        for(int price : prices){
            int t0_old = t0;
            t0 = Math.max(t0, t1 + price);
            t1 = Math.max(t1, t0_old - price -fee);
        }
        return t0;
    }	
}

public class StockTransactionFee{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] prices = {1,3,2,8,4,9};
        System.out.println(s.maxProfit(prices, 2));
	}
}

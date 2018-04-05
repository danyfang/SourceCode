//Leetcode problem 121 Best Time To Buy and Sell Stock
//Leetcode problem 122 Best Time To Buy and Sell Stock II
//Leetcode problem 123 Best Time To Buy and Sell Stock III
//Solution written by Xuqiang Fang on 5 April, 2018 

class Solution{
    /*
    following explanation provided by user@andyreadsall
    max subarray problem using Kadane's algorithm
    the logic is to calculate the difference : maxCur += prices[i] - prices[i-1]
    if the difference falls below 0, reset it to zero.
    public int maxProfit(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
    */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 0)  
            return 0;
        int low = prices[0];
        int profit = 0;
        for(int i=1; i<prices.length; i++){
            low = Math.min(low, prices[i]);
            profit = Math.max(prices[i]-low, profit);
        }
        return profit;
    }	

    public int maxProfit2(int[] prices){
        if(prices == null || prices.length <= 0)
            return 0;
        int profit = 0;
        int low = prices[0];
        int prev = prices[0];
        int temp = 0;
        for(int i=1; i<prices.length; i++){
            if(prices[i] > prev)
                temp = prices[i] - low;
            else{
                low = prices[i];
                profit += temp;
                temp = 0;
            }
            prev = prices[i];
        }
        profit += temp;
        return profit;
    }
    /*
    The idea is to find two highest points
    */
    public int maxProfit3(int[] prices){
        if(prices == null || prices.length <= 1)
            return 0;
        int index1 = 0;//the second biggest
        int index2 = 0;//the biggest
        int max = prices[0];
        int low = prices[0];
        for(int i=1; i<prices.length; i++){
            if(prices[i] > max){
                index2 = i;
                max = prices[i];
            } 
            low = prices[i] >= low ? low : prices[i];
        }
        System.out.println("index2 = " + index2);
        max = low;
        for(int i=0; i<prices.length; i++){
            if(prices[i] > max && i != index2){
                index1 = i;
                max = prices[i];
            }
        }
        System.out.println("index1 = " + index1);
        int profit = 0;
        int small = Math.min(index1, index2);
        int big = index1 + index2 - small;
        for(int i=0; i<=small; i++){
            int temp = prices[small] - prices[i];
            profit = profit > temp ? profit : temp;
        }
        int second = 0;
        for(int i=small; i<=big; i++){
            int temp = prices[big] - prices[i];
            second = second > temp ? second : temp;
        }
        profit += second;
        int maxCur = 0, maxSoFar = 0;
        for(int i = big+1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        profit += maxSoFar;
        return profit;
    }
}

public class StockPrice{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] prices = {7,1,5,3,6,4,5};
        int[] prices2 = {7,6,4,3,1};
        int[] p = {1,7,4,6,3,7,23,43,4,32,4,23,3,23,23,23,2,32,44,4,5,5,6,7};
        int[] p2 = {4,1,2};
        int[] p3 = {2,1,2,0,1};
        System.out.println(s.maxProfit3(p));
        //System.out.println(s.maxProfit(prices2));
	}
}

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
    //Solution provided by user@small_box
    /*
    From the chart and figure of variables in each step, we can see that
    lowestBuyPrice1 is always the lowest price in the input array, maxProfit1
    keeps track of the biggest difference between prices and lowest price so far,
    value change of lowestBuyPrice2 reflects the local valley in the input 
    prices array and variable maxProfit2 maintains the maximum profit until 
    the current price.
    lowestBuyPrice1 and maxProfit1 are easy to understand. But how does 
    lowestBuyPrice2 and maxProfit2 works? First, we shall see that lowestBuyPrice2
    decreases whenever we hit a local minimum price. It indirectly (since it 
    is negative) reflects the lowest price that is closest to the current
    price. When the current price is bigger than -lowestBuyPrice2, 
    maxProfit2i = price i - (price (i-1) -maxProfit1 (i-1))=
    price i - price (i-1) +maxProfit1 (i-1), which means the 
    accrued maximum profit until now.
    */
    /*
    I came up with another explanation for this beautifully intended piece of 
    code. We are allowed at most two operations(one buy one sell is an operation)

    Suppose the price goes up all the way to the end, in this case, it's easy 
    to consider because we just buy at the beginning and sell it at the end,
    that is, one operation we get the maximum profit.

    Now if the price reaches a highest point and then decreases all the way to the
    end, this is also easy to consider because we also want just one operation.
    After the highest point, we don't buy any stocks.

    Now the tricky case is after a high point, it goes down and then goes up,
    and many up and downs can follow after this.
    */
    public int maxProfit3(int[] prices){
        int maxProfit1 = 0;
        int maxProfit2 = 0;
        int lowestBuyPrice1 = Integer.MAX_VALUE;
        int lowestBuyPrice2 = Integer.MAX_VALUE;
        for(int p : prices){
            maxProfit2 = Math.max(maxProfit2, p-lowestBuyPrice2);
            lowestBuyPrice2 = Math.min(lowestBuyPrice2, p - maxProfit1);
            maxProfit1 = Math.max(maxProfit1, p-lowestBuyPrice1);
            lowestBuyPrice1 = Math.min(lowestBuyPrice1, p);
        }
        return maxProfit2;
    }

    public int maxProfit4(int k, int[] prices){
        int[][] dp = new int[k+1][prices.length];
        if (k >= prices.length / 2) return quickSolve(prices);
        for(int i=0; i<prices.length; i++){
            dp[0][i] = 0;
        }
        for(int i=0; i<=k; i++){
            dp[i][0] = 0;
        }
        int maxdiff = 0;
        for(int i=1; i<=k; i++){
            maxdiff = dp[i-1][0] - prices[0];
            for(int j=1; j<prices.length; j++){
                dp[i][j] = Math.max(dp[i][j-1], maxdiff+prices[j]);
                maxdiff = Math.max(maxdiff, dp[i-1][j] - prices[j]);
            }
        }
        for(int i=0; i<=k; i++){
            for(int j=0;j<prices.length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println("\n");
        }

        return dp[k][prices.length-1];
    }
    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
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
        int[] p4 = {2,5,7,1,4,3,1,3};
        System.out.println(s.maxProfit4(p, 19));
        //System.out.println(s.maxProfit(prices2));
	}
}

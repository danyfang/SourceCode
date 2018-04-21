//Leetcode problem 322 Coin Change
//Solution written by Xuqiang Fang on  18 April, 2018
import java.util.Arrays;
class Solution{
    public int coinChange(int[] coins, int amount){
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        int min = amount;
        for(int i : coins){
            min = Math.min(i, min);
        }
        dp[0] = 0;
        for(int i=1; i<=amount; i++){
            if(i < min){
                dp[i] = -1;
                continue;
            }
            for(int j=0; j<coins.length; j++){
                if(i - coins[j] >= 0 ){
                    if(i % coins[j] == 0){
                        dp[i] = Math.min(i/coins[j],dp[i]);
                    }
                    if(dp[i-coins[j]] != -1)
                        dp[i] = Math.min(dp[i-coins[j]] + 1, dp[i]);
                }
            } 
            if(dp[i] == amount+1)
                dp[i] = -1;

        }

        return dp[amount];
    }	

}

public class CoinChange{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] coins = {186,419,83,408};
        System.out.println(s.coinChange(coins, Integer.valueOf(args[0])));
	}
}

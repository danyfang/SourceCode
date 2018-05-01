//Leetcode problem 650 2 Keys Keyboard
//Solution written by Xuqiang Fang on 1 May, 2018

class Solution{
    public int minSteps(int n){
        int[] dp = new int[n+1];
        //dp[0] and dp[1] are both 0
        //dp[i] denotes the minimum steps to get n characters
        for(int i=2; i<=n; ++i){
            dp[i] = i;
            for(int j=1; j<i; ++j){
                if(i % j == 0){
                    dp[i] = Math.min(dp[i], dp[j] + i/j);
                }
            }
        }
        return dp[n];
    }	
}

public class TwoKeysKeyboard{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.minSteps(Integer.valueOf(args[0])));
	}
}

//Leetcode problem No 300 Longest Increasing Subsequence
//Solution written by Xuqiang Fang on 23 April, 2018 

class Solution{
    public int lengthOfLIS(int[] nums){
        if(nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;

        for(int i=1; i<n; ++i){
            for(int j=0; j<i; ++j){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i]++;
            max = Math.max(dp[i], max);
            System.out.println(dp[i]);
        }

        return max;
    }	
}

public class LongestIncreasingSub{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(s.lengthOfLIS(nums));
	}
}

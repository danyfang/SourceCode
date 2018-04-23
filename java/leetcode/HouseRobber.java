//Leetcode problem 198 House Robber
//Leetcode problem 213 House Robber II
//Solution written by Xuqiang Fang on 11 April, 2018 

class Solution{
    public int helper(int[] nums){
        if(nums == null || nums.length == 0)
            return 0;
        //dp[i] stores the largest benefit until i
        int[] dp = new int[nums.length];
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.max(nums[0], nums[1]);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<nums.length; i++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]); 
        }

        return dp[nums.length-1];
    }	
    public int rob(int[] nums){
        if(nums == null || nums.length == 0)
            return 0;

        return 0;
    }
}

public class HouseRobber{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {1,2,3,4,5,6,7};
        System.out.println(s.rob2(nums));
	}
}

//Leetcode problem 494 Target Sum
//Solution written by Xuqiang Fang on 4 April

class Solution{
    //Solution exceeded time limit
    public int findTargetSumWays_(int[] nums, int S){
        if(nums == null || nums.length <= 0)
            return 0;
        int max = 0, min = 0;
        for(int i=0; i<nums.length; i++){
            max += nums[i];
            min -= nums[i];
        }
        if (S > max || S < min)
            return 0;
        int count = 0; 
        for(int i=0; i<Math.pow(2, nums.length); i++){
            String str = Integer.toBinaryString(i + (int)Math.pow(2, nums.length));
            str = str.substring(str.length()-nums.length, str.length());
            int target = S;
            for(int j=0; j<nums.length; j++){
                if(str.charAt(j) == '1'){
                   target += nums[j]; 
                }else{
                    target -= nums[j];
                }
            }

            if(target == 0)
                count++;
        }
        return count;
    }	
    
    //Solution provided by user@yuxiangmusic
    public int findTargetSumWays(int[] nums, int s){
        int sum = 0;
        for(int n : nums){
            sum += n;
        }
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s+sum)>>1);
    }
    //This DP solution really stands out
    public int subsetSum(int[] nums, int s){
        int[] dp = new int[s+1];
        dp[0] = 1;
        for(int n: nums){
            for(int i=s; i>=n; i--){
                dp[i] += dp[i-n];
            }
        }
        return dp[s];
    }
}

public class TargetSum{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.findTargetSumWays(new int[]{1,1,1,1,1}, 3));
	}
}

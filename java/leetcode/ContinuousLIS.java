//Leetcode problem 674 Longest Continuous Increasing Subsequence
//Solution written by Xuqiang Fang on 2 May, 2018 

class Solution{
    public int findLengthOfLCIS(int[] nums){
        int max = 0;
        if(nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        for(int i=0; i<n; ++i){
            int temp = 1;
            while(i<n-1 && nums[i+1]>nums[i]){
                temp++;
                i++;
            }
            max = Math.max(temp, max);
        }
        return max;
    }	
}

public class ContinuousLIS{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {1,3,5,4,7};
        System.out.println(s.findLengthOfLCIS(nums));
	}
}

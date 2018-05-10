//Leetcode problem 643 Maximum Average Subarray I
//Solution written by Xuqiang Fang on 10 May, 2018
class Solution{
    public double findMaxAverage(int[] nums, int k){
        int n = nums.length;
        double max = 0;
        for(int i=0; i<k; ++i){
            max += nums[i];
        }
        double window = max;
        for(int i=k; i<n; ++i){
            window += nums[i] - nums[i-k];
            max = Math.max(max, window);
        }

        return max / k;
    }
}

public class MaximumAverageSubarray{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {1,12,-5,-6,50,3};
        System.out.println(s.findMaxAverage(nums, 4));
	}
}

//Leetcode problem 724 Find Pivot Index
//Solution written by Xuqiang Fang on  24 March 2018

class Solution{
	public int pivotIndex(int[] nums){
		if(nums == null || nums.length <= 0)
			return -1;
		if(nums.length == 1)
			return 0;
		int[] sum = new int[nums.length];	
		sum[0] = nums[0];
		for(int i=1; i<nums.length; i++){
			sum[i] = sum[i-1] + nums[i]; 
		}
		int total = sum[nums.length-1];
		if(total - sum[0] == 0)
			return 0;
		for(int i=1; i<nums.length; i++){
			if(sum[i-1] == total - sum[i])
				return i;
		}
		return -1;
	}	
}

public class PivotIndex{
	public static void main(String[] args){
		Solution s = new Solution();
		int[] nums = {1,7,3,6,5,6};
		int[] nums2 = {1,1,1,2};
		System.out.println(s.pivotIndex(nums));
		System.out.println(s.pivotIndex(nums2));
	}
}

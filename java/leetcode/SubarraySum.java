//Leetcode problem 560 Subarray Sum Equals K
//Solution written by Xuqiang Fang on 24 March 2018 
//Solution accepted
class Solution{
	public int subarraySum(int[] nums, int k){
		if(nums == null || nums.length == 0)
			return 0;
		int[] sum = new int[nums.length];
		sum[0] = nums[0];
		for(int i=1; i<nums.length; i++){
			sum[i] = nums[i] + sum[i-1];
		}
		
		int count = 0;
		for(int i=nums.length-1; i>=0; i--){
			if(sum[i] == k)
				count++;
			for(int j=0; j<i; j++){
				if(sum[i]-sum[j] == k)
					count++;
			}	
		}
		return count;
	}	
}

public class SubarraySum{
	public static void main(String[] args){
		Solution s = new Solution();
		int[] nums = {1,1,1,4,3,3,2,2,3,3,5,6,5,7,4,9,3,8,5,3,2,6};
		System.out.println(s.subarraySum(nums,16));
		//System.out.println(Integer.MAX_VALUE);
	}
}

//Leetcode problem 152 Maximum Product Subarray
//Solution written by Xuqiang Fang on 21 March 2018 
//Leetcode problem 712 Subarray Product less than K
class Solution{
	public int maxProduct(int[] nums){
		int max = nums[0];
		int start_i = nums[0];
		for(int i=0; i<nums.length; i++){
			start_i = nums[i];
			max = start_i > max ? start_i : max;
			for(int j=i+1; j<nums.length; j++){
				start_i *= nums[j];	
				max = start_i > max ? start_i : max;
			}
		}
		return max;
	}	
	//another dynamic programming solution
	public int maxP(int[] nums){
		int r = nums[0];

		for(int i=1, max=r, min=r; i<nums.length; i++){
			if(nums[i] < 0){
				max = max + min;
				min = max - min;
				max = max - min;
			}

			max = Math.max(max*nums[i], nums[i]);
			min = Math.min(min*nums[i], nums[i]);
			r = Math.max(r, max);
		}
		return r;
	}
	//following solution exceeded the time limit
	public int numSubarrayProductLessThanK_(int[] nums, int k) {
    	int count = 0;
		int n = nums.length;
		if(n ==0 || nums == null)
			return count;
		int start_i = nums[0];
		for(int i=0; i<n; i++){
			start_i = nums[i];
			if(start_i < k)
				count++;
			for(int j=i+1; j<n; j++){
				start_i *= nums[j];
				if(start_i < k)
					count++;
				else 
					break;
			}
		}
		return count;
    }
	//this solution is provided by user@alexander
	public int numSubarrayProductLessThanK(int[] nums, int k) {
		int count = 0;
		int n = nums.length;
		if(n == 0 || nums == null || k == 0)
			return count;

		int product = 1;
		for(int i=0, j=0; i<n; i++){
			product *= nums[i];
			while(j <= i && product >= k){
				product /= nums[j++];
			}
			count += i - j + 1;
		}
		return count;
	}
}

public class MaximumProduct{
	public static void main(String[] args){
		Solution s = new Solution();
		/* test for maxProduct
		int[] nums = {2,3,-2,4};
		System.out.println(s.maxP(nums));
		System.out.println(s.maxProduct(nums));
		*/
		
		int[] nums = {10,5,2,6};
		System.out.println(s.numSubarrayProductLessThanK(nums, 100));
	}
}

//Leetcode problem 238 Product of Array Except Self
//Solution written by Xuqiang Fang on 21 March 2018 
// The solution is provided by user@lycjava3
class Solution{
	public int[] productExceptSelf(int[] nums){
		int n = nums.length;
		int[] output = new int[n];	
		output[0] = 1;
		for(int i=1; i<n; i++){
			output[i] = output[i-1] * nums[i-1];
		}
		int right = 1;
		for(int i=n-1; i>=0 ;i--){
			output[i] *= right;
			right *= nums[i];
		}
		return output;
	}	
}

public class ProductArray{
	public static void main(String[] args){
		Solution s = new Solution();
		int[] nums = {1,2,3,4};
		print(s.productExceptSelf(nums));
	}
	public static void print(int[] nums){
		for(int i : nums){
			System.out.println(i);
		}
	}
}

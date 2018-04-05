//Leetcode problem 189 Rotate Array
//Solution written by Xuqiang Fang on 21 March 2018 
//Solution accepted
class Solution{
	public void rotate(int[] nums, int k){
		int[] back = new int[k];
		int n = nums.length;
		k = k % n;
		for(int i=n-k; i<n; i++){
			back[i+k-n] = nums[i];  
		}
		for(int i=n-1; i>=k; i--){
			nums[i] = nums[i-k];
		}
		for(int i=0; i<k; i++){
			nums[i] = back[i];
		}
	}	
}

public class RotateArray{
	public static void main(String[] args){
		Solution s = new Solution();
		int[] nums = {-1};
		s.rotate(nums, 2);
		print(nums);
	}
	public static void print(int[] nums){
		for(int i : nums){
			System.out.println(i);
		}
	}
}

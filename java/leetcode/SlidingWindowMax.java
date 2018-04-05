//Leetcode problem 239 Sliding Window Maximum
//Solution written by Xuqiang Fang on 26 March 2018 

class Solution{
	public int[] maxSlidingWindow(int[] nums, int k){
		int n = nums.length;
		int pos = 0;//to keep the latest max value's position, 
		//relative to the window left
		int max = 0;//to keep the max value in the window
		int[] result = new int[n-k+1];
		/*
		for(int i=0; i<k; i++){
			if(nums[i] >= max){//it's important to include case =
				max = nums[i];
				pos = i;
			}
		}
		result[0] = max;
		*/
		for(int i=0; i<=n-k; i++){
			pos--;
			if(pos < 0){
				max = nums[i];
				for(int j=i; j<i+k; j++){
					if(nums[j] >= max){
						max = nums[j];
						pos = j-i;
					}
				}
			}else{
				if(nums[i+k-1] >= max){
					max = nums[i+k-1];
					pos = k-1;
				}
			}
			result[i] = max;
		}
		return result;
	}	
}

public class SlidingWindowMax{
	public static void main(String[] args){
		Solution s = new Solution();
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int[] result = s.maxSlidingWindow(nums, 3);
		for(int i=0; i<result.length; i++)
			System.out.println(result[i]);
	}
}

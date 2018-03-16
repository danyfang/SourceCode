//Leetcode problem 75 Sort Colors
//Solution written by Xuqiang Fang on 6 March 2018
/*
Given an array with n objects colored red, white or blue, sort them 
so that objects of the same color are adjacent, with the colors in
the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red,
white, and blue respectively.
*/
//solution accepted!
class Solution{
	public void sortColors(int[] nums){
		int zero = 0;
		int one = 0;
		int two = 0;
		for(int i=0; i<nums.length; i++){
			if(nums[i] == 0)
				zero++;
			if(nums[i] == 1)
				one++;
			if(nums[i] == 2)
				two++;
		}
		for(int i=0; i<nums.length; i++){
			if(i<zero)
				nums[i] = 0;
			else if(i<zero+one)
				nums[i] = 1;
			else 
				nums[i] = 2;
		}
	}	
}

public class SortColor{
	public static void main(String[] args){
		Solution s = new Solution();
		int[] nums = {1,2,0,0,1,1,2,0,2,1,0,2,2,0,1,2};
		s.sortColors(nums);
		for(int i=0; i<nums.length; i++){
			System.out.println(nums[i]);
		}
	}
}

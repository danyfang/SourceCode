//Leetcode problem 136. Single Number
//Solution written by Xuqiang Fang on 5 March 2018 
/*
Given an array of integers, every element appears twice except for one.
Find that single one.
Solve it in linear time and without extra memory
*/
// This XOR operation is awesome
class Solution{
	public int singleNumber(int[] nums){
		//
		int result = 0;
		for(int i=0; i<nums.length; i++){
			result ^= nums[i];
		}
		return result;
	}	
}

public class SingleNumber{
	public static void main(String[] args){
		Solution s = new Solution();
		int[] nums = new int[]{1,1,8,3,3,4,4,5,5};
		System.out.println(s.singleNumber(nums));
	}
}

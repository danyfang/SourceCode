//Leetcode problem 41. First missing positive
//solution written by Xuqiang Fang on 22 Feb, 2018


class Solution {
    public int firstMissingPositive(int[] nums) {
		if(nums == null || nums.length == 0){
			return 1;
		}   
		int max = 0;
		for(int i=0; i<nums.length; i++){
			max = max > nums[i] ? max:nums[i];
		}
		max = max > nums.length ? max:nums.length;
		int[] flag = new int[max+1];
		int result = 1;
		for(int i=0; i<flag.length; i++){
			flag[i] = i;
		}
		for(int i=0; i<flag.length; i++){
			if(i<nums.length && nums[i]>=0){
				flag[nums[i]] = 0;
			}
		}
		for(int i=1; i<flag.length; i++){
			if(flag[i] != 0){
				result = i;
				return result;
			}
			else{
				result++;
			}
		}
		return result;
    }
}

public class PositiveMiss{
	public static void main(String[] args){
		Solution s = new Solution();
		int[] test = {1,2,0,3,5,8};
		int[] test2 = {3,4,-1,1};
		int[] test3 = {2};
		int[] test4 = {2,1};
		System.out.println(s.firstMissingPositive(test));
		System.out.println(s.firstMissingPositive(test2));
		System.out.println(s.firstMissingPositive(test3));
		System.out.println(s.firstMissingPositive(test4));
	}
}

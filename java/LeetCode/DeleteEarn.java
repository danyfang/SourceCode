//Leetcode problem 740 Delete and earn
//Solution written by Xuqiang Fang on 1 March, 2018

/*
Given an array nums of integers, you can perform operations on the array.
In each operation, you pick any nums[i] and delete it to earn nums[i] points.
After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.

You start with 0 points. Return the maximum number of points you can earn
by applying such operations.
*/

class Solution{
	public int deleteAndEarn(int[] nums){
        //length of nums is at most 20000
        //elements nums[i] is between [1,10000]
        if(nums == null || nums.length == 0)
            return 0;
        int max = 0;
        for(int i : nums){
            max = Math.max(i, max);
        }
        int[] array = new int[max+1];
        for(int i : nums){
            array[i] += i;
        }
        if(max == 1)
            return array[1];
        for(int i=3; i<=max; i++){
            array[i] = Math.max(array[i-3], array[i-2]) + array[i];
        }
        return Math.max(array[max], array[max-1]);
	}	
}

public class DeleteEarn{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {1,1,1,1,1};
        System.out.println(s.deleteAndEarn(nums));
	}
}
